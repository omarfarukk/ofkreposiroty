package com.example.application.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.application.business.VolumeCalculator;
import com.example.application.utils.VolumeCalculatorUtils;

/**
 * This Class calculate the Water Volume based on algorithm.
 */
@Component
public class VolumeCalculatorImpl implements VolumeCalculator {

	@Autowired
	VolumeCalculatorUtils volumeCalculatorUtils;

	int surfaceProfiles[] = null;
	// leftArray[i] contains height of tallest bar to the left of i'th surface including
	// itself
	int leftArray[] = null;
	// rightArray [i] contains height of tallest bar to the right of i'th surface
	// including itself
	int rightArray[] = null;
	// Initialize waterVolume
	int waterVolume = 0;

	public void setSurfaceProfiles(int[] surfaceProfiles) {
		this.surfaceProfiles = surfaceProfiles;
	}

	public void initializeLeftRightArray(int numOfElements) {
		this.leftArray = new int[numOfElements];
		this.rightArray = new int[numOfElements];
	}

	// Method for maximum amount of water
	public long calculateWaterVolume(int[] surfaceProfiles) {
		this.setSurfaceProfiles(surfaceProfiles);
		this.initializeLeftRightArray(surfaceProfiles.length);
		// Fill left array
		volumeCalculatorUtils.calculateHighestLeftSurfaces(this.surfaceProfiles, leftArray);
		// Fill right array
		volumeCalculatorUtils.calculateHighestRightSurfaces(this.surfaceProfiles, rightArray);
		return volumeCalculatorUtils.calculateVolume(this.surfaceProfiles, leftArray, rightArray);
	}

}
