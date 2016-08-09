package com.mytest.service;

import java.util.List;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;

public interface EmployeeService {
	public boolean addEntity(Employee employee) throws Exception;
	public boolean addAddressEntity(Empaddress empaddress) throws Exception;
	public Employee getEntityById(long id) throws Exception;

	public List getEntityList() throws Exception;

	public boolean deleteEntity(long id) throws Exception;
}
