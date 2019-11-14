package kricke.sebastian.weatherchallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests the possible run options of DataSetFilter.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 */
public class DataSetFilterTest {

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void runDataSetFilterWithoutParameters() {		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream("q".getBytes()));

		DataSetFilter.main();

		assertTrue(outContent.toString().contains("Welcome to the filter application!"), "Expected menu didn´t started.");
		assertTrue(outContent.toString().contains("(1)"), "Expected menu didn´t started.");
		assertTrue(outContent.toString().contains("Selection:"), "Expected menu didn´t started.");		
	}

	@Test
	public void runDataSetFilterWithInvalidParameters() {
		String expectedOutput = "The call of DataSetFilter has been executed with wrong parameters.\n\n"
				+ "Valid parameters are: \n" + "... \"--weather\", \"[filename of data source]\" n \n"
				+ "The filename is optional. If not given as parameter the default resource will be filtered."
				+ "or start DataSetFilter without any parameters to run menu controlled interface.";
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		DataSetFilter.main("--wether");

		assertTrue(outContent.toString().contains(expectedOutput), "Expected help info was not displayed.");
	}

	@Test
	public void runWeather() {
		String expectedOutput = "Day with smallest temperature spread : 14";
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));
		DataSetFilter.main("--weather");

		assertTrue(outContent.toString().contains(expectedOutput), "Weather calculation doesn´t returned the expected value.");
	}

}