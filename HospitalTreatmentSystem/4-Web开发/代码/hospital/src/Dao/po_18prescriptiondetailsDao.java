package Dao;

import java.util.ArrayList;

import PoVo.po_18prescriptiondetails;

public interface po_18prescriptiondetailsDao {
	
	ArrayList<po_18prescriptiondetails> findByPrescriptionID(int prescriptionID);
	
}
