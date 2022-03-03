package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage extends PageBase 
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "firstname")
	public WebElement firstNameTxt ;

	@FindBy(name = "lastname")
	public WebElement surNameTxt ;

	@FindBy(name = "reg_email__")
	public WebElement emailTxt ;

	@FindBy(name = "reg_email_confirmation__")
	public WebElement confirmEmailTxt;

	@FindBy(id = "password_step_input")
	public WebElement passwordTxt ;

	@FindBy(id = "reg_error_inner")
	public WebElement passwordValidation;

	@FindBy(id = "day")
	public WebElement dayDDL ;

	@FindBy(id = "month")
	public WebElement monthDDL ;

	@FindBy(id = "year")
	public WebElement yearDDL ;

	@FindBy(name = "sex")
	public WebElement femaleRadioBtn ;

	@FindBy(id = "u_0_5_jA")
	WebElement maleRadioBtn ;

	@FindBy(id = "u_0_6_iK")
	WebElement customRadioBtn ;

	@FindBy(id = "u_0_x_uA")
	WebElement pronounDDL ;

	@FindBy(id = "u_0_y_vM")
	WebElement genderTxt ;

	@FindBy(name = "websubmit")
	WebElement signUpBtn ;

	@FindBy(id = "code_in_cliff")
	WebElement confirmationTxt;

	@FindBy(id = "u_0_3_F6")
	WebElement confirmationBtn;

	@FindBy(xpath = "//*[@id=\"facebook\"]/body/div[4]/div[2]/div/div/div/div[2]")
	public WebElement successMsg;

	@FindBy(xpath = "/*[@id=\"facebook\"]/body/div[4]/div[2]/div/div/div/div[3]/button")
	public WebElement okBtn;


	@FindBy(id = "identifierId")
	WebElement emailGmailAccount;

	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
	WebElement nextBtnFirstStep;

	@FindBy(name = "password")
	WebElement passGmailAccount;

	@FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button")
	WebElement nextBtnSecondStep;

	@FindBy(xpath = "//*[@id=\"gs_lc50\"]/input[1]")
	WebElement searchEmail;

	@FindBy(xpath = "//*[@id=\":97\"]")
	WebElement firstEmail;

	@FindBy(xpath = "//*[@id=\"m_-2851054526700877636email_content\"]/table/tbody/tr[4]/td[2]/table/tbody/tr[2]/td/span/span/table[1]/tbody/tr/td")
	WebElement Code;


	public void UserSignUp (String firstName, String surname, String email,String confirmemail , String password, String day, String month, String year)
	{

		firstNameTxt.sendKeys(Keys.CONTROL + "a");
		firstNameTxt.sendKeys(Keys.DELETE);
		sendText(firstNameTxt,firstName);
		surNameTxt.sendKeys(Keys.CONTROL + "a");
		surNameTxt.sendKeys(Keys.DELETE);
		sendText(surNameTxt, surname);
		emailTxt.sendKeys(Keys.CONTROL + "a");
		emailTxt.sendKeys(Keys.DELETE);
		sendText(emailTxt, email);
		confirmEmailTxt.sendKeys(Keys.CONTROL + "a");
		confirmEmailTxt.sendKeys(Keys.DELETE);
		sendText(confirmEmailTxt, confirmemail);
		passwordTxt.sendKeys(Keys.CONTROL + "a");
		passwordTxt.sendKeys(Keys.DELETE);
		sendText(passwordTxt, password);
		Select selectDay = new Select(dayDDL);
		selectDay.selectByVisibleText(day);
		Select selectMonth = new Select(monthDDL);
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(yearDDL);
		selectYear.selectByVisibleText(year);
		clickButton(femaleRadioBtn);		
	}	

	public void clickSignUp ()
	{
		clickButton(signUpBtn);	
	}

	public int loginToGmail(WebDriver driver, String emailValue, String passwordvalue) throws InterruptedException {

		driver.switchTo().newWindow(WindowType.TAB); 
		driver.navigate().to("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		sendText(emailGmailAccount, emailValue);
		clickButton(nextBtnFirstStep);
		Thread.sleep(5000);		
		sendText(passGmailAccount, passwordvalue);
		clickButton(nextBtnSecondStep);
		Thread.sleep(10000);
		return searchEmailAndClickVerifyLink();

	}

	public int searchEmailAndClickVerifyLink() throws InterruptedException {

		sendText(searchEmail, "Facebook ");
		searchEmail.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		clickButton(firstEmail);
		Thread.sleep(3000);
		String code = Code.getText();
		int number = Integer.parseInt(code);
		Thread.sleep(3000);
		return number;
	}


}
