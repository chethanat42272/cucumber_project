package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
public WebDriver driver;


public Loginpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@id='Email']") 
@CacheLookup
WebElement emailtext;

@FindBy(xpath="//input[@id='Password']") 
@CacheLookup
WebElement pwdtext;

@FindBy(xpath="//button[text()='Log in']") 
@CacheLookup
WebElement clicklogin;
//a[text()='Logout']

@FindBy(xpath="//a[text()='Logout']") 
@CacheLookup
WebElement clicklogout;


public void setEmail(String email)
{
	emailtext.clear();
	emailtext.sendKeys(email);
}
public void setPassword(String pwd)
{
	pwdtext.clear();
	pwdtext.sendKeys(pwd);
}
public void setLogin()
{
	clicklogin.click();
}
public void setLogout()
{
	clicklogout.click();
}

}
