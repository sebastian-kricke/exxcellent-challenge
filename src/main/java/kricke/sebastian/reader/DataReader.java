package kricke.sebastian.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Defines frame for reading model data.
 * 
 * Can be extended to DAO
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
@FunctionalInterface
public interface DataReader<T> {

	/**
	 * Reads the file identified by filename and source path and deserializes the
	 * content to an object of type T filled with the read values.
	 * 
	 * @param source     The source, where to find the file.
	 * @param filename   The name of the file to read data from.
	 * @param targetType The type of the deserialized model.
	 * @return The deserialized instance of type T.
	 * @throws ReadingModelFailedException Thrown if the source file was read, but
	 *                                     deserialiation to targeted type was not
	 *                                     successful.
	 * @throws FileNotFoundException       Thrown if no file was found with the
	 *                                     given filename and source.
	 * @throws IOException                 Thrown if the found file was not read
	 *                                     successfully.
	 * @throws InvalidParameterException   Thrown if no filename was given.
	 */
	List<T> Read(String source, String filename, Class<? extends T> targetType)
			throws ReadingModelFailedException, FileNotFoundException, IOException, InvalidParameterException;
}
