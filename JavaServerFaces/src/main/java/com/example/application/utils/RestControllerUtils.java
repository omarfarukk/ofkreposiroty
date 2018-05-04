package com.example.application.utils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

import com.example.application.validation.ApplicationValidator;

@Singleton
public class RestControllerUtils {
	@EJB
	ApplicationValidator applicationValidator;
	@EJB
	ApplicationUtils applicationUtils;
	
	public String[] validateInputRequestAndConsturctInputArray(String surfaceProfilesParam) {
		String[] surfaceProfiles = null;
		boolean isAllowed = true;
		if(applicationValidator.isSurfaceProfilesInputValid(surfaceProfilesParam)) {
			surfaceProfiles = applicationUtils.extractInputAndPopulateArray(surfaceProfilesParam);
		}
		
		if(surfaceProfiles == null || surfaceProfiles.length ==0)
			throw new RuntimeException("Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
		
		return surfaceProfiles;
	}

}
