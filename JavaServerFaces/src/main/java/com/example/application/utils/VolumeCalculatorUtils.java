package com.example.application.utils;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.managedbeans.HelloBean;

@Singleton
public class VolumeCalculatorUtils {
	private static Logger logger = LoggerFactory.getLogger(VolumeCalculatorUtils.class);
	public int[] calculateHighestLeftSurfaces(int[] surfaceProfiles, int[] leftArray) {
		logger.info("Enetering calculateHighestLeftSurfaces() , Params : [{}]",surfaceProfiles);
		leftArray[0] = surfaceProfiles[0];
		for (int i = 1; i < surfaceProfiles.length; i++)
			leftArray[i] = Math.max(leftArray[i - 1], surfaceProfiles[i]);
		logger.info("Enetering calculateHighestLeftSurfaces() , Result : [{}]",leftArray);
		return leftArray;
	}

	public int[] calculateHighestRightSurfaces(int[] surfaceProfiles, int[] rightArray) {
		logger.info("Enetering calculateHighestRightSurfaces() , Params : [{}]",surfaceProfiles);
		rightArray[surfaceProfiles.length - 1] = surfaceProfiles[surfaceProfiles.length - 1];
		for (int i = surfaceProfiles.length - 2; i >= 0; i--)
			rightArray[i] = Math.max(rightArray[i + 1], surfaceProfiles[i]);
		logger.info("Enetering calculateHighestRightSurfaces() , Result : [{}]",rightArray);
		return rightArray;
	}

	/**
	 *Calculate the accumulated water element by element consider the amount of water on i'th bar,
	 * the amount of water accumulated on this particular bar will be equal to min(left[i], right[i]) - arr[i] .
	 * @param three arrays. surfaceProfiles,leftArray(highest surface to the left of an surface) and rightArray (highest surface to the right of an surface)
	 * @return the calculated volume of the water stored after rain
	 * */
	public long calculateVolume(int[] surfaceProfiles, int[] leftArray, int[] rightArray) {
		logger.info("Enetering calculateVolume() , array : [{}]",surfaceProfiles);
		long waterVolume = 0;
		for (int i = 0; i < surfaceProfiles.length; i++)
			waterVolume += Math.min(leftArray[i], rightArray[i]) - surfaceProfiles[i];
		logger.info("FInal Result , Volume : [{}]",waterVolume);
		return waterVolume;
	}

}
