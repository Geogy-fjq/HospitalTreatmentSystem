package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_01patientsDao1;
import Dao.po_14registrationformDao1;
import Dao.po_15medicalrecordformDao1;
import Dao.vo_3consultDao1;
import PoVo.po_15medicalrecordform;
import PoVo.po_16homepageofmedicalrecord;

/**
 * Servlet implementation class saveServlet
 */
@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	vo_3consultDao1 consultDao1=new vo_3consultDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		//获得jsp中的数据
		String name=request.getParameter("name");
		String chiefComplaint=request.getParameter("chiefComplaint");
		String currentMedicalHistory=request.getParameter("currentMedicalHistory");
		String currentMedicalTreatment=request.getParameter("currentMedicalTreatment");
		String pastHistory=request.getParameter("pastHistory");
		String allergyHistory=request.getParameter("allergyHistory");
		String physicalExamination=request.getParameter("physicalExamination");
		String preliminaryDiagnosisCategory=request.getParameter("preliminaryDiagnosisCategory");
		String preliminaryDiagnosis=request.getParameter("preliminaryDiagnosis");
		String examinationSuggestions=request.getParameter("examinationSuggestions");
		String attention=request.getParameter("attention");
		String examinationResult=request.getParameter("examinationResult");
		String diagnosisResult=request.getParameter("diagnosisResult");
		String treatmentOpinion=request.getParameter("treatmentOpinion");
		//对页面数据进行转化
		String medicalRecordNumber=Integer.toString(patientsDao1.findByName(name).getMedicalRecordNumber());
		String registrationID=Integer.toString(registrationformDao1.findByMedicalNumber(Integer.parseInt(medicalRecordNumber)).getRegistrationID());
		//保存看诊信息
		po_16homepageofmedicalrecord homepageofmedicalrecord=new po_16homepageofmedicalrecord(0,registrationID,chiefComplaint,currentMedicalHistory,currentMedicalTreatment,pastHistory,allergyHistory,physicalExamination,preliminaryDiagnosisCategory,preliminaryDiagnosis,examinationSuggestions,attention);
		po_15medicalrecordform medicalrecordform=new po_15medicalrecordform(0,medicalRecordNumber,registrationID,examinationResult,diagnosisResult,treatmentOpinion,null);
		String result=consultDao1.save(homepageofmedicalrecord,medicalrecordform);
		//创建json对象
		JSONObject jo=new JSONObject();
        jo.put("result",result);
        //将数据返回给ajax
        response.getOutputStream().write(JSONObject.valueToString(jo).getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
