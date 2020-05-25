package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class vo_5payDao1 extends variable implements vo_5payDao{

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
	public String charge(String prescriptionID, String chargingOrRefundStaffID, String chargingMethod) {
		try {
			connection();
			this.sql="{call 5pay(?,?,?,?)}";
        	this.proc=con.prepareCall(sql);
        	//设置输入参数
            proc.setString(1,prescriptionID);
            proc.setString(2,chargingOrRefundStaffID);
            proc.setString(3,chargingMethod);
            //将数据库对象数据类型注册为java中的类型
            proc.registerOutParameter(4,Types.CHAR);
            //执行
            proc.execute();
            //接收返回值
            String result=proc.getString(4);
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
