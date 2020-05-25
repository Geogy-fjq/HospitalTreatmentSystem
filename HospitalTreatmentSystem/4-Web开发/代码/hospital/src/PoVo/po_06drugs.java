package PoVo;

public class po_06drugs {
	int drugID;//药品ID
	String drugCode;//药品编码
	String drugName;//药品名称
	String drugSpecification;//药品规格
	String packagingUnit;//包装单位
	String manufacturer;//生产厂家
	int drugForm;//药品剂型
	String drugType;//药品类型
	double unitPriceOfDrugs;//药品单价
	String drugMnemonicCode;//药品助记码
	String creationTime;//创建时间
	String deletedMark;//删除标记
	
	public po_06drugs(int drugID,String drugCode,String drugName,String drugSpecification,String packagingUnit,String manufacturer,int drugForm,String drugType,double unitPriceOfDrugs,String drugMnemonicCode,String creationTime,String deletedMark) {
		this.drugID=drugID;
		this.drugCode=drugCode;
		this.drugName=drugName;
		this.drugSpecification=drugSpecification;
		this.packagingUnit=packagingUnit;
		this.manufacturer=manufacturer;
		this.drugForm=drugForm;
		this.drugType=drugType;
		this.unitPriceOfDrugs=unitPriceOfDrugs;
		this.drugMnemonicCode=drugMnemonicCode;
		this.creationTime=creationTime;
		this.deletedMark=deletedMark;
	}
	
	public int getDrugID() {
		return drugID;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public String getDrugName() {
		return drugName;
	}
	public String getDrugSpecification() {
		return drugSpecification;
	}
	public String getPackagingUnit() {
		return packagingUnit;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getDrugForm() {
		return drugForm;
	}
	public String getDrugType() {
		return drugType;
	}
	public double getUnitPriceOfDrugs() {
		return unitPriceOfDrugs;
	}
	public String getDrugMnemonicCode() {
		return drugMnemonicCode;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public String getDeletedMark() {
		return deletedMark;
	}
	
	public void setDrugID(int drugID) {
		this.drugID=drugID;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode=drugCode;
	}
	public void setDrugName(String drugName) {
		this.drugName=drugName;
	}
	public void setDrugSpecification(String drugSpecification) {
		this.drugSpecification=drugSpecification;
	}
	public void setPackagingUnit(String packagingUnit) {
		this.packagingUnit=packagingUnit;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer=manufacturer;
	}
	public void setDrugForm(int drugForm) {
		this.drugForm=drugForm;
	}
	public void setDrugType(String drugType) {
		this.drugType=drugType;
	}
	public void setUnitPriceOfDrugs(double unitPriceOfDrugs) {
		this.unitPriceOfDrugs=unitPriceOfDrugs;
	}
	public void setDrugMnemonicCode(String drugMnemonicCode) {
		this.drugMnemonicCode=drugMnemonicCode;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime=creationTime;
	}
	public void setDeletedMark(String deletedMark) {
		this.deletedMark=deletedMark;
	}
	
}
