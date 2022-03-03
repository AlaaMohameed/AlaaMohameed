package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}

	@FindBy(id = "email")
	WebElement emailTxt;

	@FindBy(id = "pass")
	WebElement passwordTxt;

	@FindBy(id = "loginbutton")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"login_link\"]/div[3]/a")
	WebElement signUpBtn;

	@FindBy(xpath = "//*[@id=\"email_container\"]/div[2]")
	public WebElement emailValidation;

	@FindBy(xpath = "//*[@id=\"loginform\"]/div[2]/div[2]")
	public WebElement passwordValidation;

	@FindBy(xpath = "//*[@id=\"page-login\"]/div[2]/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/span[2]")
	public WebElement emailPasswordValidation;


	public void login(String email, String password) throws InterruptedException
	{
		emailTxt.sendKeys(Keys.CONTROL + "a");
		emailTxt.sendKeys(Keys.DELETE);
		sendText(emailTxt, email);
		passwordTxt.sendKeys(Keys.CONTROL + "a");
		passwordTxt.sendKeys(Keys.DELETE);
		sendText(passwordTxt, password);
		Thread.sleep(1000);
		clickButton(loginBtn);
		Thread.sleep(10000);

	}

	public void navigateToSignUpPage()
	{
		clickButton(signUpBtn);
	}

}
