package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Dao.po_01patientsDao1;
import PoVo.po_01patients;

/**
 * Servlet implementation class changeInformServlet
 */
@WebServlet("/changeInformServlet")
public class changeInformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeInformServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取病历号
        String medicalRecordNumber=request.getParameter("medicalRecordNumber");
        //读取数据库中对应病历号的患者信息
        String patientIDNumber="";
        String patientName="";
        String patientSex="";
        String patientBirthday="";
        String patientAddress="";
        po_01patients patient=patientsDao1.findByMedicalRecordNumber(medicalRecordNumber);
        if(patient!=null) {//如果不为null,则对应读取
        	patientIDNumber=patient.getPatientIDNumber();
            patientName=patient.getPatientName();
            patientSex=patient.getPatientSex();
            patientBirthday=patient.getPatientBirthday();
            patientAddress=patient.getPatientAddress();
        }
        //将结果转换成json格式
		JSONArray json=new JSONArray();
		json.put(0,patientIDNumber);
		json.put(1,patientName);
		json.put(2,patientSex);
		json.put(3,patientBirthday);
		json.put(4,patientAddress);
		//响应
		response.getOutputStream().write(JSONObject.valueToString(json).getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
