package Dao;

import java.util.ArrayList;
import PoVo.po_17prescription;

public interface po_17prescriptionDao {
	
	ArrayList<po_17prescription> findByRegistrationID(String registrationID);
	
	po_17prescription findByPrescriptionID(int prescriptionID);
	
	po_17prescription findByBoth(String medicalRecordID,String time);
	
	po_17prescription findByBoth1(String medicalRecordID,String date);

}
