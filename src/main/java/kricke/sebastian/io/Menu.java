package kricke.sebastian.io;

/**
 * Provides methods to show a dynamically build menu and to control the menu by prompt.
 * The class needs {@link kricke.sebastian.io.BasicInput} to work as expected.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 * @version 1.0
 *
 */
public class Menu {
	/**
	 * Asks, if the application should run onwards or be quit.
	 * The user can answer with "y" (yes) oder "n" (no).
	 * 
	 * @param promp	The question to request the input.
	 * @return	Returns true if user chosen "y" or false if user inputed "n".
	 */
	public static boolean frageWeiter(String prompt) {
		boolean shouldProceed = false;
		String choice = "";
		
		do {
			choice = BasicInput.readText(prompt + " (y/n)");
		} while (!choice.equals("y") && !choice.equals("n"));
		
		if (choice.equals("y")) {
			shouldProceed = true;
		}
		return shouldProceed;
	}
	
	/**
	 * Creates a menu on console output with selectable menu points for every existing menu item.
	 * 
	 * Any invalid input will be ignored and the menu request is displayed again.
	 * 
	 * The last menu item is automatically enhanced to quit the application.
	 * 
	 * @param menuItems	The selectable menu items that can be chosen.
	 * @return	The index of the chosen menu item or "-1" to quit.
	 */
	public static int auswahlMenu(String[] menuItems) {
		String choice = "";
		int targetedMenuIndex = 0;
		
		for (int i = 0; i < menuItems.length; i++) {
			System.out.println("(" + (i + 1) + ") - " + menuItems[i]);
		}
		
		System.out.println("\n(Q) - Quit \n\n");
		
		do {
			choice = BasicInput.readText("Selection: ");
			try {
				targetedMenuIndex = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				// ignore wrong input
			}
		} while (!(choice.equals("q") || choice.equals("Q") || (targetedMenuIndex > 0 && targetedMenuIndex <= menuItems.length)));
		
		return targetedMenuIndex - 1;
	}	
	
}
