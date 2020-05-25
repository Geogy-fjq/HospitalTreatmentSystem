package PoVo;

public class po_16homepageofmedicalrecord {
	int medicalRecordID;//病历ID
	String registrationID;//挂号ID
	String chiefComplaint;//主诉
	String currentMedicalHistory;//现病史
	String currentMedicalTreatment;//现病治疗情况
	String pastHistory;//既往史
	String allergyHistory;//过敏史
	String physicalExamination;//体格检查
	String preliminaryDiagnosisCategory;//初步诊断类别
	String preliminaryDiagnosis;//初步诊断
	String examinationSuggestions;//检查建议
	String attention;//注意事项

	public po_16homepageofmedicalrecord(int medicalRecordID,String registrationID,String chiefComplaint,String currentMedicalHistory,String currentMedicalTreatment,String pastHistory,String allergyHistory,String physicalExamination,String preliminaryDiagnosisCategory,String preliminaryDiagnosis,String examinationSuggestions,String attention) {
		this.medicalRecordID=medicalRecordID;
		this.registrationID=registrationID;
		this.chiefComplaint=chiefComplaint;
		this.currentMedicalHistory=currentMedicalHistory;
		this.currentMedicalTreatment=currentMedicalTreatment;
		this.pastHistory=pastHistory;
		this.allergyHistory=allergyHistory;
		this.physicalExamination=physicalExamination;
		this.preliminaryDiagnosisCategory=preliminaryDiagnosisCategory;
		this.preliminaryDiagnosis=preliminaryDiagnosis;
		this.examinationSuggestions=examinationSuggestions;
		this.attention=attention;
	}
	
	public int getMedicalRecordID() {
		return medicalRecordID;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public String getCurrentMedicalHistory() {
		return currentMedicalHistory;
	}
	public String getCurrentMedicalTreatment() {
		return currentMedicalTreatment;
	}
	public String getPastHistory() {
		return pastHistory;
	}
	public String getAllergyHistory() {
		return allergyHistory;
	}
	public String getPhysicalExamination() {
		return physicalExamination;
	}
	public String getPreliminaryDiagnosisCategory() {
		return preliminaryDiagnosisCategory;
	}
	public String getPreliminaryDiagnosis() {
		return preliminaryDiagnosis;
	}
	public String getExaminationSuggestions() {
		return examinationSuggestions;
	}
	public String getAttention() {
		return attention;
	}
	
	public void setMedicalRecordID(int medicalRecordID) {
		this.medicalRecordID=medicalRecordID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID=registrationID;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint=chiefComplaint;
	}
	public void setCurrentMedicalHistory(String currentMedicalHistory) {
		this.currentMedicalHistory=currentMedicalHistory;
	}
	public void setCurrentMedicalTreatment(String currentMedicalTreatment) {
		this.currentMedicalTreatment=currentMedicalTreatment;
	}
	public void setPastHistory(String pastHistory) {
		this.pastHistory=pastHistory;
	}
	public void setAllergyHistory(String allergyHistory) {
		this.allergyHistory=allergyHistory;
	}
	public void setPhysicalExamination(String physicalExamination) {
		this.physicalExamination=physicalExamination;
	}
	public void setPreliminaryDiagnosisCategory(String preliminaryDiagnosisCategory) {
		this.preliminaryDiagnosisCategory=preliminaryDiagnosisCategory;
	}
	public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
		this.preliminaryDiagnosis=preliminaryDiagnosis;
	}
	public void setExaminationSuggestions(String examinationSuggestions) {
		this.examinationSuggestions=examinationSuggestions;
	}
	public void setAttention(String attention) {
		this.attention=attention;
	}
}
