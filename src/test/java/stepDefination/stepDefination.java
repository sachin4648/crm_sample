package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CRMCucumber.CRMCucumber.Base;
import CRMCucumber.CRMCucumber.GetProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

@RunWith(Cucumber.class)
public class stepDefination {
	WebDriver driver;
	WebDriverWait wait;
	GetProperties classObj;
	LoginPage loginPage;
	@SuppressWarnings("deprecation")
	@Given("^User logged into CRM application$")
	public void user_logged_into_crm_application() throws InterruptedException {
		driver = Base.getDriver();
		classObj = GetProperties.getProperty();
		driver.get(classObj.getPropValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginPage = new LoginPage(driver);
		loginPage.crm_login();
		
		/*
		 * driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
		 * "sachin.4648@gmail.com");
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * "Nandini@123");
		 * driver.findElement(By.xpath("//div[text() = 'Login']")).click();
		 */
	}

	@Given("^User navigated to Contact$")
	public void user_navigated_to_contact()  {
		new HomePage(driver).navigateToContact();
		
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(driver.findElement(By.xpath("//a[@href='/contacts']")))
		 * .build().perform();
		 * driver.findElement(By.xpath("//a[@href='/contacts']/span")).click();
		 */
	}

	@SuppressWarnings("deprecation")
	@When("^User clicks on Create button$")
	public void user_clicks_on_create_button() throws InterruptedException {
		new ContactPage(driver).clickNewContact();
		/*
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//button[text()='Create']")).click();
		 */
		}

	@When("^User enters required details (.+),(.+)$")
	public void user_enters_required_details_(String name, String lname) {
		new ContactPage(driver).createContact(name, lname);
		/*
		 * driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);
		 * driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lname);
		 * driver.findElement(By.xpath("//button[text()='Save']")).click();
		 */
	}

	@Then("^Contact (.+) will be created$")
	public void contact_will_be_created(String name)  {
		verificationCode();
	}

	@Given("^User navigated to Company$")
	public void user_navigated_to_company() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@href='/companies']"))).build().perform();
		driver.findElement(By.xpath("//a[@href='/companies']/span")).click();
	}

	@When("^User enters company (.+) name$")
	public void user_enters_required_details(String cname) {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cname);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

	@Then("^Company record will be created$")
	public void company_record_will_be_created() throws Throwable {
		verificationCode();
	}

	public void verificationCode() {
		List<WebElement> element = driver.findElements(By.xpath("//p[text()='No records found']"));
		Assert.assertTrue(element.size() == 0);
	}

	@After
	public void tearDown() {
		driver.close();

		if(driver!=null) {
			driver.quit();
		}
	}
}
