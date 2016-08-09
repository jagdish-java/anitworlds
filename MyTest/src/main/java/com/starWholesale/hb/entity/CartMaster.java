package com.starWholesale.hb.entity;
// Generated Jun 25, 2016 2:51:05 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CartMaster generated by hbm2java
 */
@Entity
@Table(name = "cart_master", catalog = "StarWholesale")
public class CartMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 689754123L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id", unique = true)
	private int cartId;
	@Column(name = "user_id", nullable = false)
	private int userId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date",  length = 19)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date",  length = 19)
	private Date updatedDate;
	@Column(name = "status")
	private int status;

	@OneToMany(targetEntity=CartDetail.class, fetch = FetchType.EAGER,mappedBy="cart",cascade=CascadeType.ALL)
	private List<CartDetail> cartItems;

	public List<CartDetail> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartDetail> cartItems) {
		this.cartItems = cartItems;
	}

	public CartMaster() {
	}

	public CartMaster(int cartId, int userId, Date createdDate, Date updatedDate, int status) {
		this.cartId = cartId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
