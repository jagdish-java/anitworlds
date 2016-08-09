package com.mytest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.dao.EmployeeDao;
import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dataDao;

	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

	@Override
	public boolean addAddressEntity(Empaddress empaddress) throws Exception {
		return dataDao.addAddressEntity(empaddress);
	}

}
