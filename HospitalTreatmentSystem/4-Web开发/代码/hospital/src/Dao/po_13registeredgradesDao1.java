package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PoVo.po_13registeredgrades;

public class po_13registeredgradesDao1 extends variable implements po_13registeredgradesDao {

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
	public po_13registeredgrades findByName(String Name) {
		try {
			connection();
			this.sql="select * from 13registeredgrades where gradeName ='"+Name+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int registeredGradeID=rs.getInt(1);//挂号等级ID
				String gradeCode=rs.getString(2);//等级编码
				String gradeName=rs.getString(3);//等级名称
				String displaySequenceNumber=rs.getString(4);//顺序码
				double registrationFee=rs.getDouble(5);//挂号费用
				double registrationLimit=rs.getDouble(6);//挂号限额
				String deletedMark=rs.getString(7);//删除标记
				po_13registeredgrades registeredgrade=new po_13registeredgrades(registeredGradeID,gradeCode,gradeName,displaySequenceNumber,registrationFee,registrationLimit,deletedMark);
				return registeredgrade;
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
	public po_13registeredgrades findByID(int ID) {
		try {
			connection();
			this.sql="select * from 13registeredgrades where registeredGradeID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int registeredGradeID=rs.getInt(1);//挂号等级ID
				String gradeCode=rs.getString(2);//等级编码
				String gradeName=rs.getString(3);//等级名称
				String displaySequenceNumber=rs.getString(4);//顺序码
				double registrationFee=rs.getDouble(5);//挂号费用
				double registrationLimit=rs.getDouble(6);//挂号限额
				String deletedMark=rs.getString(7);//删除标记
				po_13registeredgrades registeredgrade=new po_13registeredgrades(registeredGradeID,gradeCode,gradeName,displaySequenceNumber,registrationFee,registrationLimit,deletedMark);
				return registeredgrade;
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
	public ArrayList<po_13registeredgrades> findAll() {
		try {
			connection();
			this.sql="select * from 13registeredgrades";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_13registeredgrades> arr=new ArrayList<po_13registeredgrades>();
			while(rs.next()) {
				int registeredGradeID=rs.getInt(1);//挂号等级ID
				String gradeCode=rs.getString(2);//等级编码
				String gradeName=rs.getString(3);//等级名称
				String displaySequenceNumber=rs.getString(4);//顺序码
				double registrationFee=rs.getDouble(5);//挂号费用
				double registrationLimit=rs.getDouble(6);//挂号限额
				String deletedMark=rs.getString(7);//删除标记
				po_13registeredgrades registeredgrade=new po_13registeredgrades(registeredGradeID,gradeCode,gradeName,displaySequenceNumber,registrationFee,registrationLimit,deletedMark);
				arr.add(registeredgrade);
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
