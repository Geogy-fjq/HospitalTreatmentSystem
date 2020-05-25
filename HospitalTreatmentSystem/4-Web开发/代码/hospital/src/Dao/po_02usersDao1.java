package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_02users;

public class po_02usersDao1 extends variable implements po_02usersDao {
	
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
	public po_02users findByLoginName(String loginName) {
		try {
			connection();
			this.sql="select * from 02users where userLoginName ='"+loginName+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int userID=rs.getInt(1);//用户ID
				String userLoginName=rs.getString(2);//登录名
				String userPassword=rs.getString(3);//登录密码
				String userName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String userCategory=rs.getString(6);//用户类别
				String deletedMark=rs.getString(7);//删除标记
				po_02users user=new po_02users(userID,userLoginName,userPassword,userName,departmentID,userCategory,deletedMark);
				return user;
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
	public po_02users findByName(String Name) {
		try {
			connection();
			this.sql="select * from 02users where userName ='"+Name+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int userID=rs.getInt(1);//用户ID
				String userLoginName=rs.getString(2);//登录名
				String userPassword=rs.getString(3);//登录密码
				String userName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String userCategory=rs.getString(6);//用户类别
				String deletedMark=rs.getString(7);//删除标记
				po_02users user=new po_02users(userID,userLoginName,userPassword,userName,departmentID,userCategory,deletedMark);
				return user;
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
	public po_02users findByID(String ID) {
		try {
			connection();
			this.sql="select * from 02users where userID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int userID=rs.getInt(1);//用户ID
				String userLoginName=rs.getString(2);//登录名
				String userPassword=rs.getString(3);//登录密码
				String userName=rs.getString(4);//名称
				String departmentID=rs.getString(5);//科室ID
				String userCategory=rs.getString(6);//用户类别
				String deletedMark=rs.getString(7);//删除标记
				po_02users user=new po_02users(userID,userLoginName,userPassword,userName,departmentID,userCategory,deletedMark);
				return user;
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
