package com.example.application.validation;

import org.springframework.stereotype.Component;

@Component
public class ApplicationValidator {
	public boolean isSurfaceProfilesInputValid(String surfaceProfilesParam) {
		
		if(surfaceProfilesParam.contains(",") && surfaceProfilesParam.matches("[\\d,]+"))
			return true;
		else if(surfaceProfilesParam.contains(" ") && surfaceProfilesParam.matches("[\\d\\s]+"))
			return true;
		else if(surfaceProfilesParam.matches("\\d+"))
			return true;
		else
			return false;
	}

}
