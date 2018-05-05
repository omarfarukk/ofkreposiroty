import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.application.business.VolumeCalculator;
import com.example.application.business.impl.VolumeCalculatorImpl;
import com.example.application.managedbeans.HelloBean;
import com.example.application.service.CalculatorService;
import com.example.application.service.impl.CalculatorServiceImpl;
import com.example.application.utils.RestControllerUtils;
import com.example.application.validation.ApplicationValidator;

@RunWith(value = Parameterized.class)
public class Demo {
	@Mock
	public ApplicationValidator applicationValidator;
	@Mock
	public CalculatorService calculatorService;
	@Mock
	public RestControllerUtils restControllerUtils;
	@Mock
	public VolumeCalculator volumeCalculator;
	@Mock
	public CalculatorService service;
	
	@InjectMocks
	HelloBean helloBean = new HelloBean();
	
	@Parameter(0)
	public String surfaceProfilesParam;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"303"}
        });
    }

	@BeforeClass
	public static void initBeforeClass() {
	}
	@Before
	public void initBeforeTest() {
		MockitoAnnotations.initMocks(this);
		String[] surfaceProfiles = surfaceProfilesParam.split("");
		int[] surfaceProfilesInInt = (int[]) Arrays.stream(surfaceProfiles).filter(element -> !element.equals("")).mapToInt(element -> Integer.parseInt(element.trim())).toArray();
		when(restControllerUtils.consturctInputArray(surfaceProfilesParam)).thenReturn(surfaceProfiles);
		when(calculatorService.calculateWaterVolume(surfaceProfiles)).thenReturn(3L);
	}
	
	@Test
	public void test() {
		helloBean.setSurfaceProfilesParam(surfaceProfilesParam);
		helloBean.calculateWaterValume();
		System.out.println(helloBean.getWaterVolume());
		
	}
}
