package kricke.sebastian.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

import kricke.sebastian.weather.Weather;

/**
 * Provides reading serialized model data from csv-files.
 * 
 * @author Sebastian Kricke <Sebastian.Kricke@outlook.de>
 *
 */
public class CsvWeatherReader implements DataReader<Weather> {

	@Override
	public List<Weather> Read(String source, String filename)
			throws ReadingModelFailedException, FileNotFoundException, IOException {
		if (source == null || source.isEmpty()) {
			source = "/kricke/sebastian/weatherchallenge/";
		}
		
		if(filename == null || filename.isEmpty()) {
			throw new InvalidParameterException("no filename");
		}
		
		String resourcePath = this.getClass().getResource(source + filename).getFile();
		FileReader filereader = new FileReader(resourcePath);
		List<Weather> deserialized = new CsvToBeanBuilder<Weather>(filereader).withType(Weather.class).build().parse();


		return deserialized;
	}

}
