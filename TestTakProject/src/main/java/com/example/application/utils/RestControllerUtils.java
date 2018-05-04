package com.example.application.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.application.validation.ApplicationValidator;

@Component
public class RestControllerUtils {
	@Autowired
	ApplicationValidator applicationValidator;
	@Autowired
	ApplicationUtils applicationUtils;
	
	public String[] validateInputRequestAndConsturctInputArray(String surfaceProfilesParam) {
		String[] surfaceProfiles = null;
		if(applicationValidator.isSurfaceProfilesInputValid(surfaceProfilesParam)) {
			surfaceProfiles = applicationUtils.extractInputAndPopulateArray(surfaceProfilesParam);
		}else
			throw new RuntimeException("Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
		
		if(surfaceProfiles != null)
			return surfaceProfiles;
		else
			throw new RuntimeException("Failed to initialize the application. Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
	}

}
