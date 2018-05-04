package com.example.application.business;

import com.example.application.utils.VolumeCalculatorUtils;

/**
 * This Interface provide methods to calculate the Water Volume based on algorithm.
 */

public interface VolumeCalculator {

	/**
	 * This Methods calculate the Water Volume stored based on the array of surface profile input
	 * @param surfaceProfiles array of integers , which holds the different surface profiles.
	 * @return long after the calculation of water volume based on the input
	 * */
	public long calculateWaterVolume(int[] surfaceProfiles);
}
