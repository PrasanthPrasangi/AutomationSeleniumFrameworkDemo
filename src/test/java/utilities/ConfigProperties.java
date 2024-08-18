package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	public static Properties property;
	
	private static String configPath = "Configuration/config.properties";
	
	
	public static void initializePropertiesFile() {
		
		property = new Properties();
		try {
			InputStream read = new FileInputStream(configPath);
			property.load(read);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
