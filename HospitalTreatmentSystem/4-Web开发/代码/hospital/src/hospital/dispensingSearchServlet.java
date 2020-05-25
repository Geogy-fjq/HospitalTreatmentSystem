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

import Dao.po_03doctorsDao1;
import Dao.po_06drugsDao1;
import Dao.po_15medicalrecordformDao1;
import Dao.po_17prescriptionDao1;
import Dao.po_18prescriptiondetailsDao1;
import PoVo.po_15medicalrecordform;
import PoVo.po_17prescription;
import PoVo.po_18prescriptiondetails;

/**
 * Servlet implementation class dispensingSearchServlet
 */
@WebServlet("/dispensingSearchServlet")
public class dispensingSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_03doctorsDao1 doctorsDao1=new po_03doctorsDao1();
	po_06drugsDao1 drugsDao1=new po_06drugsDao1();
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	po_17prescriptionDao1 prescriptionDao1=new po_17prescriptionDao1();
	po_18prescriptiondetailsDao1 prescriptiondetailsDao1=new po_18prescriptiondetailsDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dispensingSearchServlet() {
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
		String time=request.getParameter("time");
		//创建json对象
		JSONArray json=new JSONArray();
		//从数据库查找所需患者信息
		po_15medicalrecordform medicalrecordform=medicalrecordformDao1.findByNumber(medicalRecordNumber);
		String medicalrecordID=Integer.toString(medicalrecordform.getMedicalRecordID());	
		po_17prescription prescription=prescriptionDao1.findByBoth1(medicalrecordID,time);
		if(prescription!=null) {
			String prescriptionStatus=prescription.getPrescriptionStatus();
			if(prescriptionStatus.equals("2")) {
				String doctor=doctorsDao1.findByID(prescription.getDoctorID()).getDoctorName();
				String prescriptionName=prescription.getPrescriptionName();
				String prescriptionTime=prescription.getPrescriptionTime();
				ArrayList<po_18prescriptiondetails> arr=prescriptiondetailsDao1.findByPrescriptionID(prescription.getPrescriptionID());
				for(int i=0;i<arr.size();i++) {
					JSONObject jo=new JSONObject();
					po_18prescriptiondetails prescriptiondetail=arr.get(i);
					String drugName=drugsDao1.findByDrugID(prescriptiondetail.getDrugID()).getDrugName();
					double unitPrice=drugsDao1.findByDrugID(prescriptiondetail.getDrugID()).getUnitPriceOfDrugs();
					int quantity=prescriptiondetail.getQuantity();
					String drugStatus=prescriptiondetail.getDrugStatus();
					jo.put("drugName",drugName);
					jo.put("unitPrice",unitPrice);
					jo.put("quantity",quantity);
					jo.put("drugStatus",drugStatus);
					jo.put("doctor",doctor);
					jo.put("prescriptionName",prescriptionName);
					jo.put("prescriptionTime",prescriptionTime);
					json.put(jo);
				}
			}
		}
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
