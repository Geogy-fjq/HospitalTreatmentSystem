package Dao;

import java.util.ArrayList;

import PoVo.po_14registrationform;

public interface po_14registrationformDao {
	po_14registrationform findByMedicalNumber(int medicalNumber);
	
	po_14registrationform findByID(int ID);
	
	po_14registrationform findLast();
	
	ArrayList<po_14registrationform> findReady(String doctorID);
	
	ArrayList<po_14registrationform> findAlready(String doctorID);
}
