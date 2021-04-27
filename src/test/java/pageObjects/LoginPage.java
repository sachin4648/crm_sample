package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='password']");
	By login = By.xpath("//div[text() = 'Login']");
	
	public HomePage crm_login() {
		driver.findElement(email).sendKeys("sachin.4648@gmail.com");
		driver.findElement(password).sendKeys("Nandini@123");
		driver.findElement(login).click();
		return new HomePage(driver);
	}
}
