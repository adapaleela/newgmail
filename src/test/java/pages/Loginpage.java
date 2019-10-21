package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	
	@FindBy(xpath="(//*[@id='mobileNo'])[1]")
	public WebElement mbno;
	
	@FindBy(xpath="(//*[@name='password'])[1]")
	public WebElement pwd;
	
	@FindBy(xpath="(//button[contains(text(),'Login')])[1] ")
	public WebElement nxtbtn;
	
	@FindBy(xpath="//*[text()='Enter your mobile number']")
	public WebElement blankmbnomesg;
	
	@FindBy(xpath="//*[text()='Incorrect number or password! Try Again.']")
	public WebElement invalidpwdmessg;
	
	@FindBy(xpath="//*[text()='Enter valid mobile number']")
	public WebElement wrongsizembnomessg;
	
	@FindBy(xpath="//*[text()='Your mobile number is not register with us.']")
	public WebElement invalidmbnomessg;
	
	@FindBy(xpath="(//*[text()='Enter password'])[2]")
	public WebElement blankpwdmessg;
	
	
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void fillmbno()
	{
		mbno.sendKeys("7674864149");
	}
	
	public void fillmbno(String x)
	{
		mbno.sendKeys(x);
	}
	
	public void fillpwd()
	{
		pwd.sendKeys("leela1993");
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickNext()
	{
		nxtbtn.click();
	}

}
