package Dao;

import PoVo.po_04administrators;

public interface po_04administratorsDao {
	po_04administrators findByLoginName(String loginName);
	
	po_04administrators findByName(String Name);
	
	po_04administrators findByID(String ID);
}
