package CRMCucumber.CRMCucumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class GetProperties {

	private static GetProperties getProperties;
	private Properties properties;

	private GetProperties() {

	}

	public static GetProperties getProperty() {

		if(getProperties ==null) { 
			getProperties =  new GetProperties();
		}
		return getProperties;
	}

	public String getPropValue(String key) {
		properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\system.properties");
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
