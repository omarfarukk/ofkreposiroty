package com.example.application.service;

import com.example.application.model.Result;
/**
 * This interface provides method to calculate the Water Volume based on array of surface profiles.
 * It provides methods to handle string input as well as integer input
 * @version 1.0
 * */
public interface CalculatorService {
	/**
	 * This Methods calculate the Water Volume stored based on the array of surface profile input
	 * @param surfaceProfiles, array of integers , which holds the different surface profiles.
	 * @return Result object after the calculation of water volume based on the input
	 * */
	long calculateWaterVolume(int[] surfaceProfiles);
	/**
	 * This Methods calculate the Water Volume stored based on the array of surface profile input
	 * @param surfaceProfiles, array of Strings , which holds the different surface profiles. Although this is an array of String but only the string representation of Integer numbers are allowed in this array
	 * @return Result object after the calculation of water volume based on the input
	 * */
	long calculateWaterVolume(String[] surfaceProfiles);

}
