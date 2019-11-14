package kricke.sebastian.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kricke.sebastian.weather.Weather;

/**
 * Proofs if the reading functionality for weather model works as expected.
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
class CsvWeatherReaderTest {

	private static CsvWeatherReader reader;
	
	/**
	 * Initializes the reader member.
	 * 
	 * @throws java.lang.Exception Thrown if preparation of reader initialization failed.
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		reader = new CsvWeatherReader();
	}
	
	/**
	 * Checks if the read data is matching the values.
	 * Executed by first object from weather.csv of resources file.
	 * @throws FoundException Should not be thrown.
	 */
	@Test
	void testDeserializationWeatherFromCSV() throws Exception {	
		List<Weather> existingWeatherData = reader.Read(null, "weather.csv");		
		Weather expectedFirst = new Weather(1, 88, 59);
		expectedFirst.setAverageTemperature(74);

		assertEquals(expectedFirst.getAverageTemperature(), existingWeatherData.get(0).getAverageTemperature());
		assertEquals(expectedFirst.getDayOfMonth(), existingWeatherData.get(0).getDayOfMonth());
		assertEquals(expectedFirst.getDifference(), existingWeatherData.get(0).getDifference());
		assertEquals(expectedFirst.getMaximumTemperature(), existingWeatherData.get(0).getMaximumTemperature());
		assertEquals(expectedFirst.getMinimumTemperature(), existingWeatherData.get(0).getMinimumTemperature());
	}

}
