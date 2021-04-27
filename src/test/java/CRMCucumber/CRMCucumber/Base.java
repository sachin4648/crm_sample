package CRMCucumber.CRMCucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	GetProperties classObj=GetProperties.getProperty();
	String bName = classObj.getPropValue("browserName");
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	public String getBrowserName() {
		return classObj.getPropValue("browserName");
	}
}
