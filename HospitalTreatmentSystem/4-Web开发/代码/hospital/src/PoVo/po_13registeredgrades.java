package PoVo;

public class po_13registeredgrades {
	int registeredGradeID;//挂号等级ID
	String gradeCode;//等级编码
	String gradeName;//等级名称
	String displaySequenceNumber;//顺序码
	double registrationFee;//挂号费用
	double registrationLimit;//挂号限额
	String deletedMark;//删除标记

	public po_13registeredgrades(int registeredGradeID,String gradeCode,String gradeName,String displaySequenceNumber,double registrationFee,double registrationLimit,String deletedMark) {
		this.registeredGradeID=registeredGradeID;
		this.gradeCode=gradeCode;
		this.gradeName=gradeName;
		this.displaySequenceNumber=displaySequenceNumber;
		this.registrationFee=registrationFee;
		this.registrationLimit=registrationLimit;
		this.deletedMark=deletedMark;
	}
	
	public int getRegisteredGradeID() {
		return registeredGradeID;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public String getGradeName() {
		return gradeName;
	}
	public String getDisplaySequenceNumber() {
		return displaySequenceNumber;
	}
	public double getRegistrationFee() {
		return registrationFee;
	}
	public double getRegistrationLimit() {
		return registrationLimit;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setRegisteredGradeID(int registeredGradeID) {
		this.registeredGradeID=registeredGradeID;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode=gradeCode;
	}
	public void setGradeName(String gradeName) {
		this.gradeName=gradeName;
	}
	public void setDisplaySequenceNumber(String displaySequenceNumber) {
		this.displaySequenceNumber=displaySequenceNumber;
	}
	public void setRegistrationFee(double registrationFee) {
		this.registrationFee=registrationFee;
	}
	public void setRegistrationLimit(double registrationLimit) {
		this.registrationLimit=registrationLimit;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
