package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PoVo.po_03doctors;

public class po_03doctorsDao1 extends variable implements po_03doctorsDao {
	
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
	public po_03doctors findByLoginName(String loginName) {
		try {
			connection();
			this.sql="select * from 03doctors where doctorLoginName ='"+loginName+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				return doctor;
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
	public po_03doctors findByName(String Name) {
		try {
			connection();
			this.sql="select * from 03doctors where doctorName ='"+Name+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				return doctor;
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
	public po_03doctors findByID(String ID) {
		try {
			connection();
			this.sql="select * from 03doctors where doctorID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				return doctor;
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
	public ArrayList<po_03doctors> findAll() {
		try {
			connection();
			this.sql="select * from 03doctors";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_03doctors> arr=new ArrayList<po_03doctors>();
			while(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				arr.add(doctor);
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
	public ArrayList<po_03doctors> findDesignatedAll(String departmentID1, String registeredGradeID1) {
		try {
			connection();
			this.sql="select * from 03doctors where departmentID='"+departmentID1+"'and registeredGradeID='"+registeredGradeID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_03doctors> arr=new ArrayList<po_03doctors>();
			while(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				arr.add(doctor);
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
	public ArrayList<po_03doctors> finddepartmentIDAll(String departmentID1) {
		try {
			connection();
			this.sql="select * from 03doctors where departmentID='"+departmentID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_03doctors> arr=new ArrayList<po_03doctors>();
			while(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				arr.add(doctor);
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
	public ArrayList<po_03doctors> findregisteredGradeIDAll(String registeredGradeID1) {
		try {
			connection();
			this.sql="select * from 03doctors where registeredGradeID='"+registeredGradeID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_03doctors> arr=new ArrayList<po_03doctors>();
			while(rs.next()) {
				int doctorID=rs.getInt(1);//医生ID
				String doctorLoginName=rs.getString(2);//登录名
				String doctorPassword=rs.getString(3);//登录密码
				String doctorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String doctorCategory=rs.getString(6);//医生类别
				String titleID=rs.getString(7);//职称
				String scheduling=rs.getString(8);//是否排班
				String registeredGradeID=rs.getString(9);//挂号等级ID
				String deletedMark=rs.getString(10);//删除标记
				po_03doctors doctor=new po_03doctors(doctorID,doctorLoginName,doctorPassword,doctorName,departmentID,doctorCategory,titleID,scheduling,registeredGradeID,deletedMark);
				arr.add(doctor);
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
