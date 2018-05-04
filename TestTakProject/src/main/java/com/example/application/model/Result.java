package com.example.application.model;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Result {
	private Date timestamp;
	private String volume;

	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
