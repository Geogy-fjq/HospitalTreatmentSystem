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
import Dao.po_06drugsDao1;
import Dao.po_14registrationformDao1;
import Dao.po_15medicalrecordformDao1;
import Dao.po_17prescriptionDao1;
import Dao.po_18prescriptiondetailsDao1;
import PoVo.po_01patients;
import PoVo.po_06drugs;
import PoVo.po_14registrationform;
import PoVo.po_15medicalrecordform;
import PoVo.po_17prescription;
import PoVo.po_18prescriptiondetails;

/**
 * Servlet implementation class chargeSearchServlet
 */
@WebServlet("/chargeSearchServlet")
public class chargeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_06drugsDao1 drugsDao1=new po_06drugsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	po_17prescriptionDao1 prescriptionDao1=new po_17prescriptionDao1();
	po_18prescriptiondetailsDao1 prescriptiondetailsDao1=new po_18prescriptiondetailsDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargeSearchServlet() {
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
		//创建json对象
		JSONObject jo=new JSONObject();
		JSONArray json=new JSONArray();
		JSONArray json1=new JSONArray();
		if(patient!=null) {
			patientName=patient.getPatientName();
			patientIDNumber=patient.getPatientIDNumber();
			patientAddress=patient.getPatientAddress();
			po_15medicalrecordform medicalrecordform=medicalrecordformDao1.findByNumber(medicalRecordNumber);
			String registrationID=medicalrecordform.getRegistrationID();
			po_14registrationform registrationform=registrationformDao1.findByMedicalNumber(Integer.parseInt(medicalRecordNumber));
			String StatusOfConsultation=registrationform.getStatusOfConsultation();		
			//开药信息
			if(StatusOfConsultation.equals("3")) {//已经开药
				ArrayList<po_17prescription> prescriptions=prescriptionDao1.findByRegistrationID(registrationID);
				for(int k=0;k<prescriptions.size();k++) {
					po_17prescription prescription=prescriptions.get(k);
					int prescriptionID=prescription.getPrescriptionID();
					ArrayList<po_18prescriptiondetails> arr=prescriptiondetailsDao1.findByPrescriptionID(prescriptionID);		
					for(int i=0;i<arr.size();i++) {
						po_18prescriptiondetails detail=arr.get(i);
						JSONObject jo1=new JSONObject();
						if(detail.getDrugStatus().equals("1")) {//已开立
							po_06drugs drug=drugsDao1.findByDrugID(detail.getDrugID());
							jo1.put("name",drug.getDrugName());
							jo1.put("price",drug.getUnitPriceOfDrugs());
							jo1.put("quantity",detail.getQuantity());
							int prescriptionID1=detail.getPrescriptionID();
							String time=prescriptionDao1.findByPrescriptionID(prescriptionID1).getPrescriptionTime();
							jo1.put("time",time);
							jo1.put("prescriptionID",prescriptionID1);
							json1.put(jo1);
						}
					}
				}
			}
		}
		//设置json对象
		jo.put("patientName",patientName);
		jo.put("patientIDNumber",patientIDNumber);
		jo.put("patientAddress",patientAddress);
		json.put(jo);
		json.put(json1);
		//将数据返回给ajax
        response.getOutputStream().write(JSONObject.valueToString(json).getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
