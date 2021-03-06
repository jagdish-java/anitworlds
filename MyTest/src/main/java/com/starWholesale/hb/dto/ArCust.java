package com.starWholesale.hb.dto;
// Generated Jun 30, 2016 1:01:41 AM by Hibernate Tools 4.3.1.Final

/**
 * ArCustId generated by hbm2java
 */
public class ArCust implements java.io.Serializable {

	private String custNo;
	private String nam;
	private String namUpr;
	private String fstNam;
	private String fstNamUpr;
	private String lstNam;
	private String lstNamUpr;
	private String salutation;
	private String custTyp;
	private String adrs1;
	private String adrs2;
	private String adrs3;
	private String city;
	private String state;
	private String zipCod;
	private String cntry;
	private String phone1;
	private String phone2;
	private String mblPhone1;
	private String mblPhone2;
	private String fax1;
	private String fax2;
	private String contct1;
	private String contct2;
	private String emailAdrs1;
	private String emailAdrs2;

	public ArCust() {
	}

	public ArCust(String custNo, String nam, String custTyp) {
		this.custNo = custNo;
		this.nam = nam;
		this.custTyp = custTyp;
	}

	public ArCust(String custNo, String nam, String namUpr, String fstNam, String fstNamUpr, String lstNam,
			String lstNamUpr, String salutation, String custTyp, String adrs1, String adrs2, String adrs3, String city,
			String state, String zipCod, String cntry, String phone1, String phone2, String mblPhone1, String mblPhone2,
			String fax1, String fax2, String contct1, String contct2, String emailAdrs1, String emailAdrs2) {
		this.custNo = custNo;
		this.nam = nam;
		this.namUpr = namUpr;
		this.fstNam = fstNam;
		this.fstNamUpr = fstNamUpr;
		this.lstNam = lstNam;
		this.lstNamUpr = lstNamUpr;
		this.salutation = salutation;
		this.custTyp = custTyp;
		this.adrs1 = adrs1;
		this.adrs2 = adrs2;
		this.adrs3 = adrs3;
		this.city = city;
		this.state = state;
		this.zipCod = zipCod;
		this.cntry = cntry;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.mblPhone1 = mblPhone1;
		this.mblPhone2 = mblPhone2;
		this.fax1 = fax1;
		this.fax2 = fax2;
		this.contct1 = contct1;
		this.contct2 = contct2;
		this.emailAdrs1 = emailAdrs1;
		this.emailAdrs2 = emailAdrs2;
	}

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getNam() {
		return this.nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getNamUpr() {
		return this.namUpr;
	}

	public void setNamUpr(String namUpr) {
		this.namUpr = namUpr;
	}

	public String getFstNam() {
		return this.fstNam;
	}

	public void setFstNam(String fstNam) {
		this.fstNam = fstNam;
	}

	public String getFstNamUpr() {
		return this.fstNamUpr;
	}

	public void setFstNamUpr(String fstNamUpr) {
		this.fstNamUpr = fstNamUpr;
	}

	public String getLstNam() {
		return this.lstNam;
	}

	public void setLstNam(String lstNam) {
		this.lstNam = lstNam;
	}

	public String getLstNamUpr() {
		return this.lstNamUpr;
	}

	public void setLstNamUpr(String lstNamUpr) {
		this.lstNamUpr = lstNamUpr;
	}

	public String getSalutation() {
		return this.salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCustTyp() {
		return this.custTyp;
	}

	public void setCustTyp(String custTyp) {
		this.custTyp = custTyp;
	}

	public String getAdrs1() {
		return this.adrs1;
	}

	public void setAdrs1(String adrs1) {
		this.adrs1 = adrs1;
	}

	public String getAdrs2() {
		return this.adrs2;
	}

	public void setAdrs2(String adrs2) {
		this.adrs2 = adrs2;
	}

	public String getAdrs3() {
		return this.adrs3;
	}

	public void setAdrs3(String adrs3) {
		this.adrs3 = adrs3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCod() {
		return this.zipCod;
	}

	public void setZipCod(String zipCod) {
		this.zipCod = zipCod;
	}

	public String getCntry() {
		return this.cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getMblPhone1() {
		return this.mblPhone1;
	}

	public void setMblPhone1(String mblPhone1) {
		this.mblPhone1 = mblPhone1;
	}

	public String getMblPhone2() {
		return this.mblPhone2;
	}

	public void setMblPhone2(String mblPhone2) {
		this.mblPhone2 = mblPhone2;
	}

	public String getFax1() {
		return this.fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getFax2() {
		return this.fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}

	public String getContct1() {
		return this.contct1;
	}

	public void setContct1(String contct1) {
		this.contct1 = contct1;
	}

	public String getContct2() {
		return this.contct2;
	}

	public void setContct2(String contct2) {
		this.contct2 = contct2;
	}

	public String getEmailAdrs1() {
		return this.emailAdrs1;
	}

	public void setEmailAdrs1(String emailAdrs1) {
		this.emailAdrs1 = emailAdrs1;
	}

	public String getEmailAdrs2() {
		return this.emailAdrs2;
	}

	public void setEmailAdrs2(String emailAdrs2) {
		this.emailAdrs2 = emailAdrs2;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ArCust))
			return false;
		ArCust castOther = (ArCust) other;

		return ((this.getCustNo() == castOther.getCustNo()) || (this.getCustNo() != null
				&& castOther.getCustNo() != null && this.getCustNo().equals(castOther.getCustNo())))
				&& ((this.getNam() == castOther.getNam()) || (this.getNam() != null && castOther.getNam() != null
						&& this.getNam().equals(castOther.getNam())))
				&& ((this.getNamUpr() == castOther.getNamUpr()) || (this.getNamUpr() != null
						&& castOther.getNamUpr() != null && this.getNamUpr().equals(castOther.getNamUpr())))
				&& ((this.getFstNam() == castOther.getFstNam()) || (this.getFstNam() != null
						&& castOther.getFstNam() != null && this.getFstNam().equals(castOther.getFstNam())))
				&& ((this.getFstNamUpr() == castOther.getFstNamUpr()) || (this.getFstNamUpr() != null
						&& castOther.getFstNamUpr() != null && this.getFstNamUpr().equals(castOther.getFstNamUpr())))
				&& ((this.getLstNam() == castOther.getLstNam()) || (this.getLstNam() != null
						&& castOther.getLstNam() != null && this.getLstNam().equals(castOther.getLstNam())))
				&& ((this.getLstNamUpr() == castOther.getLstNamUpr()) || (this.getLstNamUpr() != null
						&& castOther.getLstNamUpr() != null && this.getLstNamUpr().equals(castOther.getLstNamUpr())))
				&& ((this.getSalutation() == castOther.getSalutation()) || (this.getSalutation() != null
						&& castOther.getSalutation() != null && this.getSalutation().equals(castOther.getSalutation())))
				&& ((this.getCustTyp() == castOther.getCustTyp()) || (this.getCustTyp() != null
						&& castOther.getCustTyp() != null && this.getCustTyp().equals(castOther.getCustTyp())))
				&& ((this.getAdrs1() == castOther.getAdrs1()) || (this.getAdrs1() != null
						&& castOther.getAdrs1() != null && this.getAdrs1().equals(castOther.getAdrs1())))
				&& ((this.getAdrs2() == castOther.getAdrs2()) || (this.getAdrs2() != null
						&& castOther.getAdrs2() != null && this.getAdrs2().equals(castOther.getAdrs2())))
				&& ((this.getAdrs3() == castOther.getAdrs3()) || (this.getAdrs3() != null
						&& castOther.getAdrs3() != null && this.getAdrs3().equals(castOther.getAdrs3())))
				&& ((this.getCity() == castOther.getCity()) || (this.getCity() != null && castOther.getCity() != null
						&& this.getCity().equals(castOther.getCity())))
				&& ((this.getState() == castOther.getState()) || (this.getState() != null
						&& castOther.getState() != null && this.getState().equals(castOther.getState())))
				&& ((this.getZipCod() == castOther.getZipCod()) || (this.getZipCod() != null
						&& castOther.getZipCod() != null && this.getZipCod().equals(castOther.getZipCod())))
				&& ((this.getCntry() == castOther.getCntry()) || (this.getCntry() != null
						&& castOther.getCntry() != null && this.getCntry().equals(castOther.getCntry())))
				&& ((this.getPhone1() == castOther.getPhone1()) || (this.getPhone1() != null
						&& castOther.getPhone1() != null && this.getPhone1().equals(castOther.getPhone1())))
				&& ((this.getPhone2() == castOther.getPhone2()) || (this.getPhone2() != null
						&& castOther.getPhone2() != null && this.getPhone2().equals(castOther.getPhone2())))
				&& ((this.getMblPhone1() == castOther.getMblPhone1()) || (this.getMblPhone1() != null
						&& castOther.getMblPhone1() != null && this.getMblPhone1().equals(castOther.getMblPhone1())))
				&& ((this.getMblPhone2() == castOther.getMblPhone2()) || (this.getMblPhone2() != null
						&& castOther.getMblPhone2() != null && this.getMblPhone2().equals(castOther.getMblPhone2())))
				&& ((this.getFax1() == castOther.getFax1()) || (this.getFax1() != null && castOther.getFax1() != null
						&& this.getFax1().equals(castOther.getFax1())))
				&& ((this.getFax2() == castOther.getFax2()) || (this.getFax2() != null && castOther.getFax2() != null
						&& this.getFax2().equals(castOther.getFax2())))
				&& ((this.getContct1() == castOther.getContct1()) || (this.getContct1() != null
						&& castOther.getContct1() != null && this.getContct1().equals(castOther.getContct1())))
				&& ((this.getContct2() == castOther.getContct2()) || (this.getContct2() != null
						&& castOther.getContct2() != null && this.getContct2().equals(castOther.getContct2())))
				&& ((this.getEmailAdrs1() == castOther.getEmailAdrs1()) || (this.getEmailAdrs1() != null
						&& castOther.getEmailAdrs1() != null && this.getEmailAdrs1().equals(castOther.getEmailAdrs1())))
				&& ((this.getEmailAdrs2() == castOther.getEmailAdrs2())
						|| (this.getEmailAdrs2() != null && castOther.getEmailAdrs2() != null
								&& this.getEmailAdrs2().equals(castOther.getEmailAdrs2())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCustNo() == null ? 0 : this.getCustNo().hashCode());
		result = 37 * result + (getNam() == null ? 0 : this.getNam().hashCode());
		result = 37 * result + (getNamUpr() == null ? 0 : this.getNamUpr().hashCode());
		result = 37 * result + (getFstNam() == null ? 0 : this.getFstNam().hashCode());
		result = 37 * result + (getFstNamUpr() == null ? 0 : this.getFstNamUpr().hashCode());
		result = 37 * result + (getLstNam() == null ? 0 : this.getLstNam().hashCode());
		result = 37 * result + (getLstNamUpr() == null ? 0 : this.getLstNamUpr().hashCode());
		result = 37 * result + (getSalutation() == null ? 0 : this.getSalutation().hashCode());
		result = 37 * result + (getCustTyp() == null ? 0 : this.getCustTyp().hashCode());
		result = 37 * result + (getAdrs1() == null ? 0 : this.getAdrs1().hashCode());
		result = 37 * result + (getAdrs2() == null ? 0 : this.getAdrs2().hashCode());
		result = 37 * result + (getAdrs3() == null ? 0 : this.getAdrs3().hashCode());
		result = 37 * result + (getCity() == null ? 0 : this.getCity().hashCode());
		result = 37 * result + (getState() == null ? 0 : this.getState().hashCode());
		result = 37 * result + (getZipCod() == null ? 0 : this.getZipCod().hashCode());
		result = 37 * result + (getCntry() == null ? 0 : this.getCntry().hashCode());
		result = 37 * result + (getPhone1() == null ? 0 : this.getPhone1().hashCode());
		result = 37 * result + (getPhone2() == null ? 0 : this.getPhone2().hashCode());
		result = 37 * result + (getMblPhone1() == null ? 0 : this.getMblPhone1().hashCode());
		result = 37 * result + (getMblPhone2() == null ? 0 : this.getMblPhone2().hashCode());
		result = 37 * result + (getFax1() == null ? 0 : this.getFax1().hashCode());
		result = 37 * result + (getFax2() == null ? 0 : this.getFax2().hashCode());
		result = 37 * result + (getContct1() == null ? 0 : this.getContct1().hashCode());
		result = 37 * result + (getContct2() == null ? 0 : this.getContct2().hashCode());
		result = 37 * result + (getEmailAdrs1() == null ? 0 : this.getEmailAdrs1().hashCode());
		result = 37 * result + (getEmailAdrs2() == null ? 0 : this.getEmailAdrs2().hashCode());
		return result;
	}

}
