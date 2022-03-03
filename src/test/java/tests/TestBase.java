package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase 
{
	public static WebDriver driver ;

	@BeforeSuite	
	public void startDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjQzOTM1NzEzLCJjYWxsc2l0ZV9pZCI6MTA0NzY5OTU1NTY3NjEwMX0%3D&next=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fdevelopment%2Fbuild-and-test%2Ftest-users");

	}

	@AfterSuite
	public void stopDriver() 
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.quit();
	}

	//Take screenshot when test case fail and add it to screenshot folder 

	@AfterMethod
	public void screenshotOnFailer(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Failer");
			System.out.println("Taking screenshot...");
			Helper.captureScreenshot(driver, result.getName());

		}
	}

}
