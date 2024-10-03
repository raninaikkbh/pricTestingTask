package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeBackPage extends BasePage
{

	
	
	public WelcomeBackPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = ".//input[@name='tel']")
	WebElement txtTelephone;
	

	
	@FindBy(xpath = ".//button[text()='Send OTP']")
	WebElement btnSendOTP;;

	
	@FindBy(xpath = ".//a[text()='SignUp']")
	WebElement btnSignUp;
	
	
	@FindBy(xpath = ".//a[text()='Terms of Service']")
	WebElement termsOfService;
	
	@FindBy(xpath = ".//a[text()='Privacy Policy']")
	WebElement privacyPolicy;
	
	public void setTelephoneNumber(String telephoneNumber)
	{
		txtTelephone.sendKeys(telephoneNumber);
	}
	
	
	
	public void clickSendOTPButton()
	{
		// Click on SendOtp Button
		btnSendOTP.click();
		
		
		// if not Working Click Method
		
		// 1 Try With SendKeys
		//btnSendOTP.sendKeys(Keys.ENTER);
		
		// 2 Try with Actions Class
		//Actions act=new Actions(driver);
		//act.moveToElement(btnSendOTP).click().perform();
		
		// 3 Try with Java-script Executer
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", btnSendOTP);
		
		//4 Try with WebDriverWait
		//WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(60));
		//myWait.until(ExpectedConditions.elementToBeClickable(btnSendOTP)).click();
		
		// 5 Try with Submit method
		//btnSendOTP.submit();
		
	}
	
	public void clickSignUpButton()
	{
		btnSignUp.click();
	}
	
	public void clickTermsOfService()
	{
		termsOfService.click();
	}
	
	public void clickPrivacyPolicy() 
	{
		privacyPolicy.click();
	}
	
	
}
