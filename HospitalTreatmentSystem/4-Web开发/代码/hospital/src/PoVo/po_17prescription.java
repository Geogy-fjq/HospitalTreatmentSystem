package PoVo;

public class po_17prescription {
	int prescriptionID;//处方ID
	String medicalRecordID;//病历ID
	String registrationID;//挂号ID
	String doctorID;//开立医生ID
	String prescriptionName;//处方名称
	String prescriptionTime;//开立时间
	String prescriptionStatus;//处方状态
	
	public po_17prescription(int prescriptionID,String medicalRecordID,String registrationID,String doctorID,String prescriptionName,String prescriptionTime,String prescriptionStatus) {
		this.prescriptionID=prescriptionID;
		this.medicalRecordID=medicalRecordID;
		this.registrationID=registrationID;
		this.doctorID=doctorID;
		this.prescriptionName=prescriptionName;
		this.prescriptionTime=prescriptionTime;
		this.prescriptionStatus=prescriptionStatus;
	}
	
	public int getPrescriptionID() {
		return prescriptionID;
	}
	public String getMedicalRecordID() {
		return medicalRecordID;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public String getPrescriptionName() {
		return prescriptionName;
	}
	public String getPrescriptionTime() {
		return prescriptionTime;
	}
	public String getPrescriptionStatus() {
		return prescriptionStatus;
	}
	
	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID=prescriptionID;
	}
	public void setMedicalRecordID(String medicalRecordID) {
		this.medicalRecordID=medicalRecordID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID=registrationID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID=doctorID;
	}
	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName=prescriptionName;
	}
	public void setPrescriptionTime(String prescriptionTime) {
		this.prescriptionTime=prescriptionTime;
	}
	public void setPrescriptionStatus(String prescriptionStatus) {
		this.prescriptionStatus=prescriptionStatus;
	}
}
