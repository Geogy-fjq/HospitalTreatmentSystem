package PoVo;

public class po_14registrationform {
	int registrationID;//挂号ID
	int medicalRecordNumber;//病历号
	String dateOfConsultation;//看诊日期
	String noon;//午别
	String departmentID;//科室ID
	String doctorID;//医生ID
	String registeredGradeID;//挂号级别ID
	String settlementCategory;//结算类别
	String medicalRecordNeeded;//病历本要否
	String registrationTime;//挂号时间
	String registeredStaffID;//挂号员ID
	String statusOfConsultation;//看诊状态

	public po_14registrationform(int registrationID,int medicalRecordNumber,String dateOfConsultation,String noon,String departmentID,String doctorID,String registeredGradeID,String settlementCategory,String medicalRecordNeeded,String registrationTime,String registeredStaffID,String statusOfConsultation) {
		this.registrationID=registrationID;
		this.medicalRecordNumber=medicalRecordNumber;
		this.dateOfConsultation=dateOfConsultation;
		this.noon=noon;
		this.departmentID=departmentID;
		this.doctorID=doctorID;
		this.registeredGradeID=registeredGradeID;
		this.settlementCategory=settlementCategory;
		this.medicalRecordNeeded=medicalRecordNeeded;
		this.registrationTime=registrationTime;
		this.registeredStaffID=registeredStaffID;
		this.statusOfConsultation=statusOfConsultation;
	}
	
	public int getRegistrationID() {
		return registrationID;
	}
	public int getMedicalRecordNumber() {
		return medicalRecordNumber;
	}
	public String getDateOfConsultation() {
		return dateOfConsultation;
	}
	public String getNoon() {
		return noon;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public String getRegisteredGradeID() {
		return registeredGradeID;
	}
	public String getSettlementCategory() {
		return settlementCategory;
	}
	public String getMedicalRecordNeeded() {
		return medicalRecordNeeded;
	}
	public String getRegistrationTime() {
		return registrationTime;
	}
	public String getRegisteredStaffID() {
		return registeredStaffID;
	}
	public String getStatusOfConsultation() {
		return statusOfConsultation;
	}
	
	public void setRegistrationID(int registrationID) {
		this.registrationID=registrationID;
	}
	public void setMedicalRecordNumber(int medicalRecordNumber) {
		this.medicalRecordNumber=medicalRecordNumber;
	}
	public void setDateOfConsultation(String dateOfConsultation) {
		this.dateOfConsultation=dateOfConsultation;
	}
	public void setNoon(String noon) {
		this.noon=noon;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID=departmentID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID=doctorID;
	}
	public void setRegisteredGradeID(String registeredGradeID) {
		this.registeredGradeID=registeredGradeID;
	}
	public void setSettlementCategory(String settlementCategory) {
		this.settlementCategory=settlementCategory;
	}
	public void setMedicalRecordNeeded(String medicalRecordNeeded) {
		this.medicalRecordNeeded=medicalRecordNeeded;
	}
	public void setRegistrationTime(String registrationTime) {
		this.registrationTime=registrationTime;
	}
	public void setRegisteredStaffID(String registeredStaffID) {
		this.registeredStaffID=registeredStaffID;
	}
	public void setStatusOfConsultation(String statusOfConsultation) {
		this.statusOfConsultation=statusOfConsultation;
	}
}
