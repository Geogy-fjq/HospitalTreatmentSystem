package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_16homepageofmedicalrecord;

public class po_16homepageofmedicalrecordDao1 extends variable implements po_16homepageofmedicalrecordDao {

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
	public po_16homepageofmedicalrecord findByRegisterID(String registerID) {
		try {
			connection();
			this.sql="select * from 16homepageofmedicalrecord where registrationID ='"+registerID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int medicalRecordID=rs.getInt(1);//病历ID
				String registrationID=rs.getString(2);//挂号ID
				String chiefComplaint=rs.getString(3);//主诉
				String currentMedicalHistory=rs.getString(4);//现病史
				String currentMedicalTreatment=rs.getString(5);//现病治疗情况
				String pastHistory=rs.getString(6);//既往史
				String allergyHistory=rs.getString(7);//过敏史
				String physicalExamination=rs.getString(8);//体格检查
				String preliminaryDiagnosisCategory=rs.getString(9);//初步诊断类别
				String preliminaryDiagnosis=rs.getString(10);//初步诊断
				String examinationSuggestions=rs.getString(11);//检查建议
				String attention=rs.getString(12);//注意事项
				po_16homepageofmedicalrecord homepage=new po_16homepageofmedicalrecord(medicalRecordID,registrationID,chiefComplaint,currentMedicalHistory,currentMedicalTreatment,pastHistory,allergyHistory,physicalExamination,preliminaryDiagnosisCategory,preliminaryDiagnosis,examinationSuggestions,attention);
				return homepage;
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
	public po_16homepageofmedicalrecord findByID(int ID) {
		try {
			connection();
			this.sql="select * from 16homepageofmedicalrecord where medicalRecordID ='"+ID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int medicalRecordID=rs.getInt(1);//病历ID
				String registrationID=rs.getString(2);//挂号ID
				String chiefComplaint=rs.getString(3);//主诉
				String currentMedicalHistory=rs.getString(4);//现病史
				String currentMedicalTreatment=rs.getString(5);//现病治疗情况
				String pastHistory=rs.getString(6);//既往史
				String allergyHistory=rs.getString(7);//过敏史
				String physicalExamination=rs.getString(8);//体格检查
				String preliminaryDiagnosisCategory=rs.getString(9);//初步诊断类别
				String preliminaryDiagnosis=rs.getString(10);//初步诊断
				String examinationSuggestions=rs.getString(11);//检查建议
				String attention=rs.getString(12);//注意事项
				po_16homepageofmedicalrecord homepage=new po_16homepageofmedicalrecord(medicalRecordID,registrationID,chiefComplaint,currentMedicalHistory,currentMedicalTreatment,pastHistory,allergyHistory,physicalExamination,preliminaryDiagnosisCategory,preliminaryDiagnosis,examinationSuggestions,attention);
				return homepage;
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
