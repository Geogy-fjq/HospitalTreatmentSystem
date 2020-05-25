package hospital;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_01patientsDao1;
import Dao.po_10departmentsDao1;
import Dao.po_14registrationformDao1;
import PoVo.po_01patients;
import PoVo.po_14registrationform;

/**
 * Servlet implementation class deleteSearchServlet
 */
@WebServlet("/deleteSearchServlet")
public class deleteSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_10departmentsDao1 departmentsDao1=new po_10departmentsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSearchServlet() {
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
		String medicalRecordNumber=request.getParameter("medicalRecordNumber");
		//从数据库查找所需患者信息
		po_01patients patient=patientsDao1.findByMedicalRecordNumber(medicalRecordNumber);
		String patientName="";
		String patientIDNumber="";
		String patientAddress="";
		String registrationTime="";
		String noon="";
		String department="";
		String statusOfConsultation="";
		//创建json对象
		JSONObject jo=new JSONObject();
		if(patient!=null) {
			patientName=patient.getPatientName();
			patientIDNumber=patient.getPatientIDNumber();
			patientAddress=patient.getPatientAddress();
			po_14registrationform registrationform=registrationformDao1.findByMedicalNumber(Integer.parseInt(medicalRecordNumber));
			//查找挂号信息
			if(registrationform!=null) {
				registrationTime=registrationform.getRegistrationTime().split(" ")[0];
				noon=registrationform.getNoon();
				department=departmentsDao1.findByID(Integer.parseInt(registrationform.getDepartmentID())).getDepartmentName();
				statusOfConsultation=registrationform.getStatusOfConsultation();
			}	
		}
		//设置jo对象
		jo.put("patientName",patientName);
		jo.put("patientIDNumber",patientIDNumber);
		jo.put("patientAddress",patientAddress);
		jo.put("registrationTime",registrationTime);
		jo.put("noon",noon);
		jo.put("department",department);
		jo.put("statusOfConsultation",statusOfConsultation);
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
