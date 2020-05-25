package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class vo_2withdrawNumberDao1 extends variable implements vo_2withdrawNumberDao{

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
	public String withdrawNumber(String registrationID) {
		try {
			connection();
			this.sql="{call 2withdrawNumber(?,?)}";
        	this.proc=con.prepareCall(sql);
        	//设置输入参数
            proc.setString(1,registrationID);
            //将数据库对象数据类型注册为java中的类型
            proc.registerOutParameter(2,Types.CHAR);
            //执行
            proc.execute();
            //接收返回值
            String result=proc.getString(2);
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
