package com.example.application.validation;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

@Singleton
public class ApplicationValidator {
	public boolean isSurfaceProfilesInputValid(String surfaceProfilesParam) {
		
		if(surfaceProfilesParam.trim().equals(""))
			return false;
		else if(surfaceProfilesParam.trim().contains(",") && surfaceProfilesParam.matches("[\\s]+"))
			return false;
	    else if(surfaceProfilesParam.trim().contains(",") && surfaceProfilesParam.matches("[\\d,\\s]+"))
			return true;
		else if(surfaceProfilesParam.matches("[\\d\\s]+"))
			return true;
		else if(surfaceProfilesParam.trim().matches("\\d+"))
			return true;
		else
			return false;
	}
	

}
