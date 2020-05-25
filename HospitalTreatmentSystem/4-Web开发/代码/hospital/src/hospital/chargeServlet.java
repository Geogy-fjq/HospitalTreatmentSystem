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

import Dao.po_15medicalrecordformDao1;
import Dao.po_17prescriptionDao1;
import Dao.po_22invoicesDao1;
import Dao.vo_5payDao1;

/**
 * Servlet implementation class chargeServlet
 */
@WebServlet("/chargeServlet")
public class chargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_15medicalrecordformDao1 medicalrecordformDao1=new po_15medicalrecordformDao1();
	po_17prescriptionDao1 prescriptionDao1=new po_17prescriptionDao1();
	po_22invoicesDao1 invoicesDao1=new po_22invoicesDao1();
	vo_5payDao1 payDao1=new vo_5payDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargeServlet() {
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
		String chargingOrRefundStaffID=request.getParameter("chargingOrRefundStaffID");
		String chargeMethod=request.getParameter("chargeMethod");
		String IDArr=request.getParameter("IDArr");
		String[] list=IDArr.split(",");
		ArrayList<String> arr=new ArrayList<String>();
		arr.add(list[0]);
		for(int i=0;i<list.length;i++) {
			if(!arr.contains(list[i])){  
                arr.add(list[i]);  
            }  
		}
		//创建json对象
		JSONArray json=new JSONArray();
		//缴费
		for(int k=0;k<arr.size();k++) {
			JSONObject jo=new JSONObject();
			String prescriptionID=arr.get(k);
			String result=payDao1.charge(prescriptionID,chargingOrRefundStaffID,chargeMethod);
			String registerID=prescriptionDao1.findByPrescriptionID(Integer.parseInt(prescriptionID)).getRegistrationID();
			int invoiceNumber=invoicesDao1.findByregisterID(registerID).getInvoiceNumber();
			jo.put("invoiceNumber",invoiceNumber);
			jo.put("result",result);
			json.put(jo);
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
