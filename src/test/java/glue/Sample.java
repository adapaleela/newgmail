package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Loginpage;

public class Sample 

{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.way2sms.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		Loginpage lp=new Loginpage(driver);
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		driver.manage().window().maximize();
		lp.fillmbno();
		wait.until(ExpectedConditions.visibilityOf(lp.mbno));
		lp.fillmbno();
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd();
		wait.until(ExpectedConditions.elementToBeClickable(lp.nxtbtn));
		lp.clickNext();
		driver.close();

	}

}
