/**
 * 
 */
package kricke.sebastian.reader;

/**
 * Signals that a read string cannot be deserialized to the targeted type.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class ReadingModelFailedException extends Exception {
	private static final long serialVersionUID = -1526333589277019958L;
	
	 /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
	public ReadingModelFailedException(String message) {
		super(message);
	}

}
