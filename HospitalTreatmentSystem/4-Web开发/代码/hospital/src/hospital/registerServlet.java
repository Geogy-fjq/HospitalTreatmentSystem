package hospital;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Dao.vo_1registerDao1;
import Dao.po_01patientsDao1;
import Dao.po_02usersDao1;
import Dao.po_03doctorsDao1;
import Dao.po_10departmentsDao1;
import Dao.po_13registeredgradesDao1;
import Dao.po_14registrationformDao1;
import Dao.po_22invoicesDao1;
import PoVo.po_01patients;
import PoVo.po_14registrationform;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	vo_1registerDao1 dao1=new vo_1registerDao1();
	po_01patientsDao1 patientsDao1=new po_01patientsDao1();
	po_02usersDao1 usersDao1=new po_02usersDao1();
	po_03doctorsDao1 doctorsDao1=new po_03doctorsDao1();
	po_10departmentsDao1 departmentsDao1=new po_10departmentsDao1();
	po_13registeredgradesDao1 registeredgradesDao1=new po_13registeredgradesDao1();
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	po_22invoicesDao1 invoicesDao1=new po_22invoicesDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取挂号级别和是否要病历本
        String patientIDNumber=request.getParameter("patientIDNumber");
        String patientName=request.getParameter("patientName");
        String patientSex=request.getParameter("patientSex");
        String patientBirthday=request.getParameter("patientBirthday");
        String patientAddress=request.getParameter("patientAddress");
        String department=request.getParameter("department");
        String doctor=request.getParameter("doctor");
        String medicalRecordNeeded=request.getParameter("medicalRecordNeeded");
        String registeredGrade=request.getParameter("registeredGrade");
        String settlementCategory=request.getParameter("settlementCategory");
        //获取当前系统日期，并处理输入数据
        Date now=new Date(); 
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(now);
        String[] str1=date.split("-");     
        String[] str2=patientBirthday.split("-");
        int patientAge=Integer.parseInt(str1[0])-Integer.parseInt(str2[0]);
        String patientAgeType="岁";
        String registeredStaff="超级管理员";
        String dateOfConsultation=date;
        //获取当前系统时间，并处理输入数据
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        String noon=null;
        if(hour<=12) {
        	noon="上";
        }
        else {
        	noon="下";
        }
        //转换输入数据
        String departmentID=Integer.toString(departmentsDao1.findByName(department).getDepartmentID());
        String doctorID=Integer.toString(doctorsDao1.findByName(doctor).getDoctorID());
        String registeredGradeID=Integer.toString(registeredgradesDao1.findByName(registeredGrade).getRegisteredGradeID());
        String registeredStaffID=Integer.toString(usersDao1.findByName(registeredStaff).getUserID());
        if(request.getParameter("settlementCategory").equals("自费")) {
        	settlementCategory="1";
        }
        else if(request.getParameter("settlementCategory").equals("公费")) {
        	settlementCategory="2";
        }
        //挂号
        po_01patients patient=null;
        po_14registrationform  registrationform=null;
        patient=new po_01patients(0,0,patientIDNumber,patientName,patientSex,patientBirthday,patientAge,patientAgeType,patientAddress,null);
        registrationform=new po_14registrationform(0,0,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,null,registeredStaffID,null);
    	dao1.register(patient,registrationform);
        //获取挂号后的信息
        String medicalRecordNumber=String.valueOf(registrationformDao1.findLast().getMedicalRecordNumber());
        int registrationID=registrationformDao1.findLast().getRegistrationID();
        int invoiceNumber=invoicesDao1.findByregisterID(Integer.toString(registrationID)).getInvoiceNumber();
        //将结果转换成json格式
		JSONArray json=new JSONArray();
		json.put(0,invoiceNumber);
		json.put(1,medicalRecordNumber);
		json.put(2,registrationID);
		json.put(3,patientAge);
		json.put(4,patientAgeType);
		json.put(5,registeredStaff);
		json.put(6,dateOfConsultation);
		json.put(7,noon);
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
