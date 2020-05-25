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
import Dao.po_10departmentsDao1;
import Dao.po_13registeredgradesDao1;
import PoVo.po_03doctors;
import PoVo.po_10departments;
import PoVo.po_13registeredgrades;

/**
 * Servlet implementation class initialRegisterServlet
 */
@WebServlet("/initialRegisterServlet")
public class initialRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_13registeredgradesDao1 registeredgradesDao1=new po_13registeredgradesDao1();
	po_10departmentsDao1 departmentsDao1=new po_10departmentsDao1();
	po_03doctorsDao1 doctorsDao1=new po_03doctorsDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initialRegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text;charset=utf-8");
		//查找所有的挂号级别,并转换成json格式
		ArrayList<po_13registeredgrades> arr1=registeredgradesDao1.findAll();
		JSONArray json1=new JSONArray();
		for(int i=0;i<arr1.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("gradeName",arr1.get(i).getGradeName());
			json1.put(jo);
		}
		//查找所有的挂号科室,并转换成json格式
		ArrayList<po_10departments> arr2=departmentsDao1.findAll();
		JSONArray json2=new JSONArray();
		for(int i=0;i<arr2.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("departmentName",arr2.get(i).getDepartmentName());
			json2.put(jo);
		}
		//查找所有的挂号医生,并转换成json格式
		ArrayList<po_03doctors> arr3=doctorsDao1.findAll();
		JSONArray json3=new JSONArray();
		for(int i=0;i<arr3.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("doctorName",arr3.get(i).getDoctorName());
			json3.put(jo);
		}
		//设置传回的json格式
		JSONArray json=new JSONArray();
		json.put(json1);
		json.put(json2);
		json.put(json3);
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
