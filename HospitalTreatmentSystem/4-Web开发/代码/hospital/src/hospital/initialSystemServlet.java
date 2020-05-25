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
import Dao.po_16homepageofmedicalrecordDao1;
import Dao.po_17prescriptionDao1;
import Dao.po_18prescriptiondetailsDao1;
import PoVo.po_01patients;
import PoVo.po_06drugs;
import PoVo.po_14registrationform;
import PoVo.po_15medicalrecordform;
import PoVo.po_16homepageofmedicalrecord;
import PoVo.po_17prescription;
import PoVo.po_18prescriptiondetails;

/**
 * Servlet implementation class initialSystemServlet
 */
@WebServlet("/initialSystemServlet")
public class initialSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_06drugsDao1 drugsDao1=new po_06drugsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	po_16homepageofmedicalrecordDao1 homepageofmedicalrecordDao1=new po_16homepageofmedicalrecordDao1();
	po_17prescriptionDao1 prescriptionDao1=new po_17prescriptionDao1();
	po_18prescriptiondetailsDao1 prescriptiondetailsDao1=new po_18prescriptiondetailsDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initialSystemServlet() {
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
		String patientIDNumber=request.getParameter("patientIDNumber");
		//从数据库读取数据
		po_01patients patient=patientsDao1.findByID(patientIDNumber);
		String patientName=patient.getPatientName();
		String patientAge=Integer.toString(patient.getPatientAge());
		int medicalRecordNumber=patient.getMedicalRecordNumber();
		po_14registrationform registrationform=registrationformDao1.findByMedicalNumber(medicalRecordNumber);
		String StatusOfConsultation=registrationform.getStatusOfConsultation();
		String chiefComplaint="";
		String currentMedicalHistory="";
		String currentMedicalTreatment="";
		String pastHistory="";
		String allergyHistory="";
		String physicalExamination="";
		String preliminaryDiagnosisCategory="";
		String preliminaryDiagnosis="";
		String examinationSuggestions="";
		String attention="";
		String examinationResult="";
		String diagnosisResult="";
		String treatmentOpinion="";
		double feeAlready=0;
		double feeReady=0;
		//创建json对象
		JSONObject jo=new JSONObject();
		JSONArray json=new JSONArray();
		JSONArray json1=new JSONArray();
		JSONArray json2=new JSONArray();
		if(registrationform!=null) {//如果该病患已经挂号
			if(!StatusOfConsultation.equals("1")) {//已经就诊
				po_15medicalrecordform medicalrecordform=medicalrecordformDao1.findByNumber(Integer.toString(medicalRecordNumber));
				String registrationID=medicalrecordform.getRegistrationID();
				po_16homepageofmedicalrecord homepageofmedicalrecord=homepageofmedicalrecordDao1.findByRegisterID(registrationID);
				//设置病例信息
				chiefComplaint=homepageofmedicalrecord.getChiefComplaint();
				currentMedicalHistory=homepageofmedicalrecord.getCurrentMedicalHistory();
				currentMedicalTreatment=homepageofmedicalrecord.getCurrentMedicalTreatment();
				pastHistory=homepageofmedicalrecord.getPastHistory();
				allergyHistory=homepageofmedicalrecord.getAllergyHistory();
				physicalExamination=homepageofmedicalrecord.getPhysicalExamination();
				preliminaryDiagnosisCategory=homepageofmedicalrecord.getPreliminaryDiagnosisCategory();
				preliminaryDiagnosis=homepageofmedicalrecord.getPreliminaryDiagnosis();
				examinationSuggestions=homepageofmedicalrecord.getExaminationSuggestions();
				attention=homepageofmedicalrecord.getAttention();
				examinationResult=medicalrecordform.getExaminationResult();
			    diagnosisResult=medicalrecordform.getDiagnosisResult();
				treatmentOpinion=medicalrecordform.getTreatmentOpinion();
				//开药信息
				if(!StatusOfConsultation.equals("2")) {//已经开药
					ArrayList<po_17prescription> prescriptions=prescriptionDao1.findByRegistrationID(registrationID);
					for(int k=0;k<prescriptions.size();k++) {
						po_17prescription prescription=prescriptions.get(k);
						int prescriptionID=prescription.getPrescriptionID();
						ArrayList<po_18prescriptiondetails> arr=prescriptiondetailsDao1.findByPrescriptionID(prescriptionID);		
						for(int i=0;i<arr.size();i++) {
							po_18prescriptiondetails detail=arr.get(i);
							JSONObject jo1=new JSONObject();
							JSONObject jo2=new JSONObject();
							if(detail.getDrugStatus().equals("1")) {//还未缴费
								po_06drugs drug=drugsDao1.findByDrugID(detail.getDrugID());
								jo1.put("name",drug.getDrugName());
								jo1.put("price",drug.getUnitPriceOfDrugs());
								jo1.put("quantity",detail.getQuantity());
								json1.put(jo1);
								feeReady=feeReady+drug.getUnitPriceOfDrugs()*detail.getQuantity();
							}
							else {//已经缴费
								po_06drugs drug=drugsDao1.findByDrugID(detail.getDrugID());
								jo2.put("name",drug.getDrugName());
								jo2.put("price",drug.getUnitPriceOfDrugs());
								jo2.put("quantity",detail.getQuantity());
								json2.put(jo2);
								feeAlready=feeAlready+drug.getUnitPriceOfDrugs()*detail.getQuantity();

							}
						}
					}
				}
			}
		}
		String feeReady1=Double.toString(feeReady)+"元";
		String feeAlready1=Double.toString(feeAlready)+"元";
		//设置json对象
        jo.put("name",patientName);
        jo.put("IDNumber",patientIDNumber);
        jo.put("age",patientAge);
        jo.put("chiefComplaint",chiefComplaint);
        jo.put("currentMedicalHistory",currentMedicalHistory);
        jo.put("currentMedicalTreatment",currentMedicalTreatment);
        jo.put("pastHistory",pastHistory);
        jo.put("allergyHistory",allergyHistory);
        jo.put("physicalExamination",physicalExamination);
        jo.put("preliminaryDiagnosisCategory",preliminaryDiagnosisCategory);
        jo.put("preliminaryDiagnosis",preliminaryDiagnosis);
        jo.put("examinationSuggestions",examinationSuggestions);
        jo.put("attention",attention);
        jo.put("examinationResult",examinationResult);
        jo.put("diagnosisResult",diagnosisResult);
        jo.put("treatmentOpinion",treatmentOpinion);
        jo.put("feeReady",feeReady1);
        jo.put("feeAlready",feeAlready1);
        json.put(jo);
        json.put(json1);
		json.put(json2);
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
