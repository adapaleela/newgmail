package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	
	@FindBy(xpath="//*[contains(text(),'Send SMS')]")
	public WebElement sndmsg;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}
