package PoVo;

public class po_15medicalrecordform {
	int medicalRecordID;//病历ID
	String medicalRecordNumber;//病历号
	String registrationID;//挂号ID
	String examinationResult;//检查结果
	String diagnosisResult;//诊断结果
	String treatmentOpinion;//治疗建议
	String statusOfMedicalRecord;//病历状态
	
	public po_15medicalrecordform(int medicalRecordID,String medicalRecordNumber,String registrationID,String examinationResult,String diagnosisResult,String treatmentOpinion,String statusOfMedicalRecord) {
		this.medicalRecordID=medicalRecordID;
		this.medicalRecordNumber=medicalRecordNumber;
		this.registrationID=registrationID;
		this.examinationResult=examinationResult;
		this.diagnosisResult=diagnosisResult;
		this.treatmentOpinion=treatmentOpinion;
		this.statusOfMedicalRecord=statusOfMedicalRecord;
	}
	
	public int getMedicalRecordID() {
		return medicalRecordID;
	}
	public String getMedicalRecordNumber() {
		return medicalRecordNumber;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public String getExaminationResult() {
		return examinationResult;
	}
	public String getDiagnosisResult() {
		return diagnosisResult;
	}
	public String getTreatmentOpinion() {
		return treatmentOpinion;
	}
	public String getStatusOfMedicalRecord() {
		return statusOfMedicalRecord;
	}
	
	public void setMedicalRecordID(int medicalRecordID) {
		this.medicalRecordID=medicalRecordID;
	}
	public void setMedicalRecordNumber(String medicalRecordNumber) {
		this.medicalRecordNumber=medicalRecordNumber;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID=registrationID;
	}
	public void setExaminationResult(String examinationResult) {
		this.examinationResult=examinationResult;
	}
	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult=diagnosisResult;
	}
	public void setTreatmentOpinion(String treatmentOpinion) {
		this.treatmentOpinion=treatmentOpinion;
	}
	public void setStatusOfMedicalRecord(String statusOfMedicalRecord) {
		this.statusOfMedicalRecord=statusOfMedicalRecord;
	}

}
