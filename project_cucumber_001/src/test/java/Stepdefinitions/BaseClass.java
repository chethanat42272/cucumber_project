package Stepdefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageobjects.Addcustomerpage;
import pageobjects.Loginpage;
import pageobjects.SearchCustomerpage;

public class BaseClass 
{

	public static WebDriver driver;
	public Loginpage lp;
	public Addcustomerpage addcust;
	public SearchCustomerpage srchcust;
    public static Logger logger;
    public Properties logprop;
	//this method is for generating unique character of String
	public static String randomestring()
	{
          String randomeString=RandomStringUtils.randomAlphabetic(5);
          return randomeString;
	}
	//this method is for finding the emailId 
	public static boolean findEmail()
	{
		return true;
	}
}
