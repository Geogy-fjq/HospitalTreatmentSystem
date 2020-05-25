package Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import PoVo.po_06drugs;

public class po_06drugsDao1 extends variable implements po_06drugsDao {
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
		public po_06drugs findByDrugName(String drugName1) {
			try {
				connection();
				this.sql="select * from 06drugs where drugName ='"+drugName1+"'";
				this.rs=con.prepareStatement(sql).executeQuery();
				if(rs.next()) {
					int drugID=rs.getInt(1);//药品ID
					String drugCode=rs.getString(2);//药品编码
					String drugName=rs.getString(3);//药品名称
					String drugSpecification=rs.getString(4);//药品规格
					String packagingUnit=rs.getString(5);//包装单位
					String manufacturer=rs.getString(6);//生产厂家
					int drugForm=rs.getInt(7);//药品剂型
					String drugType=rs.getString(8);//药品类型
					double unitPriceOfDrugs=rs.getDouble(9);//药品单价
					String drugMnemonicCode=rs.getString(10);//药品助记码
					String creationTime=rs.getString(11);//创建时间
					String deletedMark=rs.getString(12);//删除标记
					po_06drugs drug=new po_06drugs(drugID,drugCode,drugName,drugSpecification,packagingUnit,manufacturer,drugForm,drugType,unitPriceOfDrugs,drugMnemonicCode,creationTime,deletedMark);
					return drug;
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
		public po_06drugs findByDrugID(int drugID1) {
			try {
				connection();
				this.sql="select * from 06drugs where drugID ='"+drugID1+"'";
				this.rs=con.prepareStatement(sql).executeQuery();
				if(rs.next()) {
					int drugID=rs.getInt(1);//药品ID
					String drugCode=rs.getString(2);//药品编码
					String drugName=rs.getString(3);//药品名称
					String drugSpecification=rs.getString(4);//药品规格
					String packagingUnit=rs.getString(5);//包装单位
					String manufacturer=rs.getString(6);//生产厂家
					int drugForm=rs.getInt(7);//药品剂型
					String drugType=rs.getString(8);//药品类型
					double unitPriceOfDrugs=rs.getDouble(9);//药品单价
					String drugMnemonicCode=rs.getString(10);//药品助记码
					String creationTime=rs.getString(11);//创建时间
					String deletedMark=rs.getString(12);//删除标记
					po_06drugs drug=new po_06drugs(drugID,drugCode,drugName,drugSpecification,packagingUnit,manufacturer,drugForm,drugType,unitPriceOfDrugs,drugMnemonicCode,creationTime,deletedMark);
					return drug;
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
