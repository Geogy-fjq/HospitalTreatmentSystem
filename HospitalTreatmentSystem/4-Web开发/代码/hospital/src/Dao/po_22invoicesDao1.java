package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_22invoices;

public class po_22invoicesDao1 extends variable implements po_22invoicesDao {

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
	public po_22invoices findByNumber(String Number) {
		try {
			connection();
			this.sql="select * from 22invoices where invoiceNumber ='"+Number+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int invoiceNumber=rs.getInt(1);//发票号
				double invoiceAmount=rs.getDouble(2);//发票金额
				String chargingOrRefundTime=rs.getString(3);//缴费/退费时间
				String chargingOrRefundStaffID=rs.getString(4);//缴费/退费人员
				String registrationID=rs.getString(5);//挂号ID
				String chargingMethod=rs.getString(6);//支付方式
				String redInvoiceNumber=rs.getString(7);//冲红发票号
				String invoiceStatus=rs.getString(8);//发票状态
				String effectiveStatus=rs.getString(9);//发票有效性
				po_22invoices invoice=new po_22invoices(invoiceNumber,invoiceAmount,chargingOrRefundTime,chargingOrRefundStaffID,registrationID,chargingMethod,redInvoiceNumber,invoiceStatus,effectiveStatus);
				return invoice;
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
	public po_22invoices findByregisterID(String registerID) {
		try {
			connection();
			this.sql="select * from 22invoices where registrationID ='"+registerID+"'";
			this.rs=con.prepareStatement(sql).executeQuery();
			if(rs.next()) {
				int invoiceNumber=rs.getInt(1);//发票号
				double invoiceAmount=rs.getDouble(2);//发票金额
				String chargingOrRefundTime=rs.getString(3);//缴费/退费时间
				String chargingOrRefundStaffID=rs.getString(4);//缴费/退费人员
				String registrationID=rs.getString(5);//挂号ID
				String chargingMethod=rs.getString(6);//支付方式
				String redInvoiceNumber=rs.getString(7);//冲红发票号
				String invoiceStatus=rs.getString(8);//发票状态
				String effectiveStatus=rs.getString(9);//发票有效性
				po_22invoices invoice=new po_22invoices(invoiceNumber,invoiceAmount,chargingOrRefundTime,chargingOrRefundStaffID,registrationID,chargingMethod,redInvoiceNumber,invoiceStatus,effectiveStatus);
				return invoice;
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
