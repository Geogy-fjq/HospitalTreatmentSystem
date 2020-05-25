package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//配置设置
public class variable {
	public String url="jdbc:mysql://localhost:3306/hospital?user=root&password=123456&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	public String jdbcName="com.mysql.jdbc.Driver";
	public Connection con=null;
	public Statement st=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	public String sql=null;
	public CallableStatement proc=null;

}
