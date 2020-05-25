package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PoVo.po_10departments;

public class po_10departmentsDao1 extends variable implements po_10departmentsDao {

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
	public po_10departments findByName(String Name) {
		try {
			connection();
			this.sql="select * from 10departments where departmentName ='"+Name+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int departmentID=rs.getInt(1);//科室ID
				String departmentCode=rs.getString(2);//科室编码
				String departmentName=rs.getString(3);//科室名称
				String departmentCategory=rs.getString(4);//科室分类
				String departmentType=rs.getString(5);//科室类别
				String deletedMark=rs.getString(6);//删除标记
				po_10departments department=new po_10departments(departmentID,departmentCode,departmentName,departmentCategory,departmentType,deletedMark);
				return department;
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
	public po_10departments findByID(int ID) {
		try {
			connection();
			this.sql="select * from 10departments where departmentID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int departmentID=rs.getInt(1);//科室ID
				String departmentCode=rs.getString(2);//科室编码
				String departmentName=rs.getString(3);//科室名称
				String departmentCategory=rs.getString(4);//科室分类
				String departmentType=rs.getString(5);//科室类别
				String deletedMark=rs.getString(6);//删除标记
				po_10departments department=new po_10departments(departmentID,departmentCode,departmentName,departmentCategory,departmentType,deletedMark);
				return department;
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
	public ArrayList<po_10departments> findAll() {
		try {
			connection();
			this.sql="select * from 10departments";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_10departments> arr=new ArrayList<po_10departments>();
			while(rs.next()) {
				int departmentID=rs.getInt(1);//科室ID
				String departmentCode=rs.getString(2);//科室编码
				String departmentName=rs.getString(3);//科室名称
				String departmentCategory=rs.getString(4);//科室分类
				String departmentType=rs.getString(5);//科室类别
				String deletedMark=rs.getString(6);//删除标记
				po_10departments department=new po_10departments(departmentID,departmentCode,departmentName,departmentCategory,departmentType,deletedMark);
				arr.add(department);
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
