package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	WebDriver driver;
	Actions actions;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By contactLogo = By.xpath("//a[@href='/contacts']");
	By contactLink = By.xpath("//a[@href='/contacts']/span");
	
	By companiesLogo = By.xpath("//a[@href='/companies']");
	By companiesLink = By.xpath("//a[@href='/companies']/span");
	
	
	public ContactPage navigateToContact() {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(contactLogo)).build().perform();
		driver.findElement(contactLink).click();
		return new ContactPage(driver);
	}
	
	public CompanyPage navigateToCompanies() {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(companiesLogo)).build().perform();
		driver.findElement(companiesLink).click();
		return new CompanyPage(driver);
	}

}
