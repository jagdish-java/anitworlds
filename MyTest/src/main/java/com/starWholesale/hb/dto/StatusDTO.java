package com.starWholesale.hb.dto;

import java.io.Serializable;

public class StatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 123452234L;
	
	public StatusDTO() {
		super();
	}
	
	public StatusDTO(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.messageObject = null;
	}

	public StatusDTO(int statusCode, String statusMessage, Object messageObject) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.messageObject = messageObject;
	}
	private int statusCode;
	private String statusMessage;
	private  Object messageObject;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Object getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(Object messageObject) {
		this.messageObject = messageObject;
	}
	
}
