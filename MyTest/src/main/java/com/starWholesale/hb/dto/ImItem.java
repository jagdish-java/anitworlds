package com.starWholesale.hb.dto;
// Generated Jun 30, 2016 1:01:41 AM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.starWholesale.hb.entity.ImCategCod;

/**
 * ImItemId generated by hbm2java
 */
public class ImItem implements java.io.Serializable {

	private String itemNo;
	private String descr;
	private String descrUpr;
	private String longDescr;
	private String longDescrUpr;
	private String shortDescr;
	private String itemTyp;
	//private String categCod;
	private String subcatCod;
	private int qtyDecs;
	private int prcDecs;
	private String stkUnit;
	private BigDecimal prc1;
	private String barcod;

	private ImCategCod cat;
	private List images;
	
	public ImItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImItem(String itemNo, String descr, String descrUpr, String longDescr, String longDescrUpr,
			String shortDescr, String itemTyp, String subcatCod, int qtyDecs, int prcDecs, String stkUnit,
			BigDecimal prc1, String barcod) {
		super();
		this.itemNo = itemNo;
		this.descr = descr;
		this.descrUpr = descrUpr;
		this.longDescr = longDescr;
		this.longDescrUpr = longDescrUpr;
		this.shortDescr = shortDescr;
		this.itemTyp = itemTyp;
		this.subcatCod = subcatCod;
		this.qtyDecs = qtyDecs;
		this.prcDecs = prcDecs;
		this.stkUnit = stkUnit;
		this.prc1 = prc1;
		this.barcod = barcod;
	}

	public ImItem(String itemNo, String descr, String descrUpr, String longDescr, String longDescrUpr,
			String shortDescr, String itemTyp, String subcatCod, int qtyDecs, int prcDecs, String stkUnit,
			BigDecimal prc1, String barcod,ImCategCod cat) {
		super();
		this.itemNo = itemNo;
		this.descr = descr;
		this.descrUpr = descrUpr;
		this.longDescr = longDescr;
		this.longDescrUpr = longDescrUpr;
		this.shortDescr = shortDescr;
		this.itemTyp = itemTyp;
		this.subcatCod = subcatCod;
		this.qtyDecs = qtyDecs;
		this.prcDecs = prcDecs;
		this.stkUnit = stkUnit;
		this.prc1 = prc1;
		this.barcod = barcod;
		this.cat=cat;
	}
	
	public List getImages() {
		return images;
	}

	public void setImages(List images) {
		this.images = images;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getDescrUpr() {
		return descrUpr;
	}

	public void setDescrUpr(String descrUpr) {
		this.descrUpr = descrUpr;
	}

	public String getLongDescr() {
		return longDescr;
	}

	public void setLongDescr(String longDescr) {
		this.longDescr = longDescr;
	}

	public String getLongDescrUpr() {
		return longDescrUpr;
	}

	public void setLongDescrUpr(String longDescrUpr) {
		this.longDescrUpr = longDescrUpr;
	}

	public String getShortDescr() {
		return shortDescr;
	}

	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}

	public String getItemTyp() {
		return itemTyp;
	}

	public void setItemTyp(String itemTyp) {
		this.itemTyp = itemTyp;
	}

/*	public String getCategCod() {
		return categCod;
	}

	public void setCategCod(String categCod) {
		this.categCod = categCod;
	}
*/
	
	public String getSubcatCod() {
		return subcatCod;
	}

	public void setSubcatCod(String subcatCod) {
		this.subcatCod = subcatCod;
	}

	public int getQtyDecs() {
		return qtyDecs;
	}

	public void setQtyDecs(int qtyDecs) {
		this.qtyDecs = qtyDecs;
	}

	public int getPrcDecs() {
		return prcDecs;
	}

	public void setPrcDecs(int prcDecs) {
		this.prcDecs = prcDecs;
	}

	public String getStkUnit() {
		return stkUnit;
	}

	public void setStkUnit(String stkUnit) {
		this.stkUnit = stkUnit;
	}

	public BigDecimal getPrc1() {
		return prc1;
	}

	public void setPrc1(BigDecimal prc1) {
		this.prc1 = prc1;
	}

	public String getBarcod() {
		return barcod;
	}

	public void setBarcod(String barcod) {
		this.barcod = barcod;
	}

	public ImCategCod getCat() {
		return cat;
	}

	public void setCat(ImCategCod cat) {
		this.cat = cat;
	}

}