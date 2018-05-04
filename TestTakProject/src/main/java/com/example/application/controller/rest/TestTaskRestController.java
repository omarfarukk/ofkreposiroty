package com.example.application.controller.rest;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.exception.ErrorResponse;
import com.example.application.exception.ExceptionUtils;
import com.example.application.model.Result;
import com.example.application.service.rest.CalculatorService;
import com.example.application.service.rest.impl.CalculatorServiceImpl;
import com.example.application.utils.ApplicationUtils;
import com.example.application.utils.RestControllerUtils;
import com.example.application.validation.ApplicationValidator;

@RestController("/rest")
public class TestTaskRestController {
	
	@Autowired
	CalculatorService volumeCalculator;
	@Autowired
	RestControllerUtils restControllerUtils;
	@Autowired
	ExceptionUtils exceptionUtils;
	
	@RequestMapping(method=RequestMethod.GET,value="/volume/{surfaceProfiles}")
	public Result calcuateWaterValume(@PathVariable("surfaceProfiles") String surfaceProfilesParam) {
		String[] surfaceProfiles = restControllerUtils.validateInputRequestAndConsturctInputArray(surfaceProfilesParam);
		return volumeCalculator.calculateWaterVolume(surfaceProfiles);
		
	}
	
	@RequestMapping(value="/greet")
	public String greeting() {
		return "Welocme to Spring Boot Rest";
	}
	@ExceptionHandler({Throwable.class})
	public ErrorResponse handleException(Throwable th) {
		return exceptionUtils.handleAndProcessException(th);
	}

}
