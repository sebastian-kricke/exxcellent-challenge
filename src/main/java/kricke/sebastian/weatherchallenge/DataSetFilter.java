package kricke.sebastian.weatherchallenge;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import kricke.sebastian.io.Menu;
import kricke.sebastian.reader.CsvGenericReader;
import kricke.sebastian.reader.DataReader;
import kricke.sebastian.reader.ReadingModelFailedException;
import kricke.sebastian.weather.Weather;

/**
 * Filters data sets by choosen difference calculations.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 */
public final class DataSetFilter {
	/**
	 * This is the main entry method of your program.
	 * 
	 * @param args The CLI arguments passed
	 */
	public static void main(String... args) {
		if (isValidParameter(args) && args[0].equals("--weather")) {

			runConsoleWeather();

		} else if (args.length == 0) {
			
			StartMenuControlledFilter();

		} else {
			
			showUserInfo();
			
		}
	}

	/**
	 * Proofs if CLI parameters are valid.
	 * 
	 * @param args The given command line interface parameters on start of the
	 *             application.
	 * @return Returns true if the given parameters are valid or false if at least
	 *         one doesn´t match the expectations.
	 */
	private static boolean isValidParameter(String[] args) {
		boolean ok = false;

		if (args.length == 1 || args.length == 2) {
			if ((args[0].equals("--weather"))) {
				ok = true;
			}
		}

		return ok;
	}

	/**
	 * Shows manual how to user DataSetFilter.
	 */
	private static void showUserInfo() {
		System.out.println("The call of DataSetFilter has been executed with wrong parameters.\n\n"
				+ "Valid parameters are: \n" + "... \"--weather\", \"[filename of data source]\" n \n"
				+ "The filename is optional. If not given as parameter the default resource will be filtered."
				+ "or start DataSetFilter without any parameters to run menu controlled interface.");

	}

	/**
	 * Starts a console based application. The functionality can be chosen by text
	 * menu.
	 */
	private static void StartMenuControlledFilter() {
		System.out.println(
				"\nWelcome to the filter application! In next steps you can choose your data source to display the filtered result: \n");

		int choice = 0;
		String[] menuItems = {
				"Filter weather data from CSV-Source by lowest temperature difference (Difference between Min- and Max-Temperature of the day)" };

		do {
			choice = Menu.startSelectionMenu(menuItems);

			switch (choice) {
			case 1:
				runConsoleWeather();
				break;

			default:
				break;
			}
		} while (choice > 0);
	}

	/**
	 * Starts the weather calculation on console. The weather resource is read,
	 * differences between Minimum and Maximum Temperatures of the daily weather
	 * data are calculated and the day with the lowest temperature spread is printed
	 * on output console.
	 */
	private static void runConsoleWeather() {
		// evaluate weather data by lowest temperature difference
		Weather result = getDayWithLowestTemperatureSpread();
		printResultForWeather(result);
	}

	/**
	 * Evaluates weather data from "weather.csv" to find the lowest temperature
	 * difference. Returns the found first result or null, if exception happened.
	 * 
	 * Possibly fired exception´s stacktrace are print on error console.
	 */
	private static Weather getDayWithLowestTemperatureSpread() {
		DataReader<Weather> reader = new CsvGenericReader<Weather>();

		try {
			List<Weather> existingWeatherData = reader.Read(null, "weather.csv", Weather.class);
			List<Weather> sortedWeatherDataByDifference = existingWeatherData.stream()
					.sorted(Comparator.comparing(Weather::getDifference)).collect(Collectors.toList());

			Weather weatherWithLowestTemperatureDifference = sortedWeatherDataByDifference.get(0);

			return weatherWithLowestTemperatureDifference;
		} catch (ReadingModelFailedException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Prints out the result into human readable sentence on the console.
	 * 
	 * @param result The found weather data with the smallest temperature spread in
	 *               comparison of a dataset.
	 */
	private static void printResultForWeather(Weather result) {
		System.out.printf("Day with smallest temperature spread : %s with %s degree difference%n",
				result.getDayOfMonth(), result.getDifference());
	}
}
