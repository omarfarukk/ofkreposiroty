package com.example.application.service.rest.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.application.business.VolumeCalculator;
import com.example.application.model.Result;
import com.example.application.service.rest.CalculatorService;

@Component
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	Result result;
	@Autowired
	VolumeCalculator calculator;

	@Override
	public Result calculateWaterVolume(int[] surfaceProfiles) {
		result.setVolume(calculator.calculateWaterVolume(surfaceProfiles)+ " Units of Water");
		result.setTimestamp(new Date());
		return result;
	}

	@Override
	public Result calculateWaterVolume(String[] surfaceProfilesInString) {
		try {
			int[] surfaceProfiles = (int[]) Arrays.stream(surfaceProfilesInString).mapToInt(element -> Integer.parseInt(element)).toArray();
			this.calculateWaterVolume(surfaceProfiles);
		} catch (NumberFormatException e) {
			throw new Error("Input must contain only integer number.");
		}
		return result;
	}

}
