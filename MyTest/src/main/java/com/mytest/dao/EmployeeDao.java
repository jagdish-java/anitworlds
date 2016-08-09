package com.mytest.dao;

import java.util.List;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;

public interface EmployeeDao {

	public boolean addEntity(Employee e) throws Exception;
	public boolean addAddressEntity(Empaddress e) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
