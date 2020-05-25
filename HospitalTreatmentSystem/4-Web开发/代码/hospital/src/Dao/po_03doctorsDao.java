package Dao;

import java.util.ArrayList;

import PoVo.po_03doctors;

public interface po_03doctorsDao {
	po_03doctors findByLoginName(String loginName);
	
	po_03doctors findByName(String Name);
	
	po_03doctors findByID(String ID);
	
	ArrayList<po_03doctors> findAll();
	
	ArrayList<po_03doctors> findDesignatedAll(String departmentID,String registeredGradeID);
	
	ArrayList<po_03doctors> finddepartmentIDAll(String departmentID);

	ArrayList<po_03doctors> findregisteredGradeIDAll(String registeredGradeID);
}
