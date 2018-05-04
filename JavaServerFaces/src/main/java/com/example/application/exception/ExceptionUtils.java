package com.example.application.exception;

import java.util.Date;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class ExceptionUtils {
	public ErrorResponse handleAndProcessException(Throwable th) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage("An Error occured during application processing");
		error.setTimeStamp(new Date());
		error.setDetails(th.getMessage());
		th.printStackTrace();
		return error;
	}

}
