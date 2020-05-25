package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import PoVo.po_15medicalrecordform;
import PoVo.po_16homepageofmedicalrecord;
import PoVo.po_17prescription;

public class vo_3consultDao1 extends variable implements vo_3consultDao{

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
	public String save(po_16homepageofmedicalrecord homepage, po_15medicalrecordform medicalrecordform) {
		try {
			connection();
			this.sql="{call 3consult(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        	this.proc=con.prepareCall(sql);
        	//设置输入参数
            proc.setString(1,homepage.getRegistrationID());
            proc.setString(2,homepage.getChiefComplaint());
            proc.setString(3,homepage.getCurrentMedicalHistory());
            proc.setString(4,homepage.getCurrentMedicalTreatment());
            proc.setString(5,homepage.getPastHistory());
            proc.setString(6,homepage.getAllergyHistory());
            proc.setString(7,homepage.getPhysicalExamination());
            proc.setString(8,homepage.getPreliminaryDiagnosisCategory());
            proc.setString(9,homepage.getPreliminaryDiagnosis());
            proc.setString(10,homepage.getExaminationSuggestions());
            proc.setString(11,homepage.getAttention());
            proc.setString(12,medicalrecordform.getExaminationResult());
            proc.setString(13,medicalrecordform.getDiagnosisResult());
            proc.setString(14,medicalrecordform.getTreatmentOpinion());
            //将数据库对象数据类型注册为java中的类型
            proc.registerOutParameter(15,Types.CHAR);
            //执行
            proc.execute();
            //接收返回值
            String result=proc.getString(15);
            refuse();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String submit(po_17prescription prescription,String drugIDList,String drugUsageList,String drugDosageList,String frequencyList,String quantityList) {
		try {
			connection();
			this.sql="{call 4prescribing(?,?,?,?,?,?,?,?)}";
        	this.proc=con.prepareCall(sql);
        	//设置输入参数
            proc.setString(1,prescription.getRegistrationID());
            proc.setString(2,prescription.getPrescriptionName());
            proc.setString(3,drugIDList);
            proc.setString(4,drugUsageList);
            proc.setString(5,drugDosageList);
            proc.setString(6,frequencyList);
            proc.setString(7,quantityList);
            //将数据库对象数据类型注册为java中的类型
            proc.registerOutParameter(8,Types.CHAR);
            //执行
            proc.execute();
            //接收返回值
            String result=proc.getString(8);
            refuse();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
