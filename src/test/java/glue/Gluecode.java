package glue;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.Loginpage;

public class Gluecode 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Loginpage lp;
	public Homepage hp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method(Scenario s) throws Exception
	{
		this.s=s;
		FileInputStream f=new FileInputStream("E:\\testing\\way2sms\\src\\test\\resources\\properties\\properties.properties");
		p=new Properties();
		p.load(f);
	}
	
	@Given("^launch site$")
	public void launch_site()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,20);
		lp=new Loginpage(driver);
		hp=new Homepage(driver);
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		driver.manage().window().maximize();
	}
	
	@When("^enter mobile no$")
	public void enter_mobile_no()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		lp.fillmbno();
	}
	
	@When("^enter mobile no as \"(.*)\"$")
	public void enter_mobile(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		lp.fillmbno(x);
	}
	
	/*@When("^enter mobile no as \"(.*)\" with criteria as \"(.*)\"$")
	public void enter_mobile_no_with_criteria(String x,String y)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		lp.fillmbno(x);
	}
	
	@And("^enter password as \"(.*)\" with criteria as \"(.*)\"$")
	public void enter_password_with_criteria(String x,String y)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(x);
	}*/
	
	@When("^enter mobile number$")
	public void enter_mobile_number(DataTable dt)
	{
		List<List<String>>data=dt.asLists(String.class);
		for(int i=1;i<data.size();i++)
		{
			wait.until(ExpectedConditions.visibilityOf(lp.mbno));
			
			String mobilenumber=data.get(i).get(0);
			lp.fillmbno(mobilenumber);
		}
	}
	
	@And("^enter password as$")
	public void enter_password_as(DataTable dt)
	{
		List<List<String>>data=dt.asLists(String.class);
		for(int i=1;i<data.size();i++)
		{
			wait.until(ExpectedConditions.visibilityOf(lp.pwd));
			String password=data.get(i).get(0);
			lp.fillpwd(password);
		}
	}
	
	@And("^enter password as \"(.*)\"$")
	public void enter_password(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(x);
	}
	
	@And("^enter password$")
	public void enter_password()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd();
	}
	
	@And("^click on login button$")
	public void click_on_login_button()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lp.nxtbtn));
		lp.clickNext();
	}
	
	@Then("^validate login functionality with \"(.*)\" and \"(.*)\"$")
	public void validate_login_functionality(String x,String y) throws Exception
	{
		Thread.sleep(5000);
		if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("valid") && hp.sndmsg.isDisplayed())
		{
			Thread.sleep(5000);
			s.write("all valid login test passed");
		}
		else if(x.equalsIgnoreCase("blank") && y.equalsIgnoreCase("valid") && lp.blankmbnomesg.isDisplayed())
		{
			s.write("blank mobile test passed");
		}
		else if(x.equalsIgnoreCase("invalid") && y.equalsIgnoreCase("valid") && lp.invalidmbnomessg.isDisplayed())
		{
			s.write("invalid mobile number test passed");
		}
		else if(x.equalsIgnoreCase("wrongsize") && y.equalsIgnoreCase("valid") && lp.wrongsizembnomessg.isDisplayed())
		{
			s.write("wrong size mobile number test passed");
		}
		else if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("blank") && lp.blankpwdmessg.isDisplayed())
		{
			s.write("blank password test passed");
		}
		else if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("invalid") && lp.invalidpwdmessg.isDisplayed())
		{
			s.write("invalid password test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,"login test failed");
		}
	}
	
	@Then("^validate login functionality with mobilenocriteria and passwordcriteria$")
	public void with_criterias(DataTable dt)
	{
		List<List<String>>data=dt.asLists(String.class);
		for(int i=1;i<data.size();i++)
		{
			String x=data.get(i).get(0);
			String y=data.get(i).get(1);
			
			if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("valid") && hp.sndmsg.isDisplayed())
			{
				s.write("all valid login test passed");
			}
			else if(x.equalsIgnoreCase("blank") && y.equalsIgnoreCase("valid") && lp.blankmbnomesg.isDisplayed())
			{
				s.write("blank mobile test passed");
			}
			else if(x.equalsIgnoreCase("invalid") && y.equalsIgnoreCase("valid") && lp.invalidmbnomessg.isDisplayed())
			{
				s.write("invalid mobile number test passed");
			}
			else if(x.equalsIgnoreCase("wrongsize") && y.equalsIgnoreCase("valid") && lp.wrongsizembnomessg.isDisplayed())
			{
				s.write("wrong size mobile number test passed");
			}
			else if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("blank") && lp.blankpwdmessg.isDisplayed())
			{
				s.write("blank password test passed");
			}
			else if(x.equalsIgnoreCase("valid") && y.equalsIgnoreCase("invalid") && lp.invalidpwdmessg.isDisplayed())
			{
				s.write("invalid password test passed");
			}
			else
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b,"login test failed");
			}
		}
	}
	
	@And("^close site$")
	public void close_site() throws Exception
	{
		Thread.sleep(5000);
		driver.close();
	}

}
