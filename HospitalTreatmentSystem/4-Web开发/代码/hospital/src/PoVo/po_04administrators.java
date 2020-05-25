package PoVo;

public class po_04administrators {
	int administratorID;//管理员ID
	String administratorLoginName;//登录名
	String administratorPassword;//登录密码
	String administratorName;//名称
	String departmentID;//科室ID
	String deletedMark;//删除标记

	public po_04administrators(int administratorID,String administratorLoginName,String administratorPassword,String administratorName,String departmentID,String deletedMark) {
		this.administratorID=administratorID;
		this.administratorLoginName=administratorLoginName;
		this.administratorPassword=administratorPassword;
		this.administratorName=administratorName;
		this.departmentID=departmentID;
		this.deletedMark=deletedMark;
	}
	
	public int getAdministratorID() {
		return administratorID;
	}
	public String getAdministratorLoginName() {
		return administratorLoginName;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setAdministratorID(int administratorID) {
		this.administratorID=administratorID;
	}
	public void setAdministratorLoginName(String administratorLoginName) {
		this.administratorLoginName=administratorLoginName;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword=administratorPassword;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName=administratorName;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID=departmentID;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
