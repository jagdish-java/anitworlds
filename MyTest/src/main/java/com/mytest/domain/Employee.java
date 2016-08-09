package com.mytest.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -7788619177798333712L;

	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "createdDate")
	private Date createdDate;
	
	@OneToMany(targetEntity=Empaddress.class, fetch = FetchType.EAGER,mappedBy="emp",cascade=CascadeType.ALL)
	private Set<Empaddress> addressList;
	
	public Set<Empaddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<Empaddress> addressList) {
		this.addressList = addressList;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressList == null) ? 0 : addressList.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addressList == null) {
			if (other.addressList != null)
				return false;
		} else if (!addressList.equals(other.addressList))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", addressList=" + addressList
				+ "]";
	}
	
	*/
}
