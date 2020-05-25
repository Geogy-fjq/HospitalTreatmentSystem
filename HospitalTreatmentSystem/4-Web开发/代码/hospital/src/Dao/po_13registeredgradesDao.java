package Dao;

import java.util.ArrayList;

import PoVo.po_13registeredgrades;

public interface po_13registeredgradesDao {
	po_13registeredgrades findByName(String Name);
	
	po_13registeredgrades findByID(int ID);
	
	ArrayList<po_13registeredgrades> findAll();
}
