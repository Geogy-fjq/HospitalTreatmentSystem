package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import PoVo.po_17prescription;

public class po_17prescriptionDao1 extends variable implements po_17prescriptionDao {

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
	public ArrayList<po_17prescription> findByRegistrationID(String registrationID1) {
		try {
			connection();
			this.sql="select * from 17prescription where registrationID ='"+registrationID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			ArrayList<po_17prescription> arr=new ArrayList<po_17prescription>();
			while(rs.next()) {
				int prescriptionID=rs.getInt(1);//处方ID
				String medicalRecordID=rs.getString(2);//病历ID
				String registrationID=rs.getString(3);//挂号ID
				String doctorID=rs.getString(4);//开立医生ID
				String prescriptionName=rs.getString(5);//处方名称
				String prescriptionTime=rs.getString(6);//开立时间
				String prescriptionStatus=rs.getString(7);//处方状态
				po_17prescription prescription=new po_17prescription(prescriptionID,medicalRecordID,registrationID,doctorID,prescriptionName,prescriptionTime,prescriptionStatus);
				arr.add(prescription);
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
	public po_17prescription findByPrescriptionID(int prescriptionID1) {
		try {
			connection();
			this.sql="select * from 17prescription where prescriptionID ='"+prescriptionID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int prescriptionID=rs.getInt(1);//处方ID
				String medicalRecordID=rs.getString(2);//病历ID
				String registrationID=rs.getString(3);//挂号ID
				String doctorID=rs.getString(4);//开立医生ID
				String prescriptionName=rs.getString(5);//处方名称
				String prescriptionTime=rs.getString(6);//开立时间
				String prescriptionStatus=rs.getString(7);//处方状态
				po_17prescription prescription=new po_17prescription(prescriptionID,medicalRecordID,registrationID,doctorID,prescriptionName,prescriptionTime,prescriptionStatus);
				return prescription;
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
	public po_17prescription findByBoth(String medicalRecordID1, String time1) {
		try {
			connection();
			this.sql="select * from 17prescription where medicalRecordID ='"+medicalRecordID1+"'and prescriptionTime='"+time1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int prescriptionID=rs.getInt(1);//处方ID
				String medicalRecordID=rs.getString(2);//病历ID
				String registrationID=rs.getString(3);//挂号ID
				String doctorID=rs.getString(4);//开立医生ID
				String prescriptionName=rs.getString(5);//处方名称
				String prescriptionTime=rs.getString(6);//开立时间
				String prescriptionStatus=rs.getString(7);//处方状态
				po_17prescription prescription=new po_17prescription(prescriptionID,medicalRecordID,registrationID,doctorID,prescriptionName,prescriptionTime,prescriptionStatus);
				return prescription;
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
	public po_17prescription findByBoth1(String medicalRecordID1, String date1) {
		try {
			connection();
			this.sql="select * from 17prescription where medicalRecordID ='"+medicalRecordID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				if(rs.getString(6).contains(date1)) {
					int prescriptionID=rs.getInt(1);//处方ID
					String medicalRecordID=rs.getString(2);//病历ID
					String registrationID=rs.getString(3);//挂号ID
					String doctorID=rs.getString(4);//开立医生ID
					String prescriptionName=rs.getString(5);//处方名称
					String prescriptionTime=rs.getString(6);//开立时间
					String prescriptionStatus=rs.getString(7);//处方状态
					po_17prescription prescription=new po_17prescription(prescriptionID,medicalRecordID,registrationID,doctorID,prescriptionName,prescriptionTime,prescriptionStatus);
					return prescription;
				}
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
