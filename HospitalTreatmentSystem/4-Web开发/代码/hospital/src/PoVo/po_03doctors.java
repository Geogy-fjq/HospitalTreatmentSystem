package PoVo;

public class po_03doctors {
	int doctorID;//医生ID
	String doctorLoginName;//登录名
	String doctorPassword;//登录密码
	String doctorName;//名称
	String departmentID;//科室ID
	String doctorCategory;//医生类别
	String titleID;//职称
	String scheduling;//是否排班
	String registeredGradeID;//挂号等级ID
	String deletedMark;//删除标记

	public po_03doctors(int doctorID,String doctorLoginName,String doctorPassword,String doctorName,String departmentID,String doctorCategory,String titleID,String scheduling,String registeredGradeID,String deletedMark) {
		this.doctorID=doctorID;
		this.doctorLoginName=doctorLoginName;
		this.doctorPassword=doctorPassword;
		this.doctorName=doctorName;
		this.departmentID=departmentID;
		this.doctorCategory=doctorCategory;
		this.titleID=titleID;
		this.scheduling=scheduling;
		this.registeredGradeID=registeredGradeID;
		this.deletedMark=deletedMark;
	}
	
	public int getDoctorID() {
		return doctorID;
	}
	public String getDoctorLoginName() {
		return doctorLoginName;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public String getDoctorCategory() {
		return doctorCategory;
	}
	public String getTitleID() {
		return titleID;
	}
	public String getScheduling() {
		return scheduling;
	}
	public String getRegisteredGradeID() {
		return registeredGradeID;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setDoctorID(int doctorID) {
		this.doctorID=doctorID;
	}
	public void setDoctorLoginName(String doctorLoginName) {
		this.doctorLoginName=doctorLoginName;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword=doctorPassword;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName=doctorName;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID=departmentID;
	}
	public void setDoctorCategory(String doctorCategory) {
		this.doctorCategory=doctorCategory;
	}
	public void setTitleID(String titleID) {
		this.titleID=titleID;
	}
	public void setScheduling(String scheduling) {
		this.scheduling=scheduling;
	}
	public void setRegisteredGradeID(String registeredGradeID) {
		this.registeredGradeID=registeredGradeID;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
