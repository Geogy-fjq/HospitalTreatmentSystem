package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PoVo.po_18prescriptiondetails;

public class po_18prescriptiondetailsDao1  extends variable implements po_18prescriptiondetailsDao{

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
	public ArrayList<po_18prescriptiondetails> findByPrescriptionID(int prescriptionID1) {
		try {
			connection();
			this.sql="select * from 18prescriptiondetails where prescriptionID ='"+prescriptionID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_18prescriptiondetails> arr=new ArrayList<po_18prescriptiondetails>();
			while(rs.next()) {
				int prescriptionDetailID=rs.getInt(1);//处方明细ID
				int prescriptionID=rs.getInt(2);//处方ID
				int drugID=rs.getInt(3);//药品ID
				String drugUsage=rs.getString(4);//用法
				String drugDosage=rs.getString(5);//用量
				String frequency=rs.getString(6);//频次
				int quantity=rs.getInt(7);//数量
				String drugStatus=rs.getString(8);//状态
				po_18prescriptiondetails prescriptiondetails=new po_18prescriptiondetails(prescriptionDetailID,prescriptionID,drugID,drugUsage,drugDosage,frequency,quantity,drugStatus);
				arr.add(prescriptiondetails);
			}
			refuse();
			return arr;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	}

}
