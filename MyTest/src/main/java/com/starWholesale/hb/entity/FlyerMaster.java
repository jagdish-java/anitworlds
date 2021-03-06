package com.starWholesale.hb.entity;
// Generated Jun 25, 2016 2:51:05 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FlyerMaster generated by hbm2java
 */
@Entity
@Table(name = "flyer_master", catalog = "StarWholesale")
public class FlyerMaster implements java.io.Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flyerId;
	private int imageId;
	private String redirectionUrl;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private int status;

	public FlyerMaster() {
	}

	public FlyerMaster(int flyerId, int imageId, String redirectionUrl, String description, Date createdDate,
			Date updatedDate, int status) {
		this.flyerId = flyerId;
		this.imageId = imageId;
		this.redirectionUrl = redirectionUrl;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
	}

	@Id

	@Column(name = "flyer_id", unique = true, nullable = false)
	public int getFlyerId() {
		return this.flyerId;
	}

	public void setFlyerId(int flyerId) {
		this.flyerId = flyerId;
	}

	@Column(name = "image_id", nullable = false)
	public int getImageId() {
		return this.imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	@Column(name = "redirection_url", nullable = false, length = 150)
	public String getRedirectionUrl() {
		return this.redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
