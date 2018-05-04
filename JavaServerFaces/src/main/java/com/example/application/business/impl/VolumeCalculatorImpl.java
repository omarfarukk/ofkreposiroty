package com.example.application.business.impl;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.business.VolumeCalculator;
import com.example.application.managedbeans.HelloBean;
import com.example.application.utils.VolumeCalculatorUtils;

/**
 * This Class calculate the Water Volume based on algorithm.
 */
@Singleton
public class VolumeCalculatorImpl implements VolumeCalculator {

	private static Logger logger = LoggerFactory.getLogger(VolumeCalculatorImpl.class);
	@EJB
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
		logger.info("Enetering calculateWaterVolume() , Params : [{}]",surfaceProfiles);
		long result;
		this.setSurfaceProfiles(surfaceProfiles);
		this.initializeLeftRightArray(surfaceProfiles.length);
		// Fill left array
		volumeCalculatorUtils.calculateHighestLeftSurfaces(this.surfaceProfiles, leftArray);
		// Fill right array
		volumeCalculatorUtils.calculateHighestRightSurfaces(this.surfaceProfiles, rightArray);
		//calculate result
		result = volumeCalculatorUtils.calculateVolume(this.surfaceProfiles, leftArray, rightArray);
		logger.info("Exiting calculateWaterVolume() , result : [{}]",result);
		return result;
	}

}
