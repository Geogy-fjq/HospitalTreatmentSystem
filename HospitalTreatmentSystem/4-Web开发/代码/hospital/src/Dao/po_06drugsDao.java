package Dao;

import PoVo.po_06drugs;

public interface po_06drugsDao {
	
	po_06drugs findByDrugName(String drugName);

	po_06drugs findByDrugID(int drugID);

}
