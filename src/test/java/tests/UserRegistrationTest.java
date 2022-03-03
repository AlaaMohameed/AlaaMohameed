package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	LoginPage loginObject;
	UserRegistrationPage registrationObject;


	@DataProvider(name = "ExcelData")
	public Object[][] userRegistrationData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}



	@Test(priority = 1,enabled = true)
	public void userCanntRegisterWithEmptyFields() throws InterruptedException
	{
		loginObject = new LoginPage(driver);
		loginObject.navigateToSignUpPage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registrationObject= new UserRegistrationPage(driver);
		registrationObject.clickSignUp();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.surNameTxt.getCssValue("border-bottom-color"));
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.emailTxt.getCssValue("border-bottom-color"));
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.passwordTxt.getCssValue("border-bottom-color"));
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.dayDDL.getCssValue("border-bottom-color"));
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.monthDDL.getCssValue("border-bottom-color"));
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.yearDDL.getCssValue("border-bottom-color"));
	}


	@Test(priority = 2, enabled = true)
	public void userCanntregisterWithConfirmEmailDonotMatchEmail() throws InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registrationObject= new UserRegistrationPage(driver);
		registrationObject.UserSignUp("alaa", "Mohamed", "alaa.mohamed@dknd.com","alaa.mohadsdsmed@dknd.com","aa", "1" , "Feb", "2000");
		assertEquals("rgba(255, 0, 0, 1)", registrationObject.confirmEmailTxt.getCssValue("border-bottom-color"));

	}


	@Test(priority = 3, enabled = true)
	public void userCanntregisterWithInvalidPassword() throws InterruptedException
	{
		//loginObject = new LoginPage(driver);
		//loginObject.navigateToSignUpPage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registrationObject= new UserRegistrationPage(driver);
		registrationObject.UserSignUp("alaa", "Mohamed", "alaa.mohamed@gmail.com","alaa.mohamed@gmail.com","1","1" , "Feb", "2000");
		registrationObject.clickSignUp();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Thread.sleep(12000);
		Assert.assertTrue(registrationObject.passwordValidation.getText().contains("Your password must be at least 6 characters long. Please try another"));

	}



	@Test(priority = 4, enabled = true, dataProvider = "ExcelData")
	public void userCanRegistersuccessfully(String firstName, String surname, String email, String confirmemail, String password) throws InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registrationObject= new UserRegistrationPage(driver);
		registrationObject.UserSignUp(firstName, surname, email, confirmemail, password, "1", "Feb", "2000");
		registrationObject.clickSignUp();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//registrationObject.loginToGmail(driver,"uu1385095@gmail.com", "Unknown*");

	}




}
