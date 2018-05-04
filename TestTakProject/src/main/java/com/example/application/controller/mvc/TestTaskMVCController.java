package com.example.application.controller.mvc;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

@Controller("/mvc")
public class TestTaskMVCController {
	
	@Autowired
	CalculatorService volumeCalculator;
	@Autowired
	RestControllerUtils restControllerUtils;
	@Autowired
	ExceptionUtils exceptionUtils;
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String calcuateWaterValume(ModelMap model) {
		return "Hello";
	}
	@RequestMapping(method=RequestMethod.GET,value="/hello/v2")
	public String calcuateWaterValume2(ModelMap model) {
		return "/StaticHello.hmtl";
	}
	

}
