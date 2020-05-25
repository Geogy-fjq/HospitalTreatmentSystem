package Dao;

import PoVo.po_15medicalrecordform;

public interface po_15medicalrecordformDao {
	po_15medicalrecordform findByRegisterID(String registerID);
	
	po_15medicalrecordform findByNumber(String Number);
	
	po_15medicalrecordform findByID(int ID);
}
