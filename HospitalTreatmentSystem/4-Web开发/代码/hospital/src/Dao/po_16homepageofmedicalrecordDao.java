package Dao;

import PoVo.po_16homepageofmedicalrecord;

public interface po_16homepageofmedicalrecordDao {
	po_16homepageofmedicalrecord findByRegisterID(String registerID);
	
	po_16homepageofmedicalrecord findByID(int ID);
}
