package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_01patients;

public class po_01patientsDao1 extends variable implements po_01patientsDao {

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
	public po_01patients findByMedicalRecordNumber(String MedicalRecordNumber1) {
		try {
			connection();
			this.sql="select * from 01patients where MedicalRecordNumber ='"+MedicalRecordNumber1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int patientID=rs.getInt(1);//患者ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String patientIDNumber=rs.getString(3);//身份证号
				String patientName=rs.getString(4);//名字
				String patientSex=rs.getString(5);//性别
				String patientBirthday=rs.getString(6);//出生日期
				int patientAge=rs.getInt(7);//年龄
				String patientAgeType=rs.getString(8);//年龄类型
				String patientAddress=rs.getString(9);//家庭住址
				String deletedMark=rs.getString(10);//删除标记
				po_01patients patient=new po_01patients(patientID,medicalRecordNumber,patientIDNumber,patientName,patientSex,patientBirthday,patientAge,patientAgeType,patientAddress,deletedMark);
				return patient;
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
	public po_01patients findByName(String name1) {
		try {
			connection();
			this.sql="select * from 01patients where patientName ='"+name1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int patientID=rs.getInt(1);//患者ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String patientIDNumber=rs.getString(3);//身份证号
				String patientName=rs.getString(4);//名字
				String patientSex=rs.getString(5);//性别
				String patientBirthday=rs.getString(6);//出生日期
				int patientAge=rs.getInt(7);//年龄
				String patientAgeType=rs.getString(8);//年龄类型
				String patientAddress=rs.getString(9);//家庭住址
				String deletedMark=rs.getString(10);//删除标记
				po_01patients patient=new po_01patients(patientID,medicalRecordNumber,patientIDNumber,patientName,patientSex,patientBirthday,patientAge,patientAgeType,patientAddress,deletedMark);
				return patient;
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
	public po_01patients findByID(String ID1) {
		try {
			connection();
			this.sql="select * from 01patients where patientIDNumber ='"+ID1+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int patientID=rs.getInt(1);//患者ID
				int medicalRecordNumber=rs.getInt(2);//病历号
				String patientIDNumber=rs.getString(3);//身份证号
				String patientName=rs.getString(4);//名字
				String patientSex=rs.getString(5);//性别
				String patientBirthday=rs.getString(6);//出生日期
				int patientAge=rs.getInt(7);//年龄
				String patientAgeType=rs.getString(8);//年龄类型
				String patientAddress=rs.getString(9);//家庭住址
				String deletedMark=rs.getString(10);//删除标记
				po_01patients patient=new po_01patients(patientID,medicalRecordNumber,patientIDNumber,patientName,patientSex,patientBirthday,patientAge,patientAgeType,patientAddress,deletedMark);
				return patient;
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
