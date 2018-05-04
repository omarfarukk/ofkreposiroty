package com.example.application.exception;

import java.util.Date;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class ErrorResponse {
	public String message;
	public Date timeStamp;
	public String details;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
