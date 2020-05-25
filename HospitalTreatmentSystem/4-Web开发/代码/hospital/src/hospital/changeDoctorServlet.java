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

/**
 * Servlet implementation class changeDoctorServlet
 */
@WebServlet("/changeDoctorServlet")
public class changeDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_13registeredgradesDao1 registeredgradesDao1=new po_13registeredgradesDao1();
	po_10departmentsDao1 departmentsDao1=new po_10departmentsDao1();
	po_03doctorsDao1 doctorsDao1=new po_03doctorsDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeDoctorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text;charset=utf-8");
		//获取挂号级别和挂号科室
        String registeredGrade=request.getParameter("registeredGrade");
        String department=request.getParameter("department");
		//查找符合条件的医生,并转换成json格式
		JSONArray json=new JSONArray();
		ArrayList<po_03doctors> arr=null;
		String registeredGradeID=null;
		String departmentID=null;
        if(registeredGrade.equals("0") && department.equals("0")) {
    		arr=doctorsDao1.findAll();
        }
        else if(!registeredGrade.equals("0") && department.equals("0")) {
    		registeredGradeID=Integer.toString(registeredgradesDao1.findByName(registeredGrade).getRegisteredGradeID());
    		arr=doctorsDao1.findregisteredGradeIDAll(registeredGradeID);
        }
        else if(registeredGrade.equals("0") && !department.equals("0")) {
    		departmentID=Integer.toString(departmentsDao1.findByName(department).getDepartmentID());
    		arr=doctorsDao1.finddepartmentIDAll(departmentID);
        }
        else {
        	registeredGradeID=Integer.toString(registeredgradesDao1.findByName(registeredGrade).getRegisteredGradeID());
    		departmentID=Integer.toString(departmentsDao1.findByName(department).getDepartmentID());
    		arr=doctorsDao1.findDesignatedAll(departmentID,registeredGradeID);
        }
		for(int i=0;i<arr.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("doctorName",arr.get(i).getDoctorName());
			json.put(jo);
		}
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
