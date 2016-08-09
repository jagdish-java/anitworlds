package com.mytest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmployeeDTO implements Serializable {

	private Long id;
	private String name;
	private Date createdDate;
	private List<EmpAddressDTO> address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<EmpAddressDTO> getAddress() {
		return address;
	}
	public void setAddress(List<EmpAddressDTO> address) {
		this.address = address;
	}
}
