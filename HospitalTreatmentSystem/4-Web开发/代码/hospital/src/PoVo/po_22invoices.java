package PoVo;

public class po_22invoices {
	int invoiceNumber;//发票号
	double invoiceAmount;//发票金额
	String chargingOrRefundTime;//缴费/退费时间
	String chargingOrRefundStaffID;//缴费/退费人员
	String registrationID;//挂号ID
	String chargingMethod;//支付方式
	String redInvoiceNumber;//冲红发票号
	String invoiceStatus;//发票状态
	String effectiveStatus;//发票有效性
	
	public po_22invoices(int invoiceNumber,double invoiceAmount,String chargingOrRefundTime,String chargingOrRefundStaffID,String registrationID,String chargingMethod,String redInvoiceNumber,String invoiceStatus,String effectiveStatus) {
		this.invoiceNumber=invoiceNumber;
		this.invoiceAmount=invoiceAmount;
		this.chargingOrRefundTime=chargingOrRefundTime;
		this.chargingOrRefundStaffID=chargingOrRefundStaffID;
		this.registrationID=registrationID;
		this.chargingMethod=chargingMethod;
		this.redInvoiceNumber=redInvoiceNumber;
		this.invoiceStatus=invoiceStatus;
		this.effectiveStatus=effectiveStatus;
	}
	
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public String getChargingOrRefundTime() {
		return chargingOrRefundTime;
	}
	public String getChargingOrRefundStaffID() {
		return chargingOrRefundStaffID;
	}
	public String getRegistrationID() {
		return registrationID;
	}
	public String getChargingMethod() {
		return chargingMethod;
	}
	public String getRedInvoiceNumber() {
		return redInvoiceNumber;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public String getEffectiveStatus() {
		return effectiveStatus;
	}
	
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber=invoiceNumber;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount=invoiceAmount;
	}
	public void setChargingOrRefundTime(String chargingOrRefundTime) {
		this.chargingOrRefundTime=chargingOrRefundTime;
	}
	public void setChargingOrRefundStaffID(String chargingOrRefundStaffID) {
		this.chargingOrRefundStaffID=chargingOrRefundStaffID;
	}
	public void setRegistrationID(String registrationID) {
		this.registrationID=registrationID;
	}
	public void setChargingMethod(String chargingMethod) {
		this.chargingMethod=chargingMethod;
	}
	public void setRedInvoiceNumber(String redInvoiceNumber) {
		this.redInvoiceNumber=redInvoiceNumber;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus=invoiceStatus;
	}
	public void setEffectiveStatus(String effectiveStatus) {
		this.effectiveStatus=effectiveStatus;
	}
}
