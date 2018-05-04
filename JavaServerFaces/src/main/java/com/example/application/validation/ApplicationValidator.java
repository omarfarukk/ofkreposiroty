package com.example.application.validation;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.managedbeans.HelloBean;

@Singleton
public class ApplicationValidator {
	private static Logger logger = LoggerFactory.getLogger(ApplicationValidator.class);
	public boolean isSurfaceProfilesInputValid(String surfaceProfilesParam) {
		logger.info("Enetering isSurfaceProfilesInputValid() entered , Params : [{}]",surfaceProfilesParam);
		boolean isValid = false;
		try {
			if(surfaceProfilesParam.trim().equals(""))
				isValid =  false;
			else if(surfaceProfilesParam.trim().contains(",") && surfaceProfilesParam.matches("[\\s]+"))
				isValid =  false;
		    else if(surfaceProfilesParam.trim().contains(",") && surfaceProfilesParam.matches("[\\d,\\s]+"))
		    	isValid =  true;
			else if(surfaceProfilesParam.matches("[\\d\\s]+"))
				isValid =  true;
			else if(surfaceProfilesParam.trim().matches("\\d+"))
				isValid =  true;
			else
				isValid =  false;
		}finally {
			logger.info("Exiting isSurfaceProfilesInputValid() with status : [{}] ",isValid);
		}
		return isValid;
	}

}
