package com.example.application.utils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.managedbeans.HelloBean;
import com.example.application.validation.ApplicationValidator;

@Singleton
public class RestControllerUtils {
	@EJB
	ApplicationUtils applicationUtils;
	private static Logger logger = LoggerFactory.getLogger(RestControllerUtils.class);
	
	public String[] consturctInputArray(String surfaceProfilesParam) {
		logger.info("Enetering consturctInputArray() entered , Params : [{}]",surfaceProfilesParam);
		String[] surfaceProfiles = null;
		surfaceProfiles = applicationUtils.extractInputAndPopulateArray(surfaceProfilesParam);
		
		if(surfaceProfiles == null || surfaceProfiles.length == 0)
			throw new RuntimeException("Please provide the numbers in comma separated (1,2,3..)/ space separated(1 2 3...) / without any separator(123...)");
		logger.info("Exiting consturctInputArray() with result : [{}] ",surfaceProfiles);
		return surfaceProfiles;
	}

}
