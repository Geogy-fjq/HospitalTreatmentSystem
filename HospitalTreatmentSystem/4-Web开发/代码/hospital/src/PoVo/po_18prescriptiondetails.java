package PoVo;

public class po_18prescriptiondetails {
	int prescriptionDetailID;//处方明细ID
	int prescriptionID;//处方ID
	int drugID;//药品ID
	String drugUsage;//用法
	String drugDosage;//用量
	String frequency;//频次
	int quantity;//数量
	String drugStatus;//状态
	
	public po_18prescriptiondetails(int prescriptionDetailID,int prescriptionID,int drugID,String drugUsage,String drugDosage,String frequency,int quantity,String drugStatus) {
		this.prescriptionDetailID=prescriptionDetailID;
		this.prescriptionID=prescriptionID;
		this.drugID=drugID;
		this.drugUsage=drugUsage;
		this.drugDosage=drugDosage;
		this.frequency=frequency;
		this.quantity=quantity;
		this.drugStatus=drugStatus;
	}
	
	public int getPrescriptionDetailID() {
		return prescriptionDetailID;
	}
	public int getPrescriptionID() {
		return prescriptionID;
	}
	public int getDrugID() {
		return drugID;
	}
	public String getDrugUsage() {
		return drugUsage;
	}
	public String getDrugDosage() {
		return drugDosage;
	}
	public String getFrequency() {
		return frequency;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getDrugStatus() {
		return drugStatus;
	}
	
	public void setPrescriptionDetailID(int prescriptionDetailID) {
		this.prescriptionDetailID=prescriptionDetailID;
	}
	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID=prescriptionID;
	}
	public void setDrugID(int drugID) {
		this.drugID=drugID;
	}
	public void setDrugUsage(String drugUsage) {
		this.drugUsage=drugUsage;
	}
	public void setDrugDosage(String drugDosage) {
		this.drugDosage=drugDosage;
	}
	public void setFrequency(String frequency) {
		this.frequency=frequency;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public void setDrugStatus(String drugStatus) {
		this.drugStatus=drugStatus;
	}
}
