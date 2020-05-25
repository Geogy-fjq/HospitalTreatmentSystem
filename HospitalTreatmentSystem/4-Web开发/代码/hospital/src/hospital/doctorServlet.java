package hospital;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Dao.po_01patientsDao1;
import Dao.po_14registrationformDao1;
import PoVo.po_01patients;
import PoVo.po_14registrationform;

/**
 * Servlet implementation class doctorServlet
 */
@WebServlet("/doctorServlet")
public class doctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doctorID="1";
		//查找待诊患者
		ArrayList<po_14registrationform> arr1=registrationformDao1.findReady(doctorID);
		JSONArray json1=new JSONArray();
		for(int i=0;i<arr1.size();i++) {
			JSONObject jo=new JSONObject();
			int MedicalRecordNumber=arr1.get(i).getMedicalRecordNumber();
			po_01patients patient=patientsDao1.findByMedicalRecordNumber(Integer.toString(MedicalRecordNumber));
			String name=patient.getPatientName();
			String IDNumber=patient.getPatientIDNumber();
			jo.put("name",name);
			jo.put("IDNumber",IDNumber);
			json1.put(jo);
		}
		//查找已诊患者
		ArrayList<po_14registrationform> arr2=registrationformDao1.findAlready(doctorID);
		JSONArray json2=new JSONArray();
		for(int i=0;i<arr2.size();i++) {
			JSONObject jo=new JSONObject();
			int MedicalRecordNumber=arr2.get(i).getMedicalRecordNumber();
			po_01patients patient=patientsDao1.findByMedicalRecordNumber(Integer.toString(MedicalRecordNumber));
			String name=patient.getPatientName();
			String IDNumber=patient.getPatientIDNumber();
			jo.put("name",name);
			jo.put("IDNumber",IDNumber);
			json2.put(jo);
		}
		//设置传回的json格式
		JSONArray json=new JSONArray();
		json.put(json1);
		json.put(json2);
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
