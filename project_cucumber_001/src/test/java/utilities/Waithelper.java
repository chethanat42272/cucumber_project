package utilities;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waithelper 
{
	public  WebDriver driver;
	public Waithelper(WebDriver driver)
	{
		this.driver=driver;
	}

	public void WaitForElement(WebElement ele,long timeOutInSeconds)
	{
		Wait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
}
