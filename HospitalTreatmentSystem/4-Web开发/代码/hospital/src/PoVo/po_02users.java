package PoVo;

public class po_02users {
	int userID;//用户ID
	String userLoginName;//登录名
	String userPassword;//登录密码
	String userName;//名称
	String departmentID;//科室ID
	String userCategory;//用户类别
	String deletedMark;//删除标记
	
	public po_02users(int userID,String userLoginName,String userPassword,String userName,String departmentID,String userCategory,String deletedMark) {
		this.userID=userID;
		this.userLoginName=userLoginName;
		this.userPassword=userPassword;
		this.userName=userName;
		this.departmentID=departmentID;
		this.userCategory=userCategory;
		this.deletedMark=deletedMark;
	}
	
	public int getUserID() {
		return userID;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public String getUserCategory() {
		return userCategory;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setUserID(int userID) {
		this.userID=userID;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName=userLoginName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword=userPassword;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID=departmentID;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory=userCategory;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
