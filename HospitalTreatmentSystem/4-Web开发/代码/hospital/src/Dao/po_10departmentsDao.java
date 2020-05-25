package Dao;

import java.util.ArrayList;

import PoVo.po_10departments;

public interface po_10departmentsDao {
	po_10departments findByName(String Name);
	
	po_10departments findByID(int ID);
	
	ArrayList<po_10departments> findAll();
}
