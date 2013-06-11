package imp.model;

import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * This class contains accessors and mutators for the program's configuration file
 * @author Ransom Roberson
 * @date 11.06.13
 *
 */
public class Config {
	private String configLocation = "config.properties";
	private PropertiesConfiguration config;

	/**
	 * Creates a new instance of the Config object
	 */
	public Config() {
		try {
			config = new PropertiesConfiguration("config.properties");
		} catch (ConfigurationException e) {
			System.out.println("Failed to load config.properties file.");
		}
		
	}
}
