package kricke.sebastian.weather;

/**
 * Defines the construction frame for summarized daily weather data.
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public interface WeatherData {
	/**
	 * Gets the day of date.
	 * @return The day of month.
	 */
	public int getDayOfMonth();

	/**
	 * Sets the day of date.
	 * @param dayOfMonth The new value of the day.
	 */
	public void setDayOfMonth(int dayOfMonth);
	
	/**
	 * Gets the maximum temperature of the day.
	 * @return
	 */
	public int getMaximumTemperature();

	/** 
	 * Sets the highest temperature of the day.
	 * @param maxTemperature
	 */
	public void setMaximumTemperature(int maxTemperature);

	/**
	 * Gets the minimum temperature of the day.
	 * @return The lowest temperature of the day.
	 */
	public int getMinimumTemperature();

	/** 
	 * Sets the lowest temperature of the day.
	 * @param minTemperature The lowest temperature of the day.
	 */
	public void setMinimumTemperature(int minTemperature);

	/**
	 * Gets the average temperature of the day.
	 * @return The average temperature of the day.
	 */
	public int getAverageTemperature();

	/**
	 * Sets the average temperature of the day.
	 * @param averageTemperature The new value of average temperature.
	 */
	public void setAverageTemperature(int averageTemperature);
}
