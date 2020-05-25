package PoVo;

public class vo_3consult {
	String name;//姓名
	String IDNumber;//身份证号
	String age;//年龄
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
	String examinationResult;//检查结果
	String diagnosisResult;//诊断结果
	String treatmentOpinion;//治疗建议
	
	public vo_3consult(String name,String IDNumber,String age,String chiefComplaint,String currentMedicalHistory,String currentMedicalTreatment,String pastHistory,String allergyHistory,String physicalExamination,String preliminaryDiagnosisCategory,String preliminaryDiagnosis,String examinationSuggestions,String attention,String examinationResult,String diagnosisResult,String treatmentOpinion) {
		this.name=name;
		this.IDNumber=IDNumber;
		this.age=age;
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
		this.examinationResult=examinationResult;
		this.diagnosisResult=diagnosisResult;
		this.treatmentOpinion=treatmentOpinion;
	}
	
	public String getName() {
		return name;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public String getage() {
		return age;
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
	public String getExaminationResult() {
		return examinationResult;
	}
	public String getDiagnosisResult() {
		return diagnosisResult;
	}
	public String getTreatmentOpinion() {
		return treatmentOpinion;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setIDNumber(String IDNumber) {
		this.IDNumber=IDNumber;
	}
	public void setAge(String age) {
		this.age=age;
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
	public void setExaminationResult(String examinationResult) {
		this.examinationResult=examinationResult;
	}
	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult=diagnosisResult;
	}
	public void setTreatmentOpinion(String treatmentOpinion) {
		this.treatmentOpinion=treatmentOpinion;
	}
}
