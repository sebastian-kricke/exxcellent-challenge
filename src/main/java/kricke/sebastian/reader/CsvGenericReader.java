/**
 * 
 */
package kricke.sebastian.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class CsvGenericReader<T> implements DataReader<T> {

	@Override
	public List<T> Read(String source, String filename, Class<? extends T> targetType)
			throws ReadingModelFailedException, FileNotFoundException, IOException, InvalidParameterException {
		if (source == null || source.isEmpty()) {
			source = "/kricke/sebastian/weatherchallenge/";
		}

		if (filename == null || filename.isEmpty()) {
			throw new InvalidParameterException("no filename");
		}

		String resourcePath = this.getClass().getResource(source + filename).getFile();
		FileReader filereader = new FileReader(resourcePath);
		List<T> deserialized = new CsvToBeanBuilder<T>(filereader).withType(targetType).build().parse();

		return deserialized;
	}
}
