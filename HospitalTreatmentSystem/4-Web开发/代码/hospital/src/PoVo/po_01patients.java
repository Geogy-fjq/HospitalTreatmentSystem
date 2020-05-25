package PoVo;

public class po_01patients {
	int patientID;//患者ID
	int medicalRecordNumber;//病历号
	String patientIDNumber;//身份证号
	String patientName;//名字
	String patientSex;//性别
	String patientBirthday;//出生日期
	int patientAge;//年龄
	String patientAgeType;//年龄类型
	String patientAddress;//家庭住址
	String deletedMark;//删除标记
	
	public po_01patients(int patientID,int medicalRecordNumber,String patientIDNumber,String patientName,String patientSex,String patientBirthday,int patientAge,String patientAgeType,String patientAddress,String deletedMark) {
		this.patientID=patientID;
		this.medicalRecordNumber=medicalRecordNumber;
		this.patientIDNumber=patientIDNumber;
		this.patientName=patientName;
		this.patientSex=patientSex;
		this.patientBirthday=patientBirthday;
		this.patientAge=patientAge;
		this.patientAgeType=patientAgeType;
		this.patientAddress=patientAddress;
		this.deletedMark=deletedMark;
	}
	
	public int getPatientID() {
		return patientID;
	}
	public int getMedicalRecordNumber() {
		return medicalRecordNumber;
	}
	public String getPatientIDNumber() {
		return patientIDNumber;
	}
	public String getPatientName() {
		return patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public String getPatientBirthday() {
		return patientBirthday;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public String getPatientAgeType() {
		return patientAgeType;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setPatientID(int patientID) {
		this.patientID=patientID;
	}
	public void setMedicalRecordNumber(int medicalRecordNumber) {
		this.medicalRecordNumber=medicalRecordNumber;
	}
	public void setPatientIDNumber(String patientIDNumber) {
		this.patientIDNumber=patientIDNumber;
	}
	public void setPatientName(String patientName) {
		this.patientName=patientName;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex=patientSex;
	}
	public void setPatientBirthday(String patientBirthday) {
		this.patientBirthday=patientBirthday;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge=patientAge;
	}
	public void setPatientAgeType(String patientAgeType) {
		this.patientAgeType=patientAgeType;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress=patientAddress;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
}
