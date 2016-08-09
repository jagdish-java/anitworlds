package com.mytest.dto;

import java.io.Serializable;

public class StatusDTO implements Serializable {

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
