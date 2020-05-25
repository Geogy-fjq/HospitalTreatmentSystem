package PoVo;

public class vo_1register {
	String patientIDNumber;//身份证号
	String patientName;//名字
	String patientSex;//性别
	String patientBirthday;//出生日期
	String patientAddress;//家庭住址
	String department;//科室
	String doctor;//医生
	String medicalRecordNeeded;//病历本要否
	String registeredGrade;//挂号级别
	String settlementCategory;//结算类别
	int invoiceNumber;//发票号
	int medicalRecordNumber;//病历号
	int registrationID;//挂号ID
	double fee;//应收金额
	int patientAge;//年龄
	String patientAgeType;//年龄类型
	String registeredStaff;//挂号员
	String dateOfConsultation;//看诊日期
	String noon;//午别
	
	public vo_1register(String patientIDNumber,String patientName,String patientSex,String patientBirthday,String patientAddress,String department,String doctor,String medicalRecordNeeded,String registeredGrade,String settlementCategory,int invoiceNumber,int medicalRecordNumber,int registrationID,double fee,int patientAge,String patientAgeType,String registeredStaff,String dateOfConsultation,String noon) {
		this.patientIDNumber=patientIDNumber;
		this.patientName=patientName;
		this.patientSex=patientSex;
		this.patientBirthday=patientBirthday;
		this.patientAddress=patientAddress;
		this.department=department;
		this.doctor=doctor;
		this.medicalRecordNeeded=medicalRecordNeeded;
		this.registeredGrade=registeredGrade;
		this.settlementCategory=settlementCategory;
		this.invoiceNumber=invoiceNumber;
		this.medicalRecordNumber=medicalRecordNumber;
		this.registrationID=registrationID;
		this.fee=fee;
		this.patientAge=patientAge;
		this.patientAgeType=patientAgeType;
		this.registeredStaff=registeredStaff;
		this.dateOfConsultation=dateOfConsultation;
		this.noon=noon;
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
	public String getPatientAddress() {
		return patientAddress;
	}
	public String getDepartment() {
		return department;
	}
	public String getDoctor() {
		return doctor;
	}
	public String getMedicalRecordNeeded() {
		return medicalRecordNeeded;
	}
	public String getRegisteredGrade() {
		return registeredGrade;
	}
	public String getSettlementCategory() {
		return settlementCategory;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public int getMedicalRecordNumber() {
		return medicalRecordNumber;
	}
	public int getRegistrationID() {
		return registrationID;
	}
	public double getFee() {
		return fee;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public String getPatientAgeType() {
		return patientAgeType;
	}
	public String getRegisteredStaff() {
		return registeredStaff;
	}
	public String getDateOfConsultation() {
		return dateOfConsultation;
	}
	public String getNoon() {
		return noon;
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
	public void setPatientAddress(String patientAddress) {
		this.patientAddress=patientAddress;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public void setDoctor(String doctor) {
		this.doctor=doctor;
	}
	public void setMedicalRecordNeeded(String medicalRecordNeeded) {
		this.medicalRecordNeeded=medicalRecordNeeded;
	}
	public void setRegisteredGrade(String registeredGrade) {
		this.registeredGrade=registeredGrade;
	}
	public void setSettlementCategory(String settlementCategory) {
		this.settlementCategory=settlementCategory;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber=invoiceNumber;
	}
	public void setMedicalRecordNumber(int medicalRecordNumber) {
		this.medicalRecordNumber=medicalRecordNumber;
	}
	public void setRegistrationID(int registrationID) {
		this.registrationID=registrationID;
	}
	public void setFee(double fee) {
		this.fee=fee;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge=patientAge;
	}
	public void setPatientAgeType(String patientAgeType) {
		this.patientAgeType=patientAgeType;
	}
	public void setRegisteredStaff(String registeredStaff) {
		this.registeredStaff=registeredStaff;
	}
	public void setDateOfConsultation(String dateOfConsultation) {
		this.dateOfConsultation=dateOfConsultation;
	}
	public void setNoon(String noon) {
		this.noon=noon;
	}
}
