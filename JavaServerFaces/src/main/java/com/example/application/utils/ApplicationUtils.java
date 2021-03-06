package com.example.application.utils;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class ApplicationUtils {

	public String[] extractInputAndPopulateArray(String surfaceProfilesParam) {
		String[] surfaceProfiles = null;
		
		if(surfaceProfilesParam.contains(","))
			surfaceProfiles = surfaceProfilesParam.split(",");
		else if(surfaceProfilesParam.contains(" "))
			surfaceProfiles = surfaceProfilesParam.split(" ");
		else if(surfaceProfilesParam.matches("\\d+"))
			surfaceProfiles = surfaceProfilesParam.split("");
		
		return surfaceProfiles;
		
	}
}
