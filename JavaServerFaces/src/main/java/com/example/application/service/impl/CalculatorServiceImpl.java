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

import com.example.application.business.VolumeCalculator;
import com.example.application.model.Result;
import com.example.application.service.CalculatorService;

@Singleton
public class CalculatorServiceImpl implements CalculatorService {

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
		try {
			int[] surfaceProfiles = (int[]) Arrays.stream(surfaceProfilesInString).filter(element -> !element.equals("")).mapToInt(element -> Integer.parseInt(element.trim())).toArray();
			return this.calculateWaterVolume(surfaceProfiles);
		} catch (NumberFormatException e) {
			throw new RuntimeException("You have entered wrong input.Kindly provide the correct one as suggested");
		}
	}

}
