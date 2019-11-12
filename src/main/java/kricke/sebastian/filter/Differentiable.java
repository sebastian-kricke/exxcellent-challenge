package kricke.sebastian.filter;

/**
 * Imposes to calculate a difference of two equal typed member variables for analysis.  
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 * @param <T> Any type of number that allows to calculate a difference between them.
 */
public interface Differentiable<T extends Number> {
	/**
	 * Calculates the current difference between two values.
	 */
	public void calculateDifference();

	/**
	 * Returns the last calculated difference.
	 * @return The difference between two values.
	 */
	public T getDifference();
}
