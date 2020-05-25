package PoVo;

public class po_10departments {
	int departmentID;//科室ID
	String departmentCode;//科室编码
	String departmentName;//科室名称
	String departmentCategory;//科室分类
	String departmentType;//科室类别
	String deletedMark;//删除标记
	
	public po_10departments(int departmentID,String departmentCode,String departmentName,String departmentCategory,String departmentType,String deletedMark) {
		this.departmentID=departmentID;
		this.departmentCode=departmentCode;
		this.departmentName=departmentName;
		this.departmentCategory=departmentCategory;
		this.departmentType=departmentType;
		this.deletedMark=deletedMark;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDepartmentCategory() {
		return departmentCategory;
	}
	public String getDepartmentType() {
		return departmentType;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setDepartmentID(int departmentID) {
		this.departmentID=departmentID;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode=departmentCode;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName=departmentName;
	}
	public void setDepartmentCategory(String departmentCategory) {
		this.departmentCategory=departmentCategory;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType=departmentType;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
