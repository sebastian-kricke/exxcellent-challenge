package kricke.sebastian.weather;

import com.opencsv.bean.CsvBindByName;

import kricke.sebastian.filter.Differentiable;

/**
 * Construction plan to represent the weather data of one day.
 * It stores temperatures.
 * 
 * Provides calculation of temperature difference for the day.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class Weather implements WeatherData, Differentiable<Integer>{

	@CsvBindByName(column = "day")
	private int dayOfMonth = -1;
	@CsvBindByName(column = "MxT")
	private int maximumTemperature = -300;
	@CsvBindByName(column = "MnT")
	private int minimumTemperature = -300;
	@CsvBindByName(column = "AvT")
	private int averageTemperature = -300;
	private Integer difference = -1;

	/**
	 * Default constructor for a weather instance with default values set.
	 */
	public Weather() {
		this(-1,-300,-300);
	}
	
	/**
	 * Stores the weather data of a single day.
	 * 
	 * The difference temperature of the day is calculated automatically.
	 * 
	 * @param dayOfMonth         The day of one month.
	 * @param maximumTemperature The highest temperature of the day.
	 * @param minimumTemperature The lowest temperature of the day.
	 */
	public Weather(int dayOfMonth, int maximumTemperature, int minimumTemperature) {
		super();
		this.dayOfMonth = dayOfMonth;
		this.maximumTemperature = maximumTemperature;
		this.minimumTemperature = minimumTemperature;
		
		calculateDifference();
	}

	/**
	 * Calculates the current difference between min and max temperature of the day.
	 */
	@Override
	public void calculateDifference() {
		difference = getMaximumTemperature() - getMinimumTemperature();
	}

	/**
	 * Gets the difference of maximum and minimum temperature calculated by {@link kricke.sebastian.weather.Weather#calculateDifference()}
	 */
	@Override
	public Integer getDifference() {		
		return difference;
	}
	
	/**
	 * Gets the day of date.
	 * @return The day of month.
	 */
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	
	/**
	 * Sets the day of date.
	 * @param dayOfMonth The new value of the day.
	 */
	public void setDayOfMonth(int day) {
		this.dayOfMonth = day;
	}

	/**
	 * Gets the maximum temperature of the day.
	 * @return
	 */
	public int getMaximumTemperature() {
		return maximumTemperature;
	}

	/** 
	 * Sets the highest temperature of the day.
	 * @param maxTemperature
	 */
	public void setMaximumTemperature(int maximum) {
		this.maximumTemperature = maximum;
		calculateDifference();
	}

	/**
	 * Gets the minimum temperature of the day.
	 * @return The lowest temperature of the day.
	 */
	public int getMinimumTemperature() {
		return minimumTemperature;
	}

	/** 
	 * Sets the lowest temperature of the day.
	 * @param minTemperature The lowest temperature of the day.
	 */
	public void setMinimumTemperature(int minimum) {
		this.minimumTemperature = minimum;
		calculateDifference();
	}

	/**
	 * Gets the average temperature of the day.
	 * @return The average temperature of the day.
	 */
	public int getAverageTemperature() {
		return averageTemperature;
	}

	/**
	 * Sets the average temperature of the day.
	 * @param averageTemperature The new value of average temperature.
	 */
	public void setAverageTemperature(int averageTemp) {
		this.averageTemperature = averageTemp;
	}
}