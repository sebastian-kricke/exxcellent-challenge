package kricke.sebastian.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kricke.sebastian.football.FootballOutcome;
import kricke.sebastian.weather.Weather;

/**
 * Proofs if the reading functionality for weather model works as expected.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
class CsvGenericReaderTest {

	/**
	 * Tests deserialisation of weather data.
	 * Checks if the read data is matching the values. Executed by first object from
	 * weather.csv of resources file.
	 * 
	 * @throws FoundException Should not be thrown.
	 */
	@Test
	void testDeserializationWeatherFromCSV() throws Exception {
		DataReader<Weather> reader = new CsvGenericReader<Weather>();
		List<Weather> existingWeatherData = reader.Read(null, "weather.csv", Weather.class);
		Weather expectedFirst = new Weather(1, 88, 59);
		expectedFirst.setAverageTemperature(74);

		assertEquals(expectedFirst.getAverageTemperature(), existingWeatherData.get(0).getAverageTemperature());
		assertEquals(expectedFirst.getDayOfMonth(), existingWeatherData.get(0).getDayOfMonth());
		assertEquals(expectedFirst.getDifference(), existingWeatherData.get(0).getDifference());
		assertEquals(expectedFirst.getMaximumTemperature(), existingWeatherData.get(0).getMaximumTemperature());
		assertEquals(expectedFirst.getMinimumTemperature(), existingWeatherData.get(0).getMinimumTemperature());
	}

	/**
	 * Tests deserialisation of football outcome data.
	 * Checks if the read data is matching the values. Executed by first object from
	 * football.csv of resources file.
	 * 
	 * @throws FoundException Should not be thrown.
	 */
	@Test
	void testDeserializationFootballFromCSV() throws Exception {
		DataReader<FootballOutcome> reader = new CsvGenericReader<FootballOutcome>();
		List<FootballOutcome> existingWeatherData = reader.Read(null, "football.csv", FootballOutcome.class);
		FootballOutcome expectedFirst = new FootballOutcome();
		expectedFirst.setTeamName("Arsenal");
		expectedFirst.setGames(38);
		expectedFirst.setWins(26);
		expectedFirst.setLosses(9);
		expectedFirst.setDraws(3);
		expectedFirst.setGoals(79);
		expectedFirst.setGoalsAllowed(36);
		expectedFirst.setPoints(87);

		assertEquals(expectedFirst.getTeamName(), existingWeatherData.get(0).getTeamName());
		assertEquals(expectedFirst.getGames(), existingWeatherData.get(0).getGames());
		assertEquals(expectedFirst.getWins(), existingWeatherData.get(0).getWins());
		assertEquals(expectedFirst.getLosses(), existingWeatherData.get(0).getLosses());
		assertEquals(expectedFirst.getDraws(), existingWeatherData.get(0).getDraws());
		assertEquals(expectedFirst.getGoals(), existingWeatherData.get(0).getGoals());
		assertEquals(expectedFirst.getGoalsAllowed(), existingWeatherData.get(0).getGoalsAllowed());
		assertEquals(expectedFirst.getPoints(), existingWeatherData.get(0).getPoints());
		assertEquals(expectedFirst.getDifference(), existingWeatherData.get(0).getDifference());
	}

}
