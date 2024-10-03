package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OTPVerificationPage  extends BasePage
{

	public OTPVerificationPage(WebDriver driver) 
	{
		super(driver);
	}
	

	@FindBy(xpath = "(.//input[@class='pincode-input-text'])[1]")
	WebElement firstPositionInputBox;
	
	@FindBy(xpath = "(.//input[@class='pincode-input-text'])[2]")
	WebElement secondPositionInputBox;
	
	@FindBy(xpath = "(.//input[@class='pincode-input-text'])[3]")
	WebElement thirdPositionInputBox;
	
	@FindBy(xpath = "(.//input[@class='pincode-input-text'])[4]")
	WebElement fourthPositionInputBox;
	
	
	@FindBy(xpath = ".//button[text()='Verify OTP']")
	WebElement btnVerifyOTP;
	
	@FindBy(xpath = ".//button[text()='Resend']")
	WebElement btnResend;
	
	
	
	public void setFirstPostionOTP(String firstNumber)
	{
		firstPositionInputBox.sendKeys(firstNumber);
	}
	
	public void setSecondPositionOTP(String secondNumber)
	{
		secondPositionInputBox.sendKeys(secondNumber);
	}
	
	public void setThirdPositionOTP(String thirdNumber)
	{
		thirdPositionInputBox.sendKeys(thirdNumber);
	}
	
	public void setFourthPositionOTP(String fourthNumber)
	{
		fourthPositionInputBox.sendKeys(fourthNumber);
	}
	
	public void clickVerifyOTP()
	{
		btnVerifyOTP.click();
	}
	
	
	public void clickResend()
	{
		btnResend.click();
		
	}
	
}
