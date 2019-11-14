package kricke.sebastian.football;

/**
 * Defines the construction frame for summarized football game data of a soccer
 * team.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public interface FootballData {

	/**
	 * Gets the name of the team.
	 * 
	 * @return The football team´s name.
	 */
	public String getTeamName();

	/**
	 * Sets the name of the team.
	 * 
	 * @param name
	 */
	public void setTeamName(String name);

	/**
	 * Gets the number of ran games.
	 * @return The total number of already ran games.
	 */
	public int getGames();

	/**
	 * Sets the number of ran games.
	 * 
	 * @param totalGames The total number of already ran games.
	 */
	public void setGames(int totalGames);

	/**
	 * Gets the number of won games.
	 * @return The amount of all won games.
	 */
	public int getWins();

	/**
	 * Sets the number of won games.
	 * 
	 * @param numberOfWins The amount of all won games.
	 */
	public void setWins(int numberOfWins);

	/**
	 * Gets the number of lost games.
	 * @return The amount of all lost games.
	 */
	public int getLosses();

	/**
	 * Sets the number of lost games.
	 * 
	 * @param numberOfLosses The amount of all lost games.
	 */
	public void setLosses(int numberOfLosses);

	/**
	 * Gets the number of tied games.
	 * @return The amount of all games with a tie.
	 */
	public int getDraws();

	/**
	 * Sets the number of tied games.
	 * 
	 * @param numberOfDraws The amount of all games with a tie.
	 */
	public void setDraws(int numberOfDraws);

	/**
	 * Gets the number of goals
	 * @return The amount of all successful goals.
	 */
	public int getGoals();

	/**
	 * Sets the number of goals.
	 * 
	 * @param numberOfGoals The amount of all successful goals
	 */ 
	public void setGoals(int numberOfGoals);

	/**
	 * Gets the number of goals the team allowed.
	 * 
	 * @return The amount of all goals the team let in.
	 */
	public int getGoalsAllowed();

	/**
	 * Sets the number of goals the team allowed.
	 * 
	 * @param numberOfGoalsAllowed The amount of all goals the team let in.
	 *
	 */
	public void setGoalsAllowed(int numberOfGoalsAllowed);

	/**
	 * Gets the team points
	 * @return The team points.
	 */
	public int getPoints();

	/**
	 * Sets the team points
	 * 
	 * @param teamPoints The points, the team reached.
	 */
	public void setPoints(int teamPoints);
}
