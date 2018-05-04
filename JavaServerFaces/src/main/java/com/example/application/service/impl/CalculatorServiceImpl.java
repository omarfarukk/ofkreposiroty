package com.example.application.service.impl;

import java.util.Arrays;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.swing.text.html.parser.Element;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.business.VolumeCalculator;
import com.example.application.business.impl.VolumeCalculatorImpl;
import com.example.application.model.Result;
import com.example.application.service.CalculatorService;

@Singleton
public class CalculatorServiceImpl implements CalculatorService {

	private static Logger logger = LoggerFactory.getLogger(VolumeCalculatorImpl.class);
	@EJB
	Result result;
	@EJB
	VolumeCalculator calculator;
	
	@Override
	public long calculateWaterVolume(int[] surfaceProfiles) {
		return calculator.calculateWaterVolume(surfaceProfiles);
	}

	@Override
	public long calculateWaterVolume(String[] surfaceProfilesInString) {
		long result = 0;
		logger.info("Enetering calculateWaterVolume() , Params : [{}]",surfaceProfilesInString);
		try {
			int[] surfaceProfiles = (int[]) Arrays.stream(surfaceProfilesInString).filter(element -> !element.equals("")).mapToInt(element -> Integer.parseInt(element.trim())).toArray();
			result = this.calculateWaterVolume(surfaceProfiles);
		} catch (NumberFormatException e) {
			throw new RuntimeException("You have entered wrong input.Kindly provide the correct one as suggested");
		}finally {
			logger.info("Exiting calculateWaterVolume() , Result : [{}]",result);
		}
		return result;
	}

}
