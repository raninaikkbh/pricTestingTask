package testCases;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LockedMessage;
import pageObject.OTPVerificationPage;
import pageObject.WelcomeBackPage;

public class TC001_CreateNewLockedMessage 

{

	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://app.thepric.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void create_new_locked_message() throws InterruptedException
	{
		WelcomeBackPage wp= new WelcomeBackPage(driver);
		wp.setTelephoneNumber("7057081674");
		wp.clickSendOTPButton();
		
		
		System.out.println("Enter OTP ");
		System.out.println("Enter First Number :- ");
		Scanner sc= new Scanner(System.in);
		String firstNumber=sc.next();
		
		System.out.println("Enter Second Number :- ");
		String secondNumber=sc.next();
		System.out.println("Enter Third Number :- ");
		String thirdNumber=sc.next();
		System.out.println("Enter Fourth Number :- ");
		String fourthNumber=sc.next();
		
		OTPVerificationPage opv=new OTPVerificationPage(driver);
		opv.setFirstPostionOTP(firstNumber);
		opv.setSecondPositionOTP(secondNumber);
		opv.setThirdPositionOTP(thirdNumber);
		opv.setFourthPositionOTP(fourthNumber);
		
		opv.clickVerifyOTP();
		
		Thread.sleep(3000);
		
		HomePage hp=new HomePage(driver);
		hp.clickLockedMessage();
		Thread.sleep(3000);
		
		LockedMessage lm=new LockedMessage(driver);
		lm.clickNewLockedMessage();
		Thread.sleep(3000);
		lm.setAmount("100");
		lm.setVisibleText("Testing Message");
		lm.setPremiumCOntent("Testing Message");
		lm.clickSubmit();
		Thread.sleep(3000);
		String messageRetrieved=hp.confirmMessageSaved();
		
		Assert.assertEquals(messageRetrieved, "Testing Message");
	}
	
	@Test (priority = 2)
	public void verify_locked_message_edit() throws InterruptedException
	{
		LockedMessage lm=new LockedMessage(driver);
		lm.clickEditOption();
		Thread.sleep(2000);
		
		lm.setAmount("2");
		lm.setVisibleText("Testing Message Second Script");
		lm.setPremiumCOntent("Testing Message Second Script");
		lm.clickSubmit();
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		
		String messageRetrieved=hp.confirmMessageSaved();
		
		
		
	}
	
	@Test(priority = 3)
	public void list_created_view() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		String mess=hp.confirmMessageSaved();
		
		
	}
	
	@Test(priority = 4)
	public void validation_locked_message() throws InterruptedException 
	{
		LockedMessage lm=new LockedMessage(driver);
		lm.clickNewLockedMessage();
		Thread.sleep(2000);
		
		lm.setAmount("");
		lm.setVisibleText("");
		lm.setPremiumCOntent("");
		lm.clickSubmit();
		
		String errMessage=lm.confirmErrorMessageForAmount();
		
		Assert.assertEquals(errMessage, "Please enter the amount");
		
		lm.clickCloseMessageBox();
		
		
	}
	
	
	@Test(priority = 5)
	public void delet_locked_message() 
	{
		LockedMessage lm=new LockedMessage(driver);
		lm.clickDeletOption();
		
		lm.clickConfirmDelet();
		driver.navigate().refresh();
		
		
		
		
	}
	
	
}
