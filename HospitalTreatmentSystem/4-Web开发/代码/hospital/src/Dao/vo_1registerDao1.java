package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import PoVo.po_01patients;
import PoVo.po_14registrationform;

public class vo_1registerDao1 extends variable implements vo_1registerDao {

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
	public String register(po_01patients patient,po_14registrationform registrationform) {
		try {
			connection();
			this.sql="{call 1register(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        	this.proc=con.prepareCall(sql);
        	//设置输入参数
            proc.setString(1,patient.getPatientIDNumber());
            proc.setString(2,patient.getPatientName());
            proc.setString(3,patient.getPatientSex());
            proc.setString(4,patient.getPatientBirthday());
            proc.setInt(5,patient.getPatientAge());
            proc.setString(6,patient.getPatientAgeType());
            proc.setString(7,patient.getPatientAddress());
            proc.setString(8,registrationform.getDateOfConsultation());
            proc.setString(9,registrationform.getNoon());
            proc.setString(10,registrationform.getDepartmentID());
            proc.setString(11,registrationform.getDoctorID());
            proc.setString(12,registrationform.getRegisteredGradeID());
            proc.setString(13,registrationform.getSettlementCategory());
            proc.setString(14,registrationform.getMedicalRecordNeeded());
            proc.setString(15,registrationform.getRegisteredStaffID());
            //将数据库对象数据类型注册为java中的类型
            proc.registerOutParameter(16,Types.CHAR);
            //执行
            proc.execute();
            //接收返回值
            String result=proc.getString(16);
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
