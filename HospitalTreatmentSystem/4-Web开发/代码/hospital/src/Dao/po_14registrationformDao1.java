package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import PoVo.po_14registrationform;

public class po_14registrationformDao1 extends variable implements po_14registrationformDao {

	//连接数据库
	public void connection() throws ClassNotFoundException, SQLException { 
		Class.forName(jdbcName);
		this.con=DriverManager.getConnection(url);
	}
	//关闭连接
	public void refuse() throws SQLException { 
		if(this.rs!=null) {
			rs.close();
		}
		if(this.ps!=null) {
			ps.close();
		}
		if(this.st!=null) {
			st.close();
		}
		if(this.con!=null) {
			con.close();
		}
	}

	@Override
	public po_14registrationform findByMedicalNumber(int medicalNumber) {
		try {
			connection();
			this.sql="select * from 14registrationform where medicalRecordNumber ='"+medicalNumber+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int registrationID=rs.getInt(1);//挂号ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String dateOfConsultation=rs.getString(3);//看诊日期
				String noon=rs.getString(4);//午别
				String departmentID=rs.getString(5);//科室ID
				String doctorID=rs.getString(6);//医生ID
				String registeredGradeID=rs.getString(7);//挂号级别ID
				String settlementCategory=rs.getString(8);//结算类别
				String medicalRecordNeeded=rs.getString(9);//病历本要否
				String registrationTime=rs.getString(10);//挂号时间
				String registeredStaffID=rs.getString(11);//挂号员ID
				String statusOfConsultation=rs.getString(12);//看诊状态
				po_14registrationform registrationform=new po_14registrationform(registrationID,medicalRecordNumber,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,registrationTime,registeredStaffID,statusOfConsultation);
				return registrationform;
			}
			refuse();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public po_14registrationform findByID(int ID) {
		try {
			connection();
			this.sql="select * from 14registrationform where registrationID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int registrationID=rs.getInt(1);//挂号ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String dateOfConsultation=rs.getString(3);//看诊日期
				String noon=rs.getString(4);//午别
				String departmentID=rs.getString(5);//科室ID
				String doctorID=rs.getString(6);//医生ID
				String registeredGradeID=rs.getString(7);//挂号级别ID
				String settlementCategory=rs.getString(8);//结算类别
				String medicalRecordNeeded=rs.getString(9);//病历本要否
				String registrationTime=rs.getString(10);//挂号时间
				String registeredStaffID=rs.getString(11);//挂号员ID
				String statusOfConsultation=rs.getString(12);//看诊状态
				po_14registrationform registrationform=new po_14registrationform(registrationID,medicalRecordNumber,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,registrationTime,registeredStaffID,statusOfConsultation);
				return registrationform;
			}
			refuse();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public po_14registrationform findLast() {
		try {
			connection();
			this.sql="select * from 14registrationform order by registrationID desc limit 1";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int registrationID=rs.getInt(1);//挂号ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String dateOfConsultation=rs.getString(3);//看诊日期
				String noon=rs.getString(4);//午别
				String departmentID=rs.getString(5);//科室ID
				String doctorID=rs.getString(6);//医生ID
				String registeredGradeID=rs.getString(7);//挂号级别ID
				String settlementCategory=rs.getString(8);//结算类别
				String medicalRecordNeeded=rs.getString(9);//病历本要否
				String registrationTime=rs.getString(10);//挂号时间
				String registeredStaffID=rs.getString(11);//挂号员ID
				String statusOfConsultation=rs.getString(12);//看诊状态
				po_14registrationform registrationform=new po_14registrationform(registrationID,medicalRecordNumber,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,registrationTime,registeredStaffID,statusOfConsultation);
				return registrationform;
			}
			refuse();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ArrayList<po_14registrationform> findReady(String doctorID1) {
		try {
			connection();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String date=df.format(new Date());//获取当前系统日期
			this.sql="select * from 14registrationform where doctorID ='"+doctorID1+"'and statusOfConsultation ='"+1+"'and dateOfConsultation ='"+date+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_14registrationform> arr=new ArrayList<po_14registrationform>();
			while(rs.next()) {
				int registrationID=rs.getInt(1);//挂号ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String dateOfConsultation=rs.getString(3);//看诊日期
				String noon=rs.getString(4);//午别
				String departmentID=rs.getString(5);//科室ID
				String doctorID=rs.getString(6);//医生ID
				String registeredGradeID=rs.getString(7);//挂号级别ID
				String settlementCategory=rs.getString(8);//结算类别
				String medicalRecordNeeded=rs.getString(9);//病历本要否
				String registrationTime=rs.getString(10);//挂号时间
				String registeredStaffID=rs.getString(11);//挂号员ID
				String statusOfConsultation=rs.getString(12);//看诊状态
				po_14registrationform registrationform=new po_14registrationform(registrationID,medicalRecordNumber,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,registrationTime,registeredStaffID,statusOfConsultation);
				arr.add(registrationform);
			}
			refuse();
			return arr;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<po_14registrationform> findAlready(String doctorID1) {
		try {
			connection();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String date=df.format(new Date());//获取当前系统日期
			this.sql="select * from 14registrationform where doctorID ='"+doctorID1+"'and statusOfConsultation !='"+1+"'and dateOfConsultation ='"+date+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_14registrationform> arr=new ArrayList<po_14registrationform>();
			while(rs.next()) {
				int registrationID=rs.getInt(1);//挂号ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String dateOfConsultation=rs.getString(3);//看诊日期
				String noon=rs.getString(4);//午别
				String departmentID=rs.getString(5);//科室ID
				String doctorID=rs.getString(6);//医生ID
				String registeredGradeID=rs.getString(7);//挂号级别ID
				String settlementCategory=rs.getString(8);//结算类别
				String medicalRecordNeeded=rs.getString(9);//病历本要否
				String registrationTime=rs.getString(10);//挂号时间
				String registeredStaffID=rs.getString(11);//挂号员ID
				String statusOfConsultation=rs.getString(12);//看诊状态
				po_14registrationform registrationform=new po_14registrationform(registrationID,medicalRecordNumber,dateOfConsultation,noon,departmentID,doctorID,registeredGradeID,settlementCategory,medicalRecordNeeded,registrationTime,registeredStaffID,statusOfConsultation);
				arr.add(registrationform);
			}
			refuse();
			return arr;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
