package tests;

import java.util.concurrent.TimeUnit;

//import java.io.IOException;

//import org.json.simple.parser.ParseException;
import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import data.ExcelReader;
//import data.JsonDataReader;
import pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage loginObject;

	@Test(priority = 1)
	public void userCannotloginWithEmptyFields() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.login("", "");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(loginObject.emailValidation.getText().contains("The email address or mobile number you entered isn't connected to an account"));
	}

	@Test(priority = 2)
	public void userCannotloginWithInvalidEmail() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.login("alaa@m.com", "Alaa@123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(loginObject.emailValidation.getText().contains("The email address you entered isn't connected to an account"));
	}

	@Test(priority = 3)
	public void userCannotloginWithInvalidPassword() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.login("uu1385095@gmail.com", "5623");
		Assert.assertTrue(loginObject.passwordValidation.getText().contains("The password that you've entered is incorrect"));
	}

	//@Test(priority = 4)
	/*
	 * public void userCannotloginWithNotVerifiedEmail() throws InterruptedException
	 * { loginObject = new LoginPage(driver);
	 * loginObject.login("uu1385095+2@gmail.com.com", "Alaa@123");
	 * Assert.assertTrue(loginObject.emailPasswordValidation.getText().contains(""))
	 * ; }
	 */

	@Test(priority = 4)
	public void userCanLoginSuccessfully() throws InterruptedException
	{
		loginObject = new LoginPage(driver);
		loginObject.login("uu1385095@gmail.com", "Alaa@123");
	}


}

