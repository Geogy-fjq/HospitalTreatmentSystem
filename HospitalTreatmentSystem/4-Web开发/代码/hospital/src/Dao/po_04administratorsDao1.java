package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_04administrators;

public class po_04administratorsDao1 extends variable implements po_04administratorsDao {

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
	public po_04administrators findByLoginName(String loginName) {
		try {
			connection();
			this.sql="select * from 04administrators where administratorLoginName ='"+loginName+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int administratorID=rs.getInt(1);//管理员ID
				String administratorLoginName=rs.getString(2);//登录名
				String administratorPassword=rs.getString(3);//登录密码
				String administratorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String deletedMark=rs.getString(6);//删除标记
				po_04administrators administrator=new po_04administrators(administratorID,administratorLoginName,administratorPassword,administratorName,departmentID,deletedMark);
				return administrator;
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
	public po_04administrators findByName(String Name) {
		try {
			connection();
			this.sql="select * from 04administrators where administratorName ='"+Name+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int administratorID=rs.getInt(1);//管理员ID
				String administratorLoginName=rs.getString(2);//登录名
				String administratorPassword=rs.getString(3);//登录密码
				String administratorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String deletedMark=rs.getString(6);//删除标记
				po_04administrators administrator=new po_04administrators(administratorID,administratorLoginName,administratorPassword,administratorName,departmentID,deletedMark);
				return administrator;
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
	public po_04administrators findByID(String ID) {
		try {
			connection();
			this.sql="select * from 04administrators where administratorID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int administratorID=rs.getInt(1);//管理员ID
				String administratorLoginName=rs.getString(2);//登录名
				String administratorPassword=rs.getString(3);//登录密码
				String administratorName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String deletedMark=rs.getString(6);//删除标记
				po_04administrators administrator=new po_04administrators(administratorID,administratorLoginName,administratorPassword,administratorName,departmentID,deletedMark);
				return administrator;
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
}
