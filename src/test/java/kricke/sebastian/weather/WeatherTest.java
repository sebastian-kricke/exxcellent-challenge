package kricke.sebastian.weather;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests calculation method of weather model.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class WeatherTest {

	@Test
	void testDifferenceCalculationBySpecificConstructor() {
		Weather testDay = new Weather(0,20,15);
		Integer expectedDifference = 5;		
		
		assertEquals(expectedDifference, testDay.getDifference(), "Wrong temperature spread was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationByDefaultConstructor() {
		Weather testDay = new Weather();
		Integer expectedDifference = 0;		
		
		assertEquals(expectedDifference, testDay.getDifference(), "Wrong temperature spread was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationBySetMin() {
		Weather testDay = new Weather();
		testDay.setMinimumTemperature(-20);
		Integer expectedDifference = -280;		
		
		assertEquals(expectedDifference, testDay.getDifference(), "Wrong temperature spread was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationBySetMax() {
		Weather testDay = new Weather();
		testDay.setMaximumTemperature(-20);
		Integer expectedDifference = 280;		
		
		assertEquals(expectedDifference, testDay.getDifference(), "Wrong temperature spread was calculated by specific constructor.");
	}
	
	@Test
	void testDifferenceCalculationBySetMinMax() {
		Weather testDay = new Weather();
		testDay.setMinimumTemperature(-20);
		testDay.setMaximumTemperature(20);
		Integer expectedDifference = 40;		
		
		assertEquals(expectedDifference, testDay.getDifference(), "Wrong temperature spread was calculated by specific constructor.");
	}

}
