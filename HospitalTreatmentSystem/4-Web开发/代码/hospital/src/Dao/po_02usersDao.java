package Dao;

import PoVo.po_02users;

public interface po_02usersDao {
	po_02users findByLoginName(String loginName);
	
	po_02users findByName(String Name);
	
	po_02users findByID(String ID);
}
