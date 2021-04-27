package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	By create = By.xpath("//button[text()='Create']");
	By firstName = By.xpath("//input[@name='first_name']");
	By lastName = By.xpath("//input[@name='last_name']");
	By save = By.xpath("//button[text()='Save']");
	
	public void createContact(String name, String lname) {
		
		driver.findElement(firstName).sendKeys(name);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(save).click();
	}
	
	public ContactPage clickNewContact() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.findElement(create).click();
		
		return new ContactPage(driver);
	}
}
