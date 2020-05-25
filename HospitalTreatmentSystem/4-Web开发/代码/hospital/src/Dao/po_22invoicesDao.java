package Dao;

import PoVo.po_22invoices;

public interface po_22invoicesDao {
	po_22invoices findByNumber(String Number);
	
	po_22invoices findByregisterID(String registerID);
}
