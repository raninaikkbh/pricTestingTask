package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LockedMessage extends BasePage
{

	public LockedMessage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = ".//button[text()=' Create Your First Lock Message']")
	WebElement btnCreateNewLockedMessage;
	
	@FindBy(xpath = "(.//div[@class='col-md-auto']/button)[2]")
	WebElement btnNewLockedMessage;
	
	
	@FindBy(xpath = ".//div[text()='Please enter the amount']")
	WebElement errorMessForAmount;

	@FindBy(xpath = "(.//div[@class='col-md-auto']//i)[2]")
	WebElement btnEdit;
	
	@FindBy(xpath = "(.//div[@class='col-md-auto']//i)[3]")
	WebElement btnDelet;
	
	@FindBy(xpath = ".//input[@name='price']")
	WebElement txtAmount;
	
	@FindBy(xpath = ".//textarea[@name='visibleMessage']")
	WebElement txtVisibleMessage;
	
	@FindBy(xpath = ".//textarea[@name='premiumContent']")
	WebElement txtPremiumContent;
	
	@FindBy(xpath = ".//button[text()='Submit']")
	WebElement btnSubmit;
	
	
	@FindBy(xpath = ".//button[@class='btn-close btn btn-link']")
	WebElement btnCloseNewMessage;
	
	@FindBy(xpath = ".//button[text()='Delete']")
	WebElement btnConfirmDelet;
	
	public void clickConfirmDelet()
	{
		btnConfirmDelet.click();
	}
	
	
	public void clickCloseMessageBox()
	{
		btnCloseNewMessage.click();
	}
	
	
	
	public void clickDeletOption() 
	{
		btnDelet.click();
	}
	
	public void clickEditOption()
	{
		btnEdit.click();
	}
	
	public void clickCreateNewLockedMesssage()
	{
		btnCreateNewLockedMessage.click();
	}
	
	public void clickNewLockedMessage()
	{
		btnNewLockedMessage.click();
	}
	
	
	public void setAmount(String amount)
	{
		txtAmount.sendKeys(amount);
	}
	
	public void setVisibleText(String visibleTesxt)
	{
		txtVisibleMessage.sendKeys(visibleTesxt);
	}
	
	public void setPremiumCOntent(String premiumContent)
	{
		txtPremiumContent.sendKeys(premiumContent);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public String confirmErrorMessageForAmount()
	{
		try 
		{
			return (errorMessForAmount.getText());
		}catch (Exception e) 
		{
			return (e.getMessage());
		}
		
	}
	
	
}
