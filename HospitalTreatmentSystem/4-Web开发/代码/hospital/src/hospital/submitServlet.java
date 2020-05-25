package hospital;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_01patientsDao1;
import Dao.po_06drugsDao1;
import Dao.po_14registrationformDao1;
import Dao.po_15medicalrecordformDao1;
import Dao.po_17prescriptionDao1;
import Dao.vo_3consultDao1;
import PoVo.po_17prescription;

/**
 * Servlet implementation class submitServlet
 */
@WebServlet("/submitServlet")
public class submitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_06drugsDao1 drugsDao1=new po_06drugsDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	po_17prescriptionDao1 prescriptionDao1=new po_17prescriptionDao1();
	vo_3consultDao1 consultDao1=new vo_3consultDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitServlet() {
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
		String doctorID=request.getParameter("doctorID");
		String prescriptionName=request.getParameter("prescriptionName");
		String drugNameArr=request.getParameter("drugNameArr");
		String drugUsageArr=request.getParameter("drugUsageArr");
		String drugDosageArr=request.getParameter("drugDosageArr");
		String frequencyArr=request.getParameter("frequencyArr");
		String quantityArr=request.getParameter("quantityArr");
		System.out.print(drugUsageArr);
		//对页面数据进行处理
		String medicalRecordNumber=Integer.toString(patientsDao1.findByName(name).getMedicalRecordNumber());
		String registrationID=Integer.toString(registrationformDao1.findByMedicalNumber(Integer.parseInt(medicalRecordNumber)).getRegistrationID());
		String medicalRecordID=Integer.toString(medicalrecordformDao1.findByNumber(medicalRecordNumber).getMedicalRecordID());
		String drugUsageList=drugUsageArr.substring(0,drugUsageArr.length()-1);
		String drugDosageList=drugDosageArr.substring(0,drugDosageArr.length()-1);
		String frequencyList=frequencyArr.substring(0,frequencyArr.length()-1);
		String quantityList=quantityArr.substring(0,quantityArr.length()-1);
		String drugIDList="";
		String[] list=drugNameArr.split(",");		
		for(int i=0;i<list.length;i++) {
			drugIDList=drugIDList+(drugsDao1.findByDrugName(list[i]).getDrugID())+",";
		}
		drugIDList=drugIDList.substring(0,drugIDList.length()-1);
		//保存处方信息
		po_17prescription prescription=new po_17prescription(0,medicalRecordID,registrationID,doctorID,prescriptionName,null,null);
		String result=consultDao1.submit(prescription,drugIDList,drugUsageList,drugDosageList,frequencyList,quantityList);
		//创建json对象
		JSONObject jo=new JSONObject();
        jo.put("result",result);
        ArrayList<po_17prescription> arr=prescriptionDao1.findByRegistrationID(registrationID);
        String prescriptionStatus=arr.get(arr.size()-1).getPrescriptionStatus();
        jo.put("prescriptionStatus",prescriptionStatus);
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
