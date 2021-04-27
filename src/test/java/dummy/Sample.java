package dummy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import CRMCucumber.CRMCucumber.Base;
import CRMCucumber.CRMCucumber.GetProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= Base.getDriver();
		GetProperties classObj = GetProperties.getProperty();
		System.out.println(classObj.getPropValue("url"));
	}
}
