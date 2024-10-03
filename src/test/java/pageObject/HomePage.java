package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	
	@FindBy(xpath = ".//span[text()='Locked Message']")
	WebElement lockedMessage;
	
	@FindBy(xpath = "(.//tbody[@role='rowgroup']//tr//td)[5]")
	WebElement messageRow;
	
	
	
	public void clickLockedMessage()
	{
		//lockedMessage.click();
		
		
		// 2 Try with Actions Class
		Actions act=new Actions(driver);
		act.moveToElement(lockedMessage).click().perform();
	}
	
	
	public String confirmMessageSaved()
	{
		try 
		{
			return (messageRow.getText());
		}catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
}
