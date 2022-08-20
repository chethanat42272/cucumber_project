package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addcustomerpage 
{
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement emaultxt;

	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement pwdtxt;

	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	WebElement logintxt;
	
	@FindBy(xpath="//a[text()='Logout']") 
	@CacheLookup
	WebElement clicklogout;

	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")
	@CacheLookup
	WebElement clickcust;

	@FindBy(xpath="//p[text()=' Customers']")
	@CacheLookup
	public static WebElement clickcust1;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	@CacheLookup
	public static WebElement addnewbttn;

	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement emailtext;

	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement Pwdtext;

	@FindBy(xpath="//input[@id='FirstName']")
	@CacheLookup
	WebElement fnametxt;

	@FindBy(xpath="//input[@id='LastName']")
	@CacheLookup
	WebElement lnametxt;

	@FindBy(xpath="//input[@id='Gender_Male']")
	@CacheLookup
	WebElement male;

	@FindBy(xpath="//input[@id='Gender_Female']")
	@CacheLookup
	WebElement female;

	@FindBy(xpath="//input[@id='DateOfBirth']")
	@CacheLookup
	WebElement dob;

	@FindBy(xpath="//input[@id='Company']")
	@CacheLookup
	WebElement company;

	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
	@CacheLookup
	WebElement newsletter;
	
	@FindBy(xpath="//li[text()='Your store name']")
	@CacheLookup
	WebElement ele1;
	
	@FindBy(xpath="	//li[text()='Test store 2']")
	@CacheLookup
	WebElement ele2;
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	@CacheLookup
	WebElement roles;

	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement Adminrole;
	
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement Formrole;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement Guestrole;
	
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement Vendorrole;
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement Regrole;
		
	@FindBy(xpath="//*[@id=\"VendorId\"]")
	@CacheLookup
	WebElement vendors;

	@FindBy(xpath="//textarea[@id=\"AdminComment\"]")
	@CacheLookup
	WebElement comment;

	@FindBy(xpath="//button[@name='save']")
	@CacheLookup
	WebElement save;
	
	@FindBy(tagName="body")
	@CacheLookup
	public static WebElement successmessage;

	
	public static WebDriver driver;

	public Addcustomerpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	public static String gettitle()
	{
		String title=driver.getTitle();
		return title;
		
	}
	public void setCusomermenuclick()
	{
		clickcust.click();
	}
	public void setClickCustomer()
	{
		clickcust1.click();
	}
	public void setAddnewCustomer()
	{
		addnewbttn.click();
	}
	public void setEmail(String email)
	{
		emailtext.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		Pwdtext.sendKeys(pwd);
	}
	public void setFirstName(String Fname)
	{
		fnametxt.sendKeys(Fname);
	}
	public void setLastName(String Lname)
	{		
		lnametxt.sendKeys(Lname);
	}
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			male.click();
		}
		else if(gender.equalsIgnoreCase("female"))
		{
			female.click();
		}
	}
	public void setDate_Of_Birth(String Dob)
	{
		dob.sendKeys(Dob);
	}
	public void setCompany_Name(String Companyname)
	{
		company.sendKeys(Companyname);
	}
	public void setNewsletter(String news)
	{
		newsletter.click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		if(news.equals("Your store name"))
		{
		jse.executeScript("arguments[0].click();", ele1);
		}
		else if(news.equals("Test store 2"))
		{
			jse.executeScript("arguments[0].click();", ele2);
		}
	}
	public void setRoles(String role)
	{
		roles.	click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		if(role.equals("Administrators"))
		{
			jse.executeScript("arguments[0].click();",Adminrole);
		}
		else if(role.equals("Forum Moderators"))
		{
			jse.executeScript("arguments[0].click();",Formrole);
		}
		else if(role.equals("Guests"))
		{
			jse.executeScript("arguments[0].click();",Guestrole);
		}
		else if(role.equals("Registered"))
		{
			jse.executeScript("arguments[0].click();",Regrole);
		}
		
		else if(role.equals("Vendors"))
		{
			jse.executeScript("arguments[0].click();",Vendorrole);
		}
	}
	public void setVendor(String vendor)
	{
		Select s2=new Select(vendors);
		if(vendor.equals("Vendor 1"))
		{
			s2.selectByValue("1");
		}
		else if(vendor.equals("Vendor 2"))
		{
			s2.selectByValue("2");
		}
		else 
		{
			s2.selectByValue("0");
		}
	}
  public void setAdmincomment(String Comment)
	{
		comment.sendKeys(Comment);
	}
	public void setCustomer_Info_Save()
	{
		save.click();
	}
	public void setLogout()
	{
		clicklogout.click();
	}

}
