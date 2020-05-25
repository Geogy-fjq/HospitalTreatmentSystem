package Dao;

import PoVo.po_01patients;

public interface po_01patientsDao {
	
	po_01patients findByMedicalRecordNumber(String MedicalRecordNumber);
	
	po_01patients findByID(String ID);
	
	po_01patients findByName(String name);

}
