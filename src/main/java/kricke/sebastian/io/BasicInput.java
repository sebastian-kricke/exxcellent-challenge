package kricke.sebastian.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Provides methods to read values from keyboard within console.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class BasicInput {
	/**
	 * Stores characters from default system input.
	 */
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Disables default constructor for usage as static method collection of system inputs only
	 */
	private BasicInput() {
	}

	
	/**
	 * Outputs the prompt on console to ask for user input.
	 * 
	 * Reads the user input into buffer and returns it as result.
	 * 
	 * @param prompt The text to request the user input.
	 * @return The inputed String.
	 */
	public static String readText(String prompt) {
		System.out.print(prompt);
		
		String text = "";
		boolean isInputOk = false;
		
		while (!isInputOk) {
			try {
				text = input.readLine();
				isInputOk = true;
			} catch (IOException ioe) {
				System.out.println(ioe);				
			}
		}
		
		return text;
	}

	/**
	 * Outputs the prompt on console to ask for specific user input.
	 * 
	 * Reads the user input into buffer and returns it as result if the input was a valid integer.
	 * Otherwise an error message is displayed as output.
	 * 
	 * @param prompt The text to request the user input.
	 * @return The inputed integer number.
	 */
	public static int readInt(String prompt) {
		int wert = 0;
		boolean error = true;
		
		while (error) {
			try {
				wert = Integer.parseInt(readText(prompt));
				error = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: wrong input was given. A valid integer number was expected.");	
			}
		}
		
		return wert;
	}

	/**
	 * Outputs the prompt on console to ask for specific user input within the given range.
	 * The range is displayed as prefix of the prompt.
	 * 
	 * Reads the user input into buffer and returns it as result if the input was a valid integer within the given range.
	 * Otherwise an error message is displayed as output respectively the ranged prompt is displayed again.
	 * 
	 * 
	 * @param prompt The text to request the user input.
	 * @param min    The minimum value to be inputed.
	 * @param max    The maximum of the valid range.
	 * @return The inputed integer number.
	 */
	public static int readInt(String prompt, int min, int max) {
		int wert = 0;
		boolean error = true;
		while (error) {
			try {
				wert = Integer.parseInt(readText(prompt + "(" + min + " to " + max + ")"));
				if (min <= wert && wert <= max) {
					error = false;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: wrong input was given. A valid integer number was expected.");	
			}
		}
		return wert;
	}

	/**
	 * Outputs the prompt on console to ask for specific user input.
	 * 
	 * Reads the user input into buffer and returns it as result if the input was a valid double.
	 * Otherwise an error message is displayed as output.
	 * 
	 * 
	 * @param prompt The text to request the user input.
	 * @return The inputed float number.
	 */
	public static double readDouble(String prompt) {
		double wert = 0.0;
		boolean error = true;
		while (error) {
			try {
				wert = Double.parseDouble(readText(prompt));
				error = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Error: wrong input was given. A valid double value was expected.");	
			}
		}
		return wert;
	}

	/** 
	 * Outputs the prompt on console to ask for specific user input within the given range.
	 * The range is displayed as prefix of the prompt.
	 * 
	 * Reads the user input into buffer and returns it as result if the input was a valid double within the range.
	 * Otherwise an error message is displayed as output respectively the ranged prompt is displayed again.
	 * 
	 * 
	 * @param prompt The text to request the user input.
	 * @param min    The minimum value to be inputed.
	 * @param max    The maximum of the valid range.
	 * @return The inputed float number.
	 */
	public static double readDouble(String prompt, double min, double max) {
		double wert = 0.0;
		boolean error = true;
		while (error) {
			try {
				wert = Double.parseDouble(readText(prompt + "(" + min + " to " + max + ")"));
				if (min <= wert && wert <= max) {
					error = false;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Error: wrong input was given. A valid double value was expected.");	
			}
		}
		return wert;
	}

	/**
	 * Identifies the amount of digits the whole number consists of.
	 * 
	 * @param number The number to be evaluated.
	 * @return The number of digits the number consists of.
	 */
	public static int getLength(int number) {
		return (int) (Math.floor(Math.log10(number)) + 1);
	}

}
