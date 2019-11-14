/**
 * 
 */
package kricke.sebastian.football;

import com.opencsv.bean.CsvBindByName;

import kricke.sebastian.filter.Differentiable;

/**
 * Construction plan to represent the football outcome data of one team. It
 * stores divers statistics like number of games or goals..
 * 
 * Provides calculation of goal difference for the team.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class FootballOutcome implements FootballData, Differentiable<Integer> {

	@CsvBindByName()
	private int points;
	@CsvBindByName()
	private int goalsAllowed;
	@CsvBindByName()
	private int goals;
	@CsvBindByName()
	private int draws;
	@CsvBindByName()
	private int losses;
	@CsvBindByName()
	private int wins;
	@CsvBindByName()
	private int games;
	@CsvBindByName()
	private String teamName;
	private Integer difference;

	/**
	 * Default constructor for default valued instance.
	 */
	public FootballOutcome() {
		this(-1, -1);
	}

	/**
	 * Instantiates a new football outcome of a team with given number of goals the
	 * team scored and let in.
	 * 
	 * @param numberOfGoals        The amount of all successful goals.
	 * @param numberOfGoalsAllowed The amount of all goals the team let in.
	 */
	public FootballOutcome(int numberOfGoals, int numberOfGoalsAllowed) {
		super();
		this.goals = numberOfGoals;
		this.goalsAllowed = numberOfGoalsAllowed;

		calculateDifference();
	}

	@Override
	public void calculateDifference() {
		difference = getGoals() - getGoalsAllowed();
	}

	@Override
	public Integer getDifference() {
		return difference;
	}

	@Override
	public String getTeamName() {
		return teamName;
	}

	@Override
	public void setTeamName(String name) {
		this.teamName = name;
	}

	@Override
	public int getGames() {

		return games;
	}

	@Override
	public void setGames(int totalGames) {
		this.games = totalGames;
	}

	@Override
	public int getWins() {
		return wins;
	}

	@Override
	public void setWins(int numberOfWins) {
		this.wins = numberOfWins;
	}

	@Override
	public int getLosses() {
		return losses;
	}

	@Override
	public void setLosses(int numberOfLosses) {
		this.losses = numberOfLosses;
	}

	@Override
	public int getDraws() {
		return draws;
	}

	@Override
	public void setDraws(int numberOfDraws) {
		this.draws = numberOfDraws;
	}

	@Override
	public int getGoals() {
		return goals;
	}

	@Override
	public void setGoals(int numberOfGoals) {
		this.goals = numberOfGoals;
	}

	@Override
	public int getGoalsAllowed() {
		return goalsAllowed;
	}

	@Override
	public void setGoalsAllowed(int numberOfGoalsAllowed) {
		this.goalsAllowed = numberOfGoalsAllowed;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int teamPoints) {
		this.points = teamPoints;
	}

}
