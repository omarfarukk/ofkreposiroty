package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.application.TestTakProjectApplication;
import com.example.application.business.VolumeCalculator;
import com.example.application.business.impl.VolumeCalculatorImpl;
import com.example.application.controller.rest.TestTaskRestController;
import com.example.application.model.Result;
import com.example.application.service.rest.CalculatorService;
import com.example.application.service.rest.impl.CalculatorServiceImpl;
import com.example.application.utils.VolumeCalculatorUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {VolumeCalculatorUtils.class, VolumeCalculator.class,VolumeCalculatorImpl.class,CalculatorService.class,CalculatorServiceImpl.class,Result.class})
public class TestTakProjectApplicationTests {

	@Autowired
	VolumeCalculator volumeCalculator;
	@Autowired
	CalculatorService CalculatorService;
	@Test
	public void testBusinessMethods() {
		assertThat(volumeCalculator.calculateWaterVolume(new int[] {5,0,5})).isEqualTo(5);
		assertThat(volumeCalculator.calculateWaterVolume(new int[] {5,0,1})).isEqualTo(1);
		assertThat(volumeCalculator.calculateWaterVolume(new int[] {5,0,4})).isEqualTo(4);
	}

	@Test
	public void testServiceLayer() {
		assertThat(CalculatorService.calculateWaterVolume(new int[] {5,0,5}).getVolume()).isEqualTo("5 Units of Water");
		assertThat(CalculatorService.calculateWaterVolume(new int[] {5,0,1}).getVolume()).isEqualTo("1 Units of Water");
		assertThat(CalculatorService.calculateWaterVolume(new int[] {5,0,4}).getVolume()).isEqualTo("4 Units of Water");
	}
}
