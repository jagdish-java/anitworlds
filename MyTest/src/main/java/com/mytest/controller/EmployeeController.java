package com.mytest.controller;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytest.domain.Empaddress;
import com.mytest.domain.Employee;
import com.mytest.dto.EmpAddressDTO;
import com.mytest.dto.EmployeeDTO;
import com.mytest.dto.StatusDTO;
import com.mytest.service.EmployeeService;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {

	 @Autowired
	 EmployeeService dataServices;

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	// Map to store employees, ideally we should use database
	Map<Long, Employee> empData = new HashMap<Long, Employee>();

	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getDummyEmployee() throws Exception {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		
		//Statement
		 //PreparedStatement
		// CallableStatement
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999L, emp);
		dataServices.addEntity(emp);
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Created");
		statusDTO.setMessageObject(emp);
		return statusDTO;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getEmployee(@PathVariable("id") long empId) throws Exception {
		logger.info("Start getEmployee. ID=" + empId);
		Employee emp= dataServices.getEntityById(empId);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(emp.getId());
		employeeDTO.setName(emp.getName());
		employeeDTO.setCreatedDate(emp.getCreatedDate());
		List<EmpAddressDTO> empAddressDTOs = new ArrayList<EmpAddressDTO>();
		Set <Empaddress> ed = emp.getAddressList();
		Iterator iteratorAddress = ed.iterator();
		while(iteratorAddress.hasNext()){
	         Empaddress empAdd = (Empaddress)iteratorAddress.next();
	         EmpAddressDTO empAddressDTO = new EmpAddressDTO();
	         empAddressDTO.setId(empAdd.getId());
	         empAddressDTO.setEmpid(empAdd.getEmp().getId());
	         empAddressDTO.setCity(empAdd.getCity());
	         empAddressDTOs.add(empAddressDTO);
		}
		employeeDTO.setAddress(empAddressDTOs);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(employeeDTO);
		return statusDTO;
	}

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody StatusDTO getAllEmployees() throws Exception {
		logger.info("Start getAllEmployees.");
		
		List<Employee> emps = dataServices.getEntityList();
		Iterator<Employee> iteratorEmp = emps.iterator();
		List<EmployeeDTO> returnObj= new ArrayList<EmployeeDTO>();
		
		while(iteratorEmp.hasNext()){
			EmployeeDTO employeeDTO = new EmployeeDTO();
			List<EmpAddressDTO> empAddressDTOs = new ArrayList<EmpAddressDTO>();
			Employee e = iteratorEmp.next();
			if(!contains(returnObj,e.getId())) {
				employeeDTO.setId(e.getId());
				employeeDTO.setName(e.getName());
				employeeDTO.setCreatedDate(e.getCreatedDate());
				Set <Empaddress> ed = e.getAddressList();
				Iterator iteratorAddress = ed.iterator();
				while(iteratorAddress.hasNext()){
			         Empaddress empAdd = (Empaddress)iteratorAddress.next();
			         EmpAddressDTO empAddressDTO = new EmpAddressDTO();
			         empAddressDTO.setId(empAdd.getId());
			         empAddressDTO.setEmpid(empAdd.getEmp().getId());
			         empAddressDTO.setCity(empAdd.getCity());
			         empAddressDTOs.add(empAddressDTO);
				}
				employeeDTO.setAddress(empAddressDTOs);
				returnObj.add(employeeDTO);
			}
		}
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setStatusCode(1);
		statusDTO.setStatusMessage("Successfully Retrived");
		statusDTO.setMessageObject(returnObj);
		return statusDTO;
	}

	boolean contains(List<EmployeeDTO> list, long empid) {
	    for (EmployeeDTO item : list) {
	        if (item.getId()==empid) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		try {
			emp.setCreatedDate(new Date());
			dataServices.addEntity(emp);
			return emp;
		} catch (Exception e) {
			 e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_ADDRESS, method = RequestMethod.POST)
	public @ResponseBody Employee createAddress(@RequestBody Empaddress empadd) {
		logger.info("Start createEmployee.");
		try {
			Employee e1 = new Employee();
			e1.setId(1);
			e1.setName("aaaa");
			
			Empaddress a1 = new Empaddress();
			a1.setId(1L);
			a1.setCity("abcd11");
			a1.setEmp(e1);
			
			Empaddress a2 = new Empaddress();
			a2.setId(2L);
			a2.setCity("abcd12");
			a2.setEmp(e1);
			
			Empaddress a3 = new Empaddress();
			a3.setId(3L);
			a3.setCity("abcd13");
			a3.setEmp(e1);
			
			Set<Empaddress> s = new HashSet<Empaddress>();
			s.add(a1);
			s.add(a2);
			s.add(a3);
			
			e1.setAddressList(s);
			e1.setCreatedDate(new Date());
			dataServices.addEntity(e1);
		//	dataServices.addAddressEntity(empadd);
			return e1;
		} catch (Exception e) {
			 e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") long empId) throws Exception {
		logger.info("Start deleteEmployee.");
		dataServices.deleteEntity(empId);
		return null;
	}
}