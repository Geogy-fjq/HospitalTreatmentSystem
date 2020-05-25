package Dao;

import PoVo.po_15medicalrecordform;
import PoVo.po_16homepageofmedicalrecord;
import PoVo.po_17prescription;

public interface vo_3consultDao {
	
	String save(po_16homepageofmedicalrecord homepage,po_15medicalrecordform medicalrecordform);//保存看诊信息

	String submit(po_17prescription prescription,String drugIDList,String drugUsageList,String drugDosageList,String frequencyList,String quantityList);//保存处方信息

}
