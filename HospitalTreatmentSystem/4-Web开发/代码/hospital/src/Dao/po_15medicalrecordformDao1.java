package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_15medicalrecordform;

public class po_15medicalrecordformDao1 extends variable implements po_15medicalrecordformDao {

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
	public po_15medicalrecordform findByRegisterID(String registerID) {
		try {
			connection();
			this.sql="select * from 15medicalrecordform where registrationID ='"+registerID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int medicalRecordID=rs.getInt(1);//病历ID
				String medicalRecordNumber=rs.getString(2);//病历号
				String registrationID=rs.getString(3);//挂号ID
				String examinationResult=rs.getString(4);//检查结果
				String diagnosisResult=rs.getString(5);//诊断结果
				String treatmentOpinion=rs.getString(6);//治疗建议
				String statusOfMedicalRecord=rs.getString(7);//病历状态
				po_15medicalrecordform medicalrecordform=new po_15medicalrecordform(medicalRecordID,medicalRecordNumber,registrationID,examinationResult,diagnosisResult,treatmentOpinion,statusOfMedicalRecord);
				return medicalrecordform;
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
	public po_15medicalrecordform findByNumber(String Number) {
		try {
			connection();
			this.sql="select * from 15medicalrecordform where medicalRecordNumber ='"+Number+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int medicalRecordID=rs.getInt(1);//病历ID
				String medicalRecordNumber=rs.getString(2);//病历号
				String registrationID=rs.getString(3);//挂号ID
				String examinationResult=rs.getString(4);//检查结果
				String diagnosisResult=rs.getString(5);//诊断结果
				String treatmentOpinion=rs.getString(6);//治疗建议
				String statusOfMedicalRecord=rs.getString(7);//病历状态
				po_15medicalrecordform medicalrecordform=new po_15medicalrecordform(medicalRecordID,medicalRecordNumber,registrationID,examinationResult,diagnosisResult,treatmentOpinion,statusOfMedicalRecord);
				return medicalrecordform;
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
	public po_15medicalrecordform findByID(int ID) {
		try {
			connection();
			this.sql="select * from 15medicalrecordform where medicalRecordID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int medicalRecordID=rs.getInt(1);//病历ID
				String medicalRecordNumber=rs.getString(2);//病历号
				String registrationID=rs.getString(3);//挂号ID
				String examinationResult=rs.getString(4);//检查结果
				String diagnosisResult=rs.getString(5);//诊断结果
				String treatmentOpinion=rs.getString(6);//治疗建议
				String statusOfMedicalRecord=rs.getString(7);//病历状态
				po_15medicalrecordform medicalrecordform=new po_15medicalrecordform(medicalRecordID,medicalRecordNumber,registrationID,examinationResult,diagnosisResult,treatmentOpinion,statusOfMedicalRecord);
				return medicalrecordform;
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
