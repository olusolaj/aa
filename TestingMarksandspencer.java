package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingMarksandspencer {
	static WebDriver driver;
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\matson\\Desktop\\Eclipse_photon\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "https://www.marksandspencer.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
	}

	@When("^Search and select first Item$")
	public void search_and_select_first_Item() throws Throwable {
		driver.findElement(By.xpath("//input[@class='search-bar--search']")).sendKeys("Jacket");
		driver.findElement(By.xpath("//section[@id='progressiveHeaderSection']//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='8648162']//div[@class='detail']")).click();
		
		
	}

	@Then("^Add first item to the baskest$")
	public void add_first_item_to_the_baskest() throws Throwable {
		driver.findElement(By.xpath("//label[@for='18']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("add-to-basket-button")));
		driver.findElement(By.id("add-to-basket-button")).click();
	}

	@When("^Search and select second Item$")
	public void search_and_select_second_Item() throws Throwable {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='search-bar--search']")).sendKeys("Perfume");
		driver.findElement(By.xpath("//section[@id='progressiveHeaderSection']//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='3987514']//div[@class='detail']")).click();
	}

	@Then("^Add second item to the baskest$")
	public void add_second_item_to_the_baskest() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("add-to-basket-button")));
		driver.findElement(By.id("add-to-basket-button")).click();
	}

	@When("^Search and select third Item$")
	public void search_and_select_third_Item() throws Throwable {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='search-bar--search']")).sendKeys("Trainers");
		driver.findElement(By.xpath("//section[@id='progressiveHeaderSection']//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='8087512']//div[@class='detail']")).click();
	}

	@Then("^Add third item to the baskest$")
	public void add_third_item_to_the_baskest() throws Throwable {
		driver.findElement(By.xpath("//label[@for='5 Large']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("add-to-basket-button")));
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-basket-button")).click();
	}

	@Then("^Navigate to checkout the items$")
	public void navigate_to_checkout_the_items() throws Throwable {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='YOUR BAG']")).click();
	}

	@Then("^Verify the total price with the expected price$")
	public void verify_the_total_price_with_the_expected_price() throws Throwable {
		Thread.sleep(2000);
		WebElement thePrice= driver.findElement(By.xpath("//*[@class='pricing-summary__top-value ng-binding']"));
		String totalPrice = thePrice.getText();
		Assert.assertEquals(totalPrice, "£40.50");
	}

	@Then("^Display a successful message$")
	public void display_a_successful_message() throws Throwable {
		System.out.println("SUCCESSFUL FUNCTIONALITY TEST");
	}

}