package kricke.sebastian.weatherchallenge;

import kricke.sebastian.io.Menu;

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
			// evaluate weather data by lowest temperature difference

			String dayWithSmallestTempSpread = "20";
			System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
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
				"Filter weather data from CSV-Source by lowest temperature difference (Difference between Min-and MaxTemperature of the day)" };

		do {
			choice = Menu.startSelectionMenu(menuItems);

			switch (choice) {
			case 1:
				// evaluate weather data by lowest temperature difference
				break;

			default:
				break;
			}
		} while (choice > -1);
	}
}
