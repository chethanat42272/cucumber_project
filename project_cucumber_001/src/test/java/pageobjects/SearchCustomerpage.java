package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Waithelper;

public class SearchCustomerpage {
	@FindBy(how = How.XPATH, using = "//input[@id='SearchEmail']")
	@CacheLookup
	public static WebElement emailtext;

	@FindBy(how = How.XPATH, using = "//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement firstnametext;

	@FindBy(how = How.XPATH, using = "//input[@id='SearchLastName']")
	@CacheLookup
	WebElement lasttnametext;

	@FindBy(how = How.XPATH, using = "//button[@id='search-customers']")
	@CacheLookup
	WebElement scrchbttn;

	@FindBy(how=How.XPATH,using="//div[text()='Search']")
	@CacheLookup
	WebElement searchtext;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> rows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> cols;

	WebDriver driver;
	Waithelper waiter;

	public SearchCustomerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new Waithelper(driver);
	}

	public void setEmailId(String email) {
		waiter.WaitForElement(emailtext, 10);
		emailtext.sendKeys(email);
	}

	public void setFirstName(String fname) {
		waiter.WaitForElement(firstnametext, 10);
		firstnametext.sendKeys(fname);
	}

	public void setLastName(String lname) {
		waiter.WaitForElement(lasttnametext, 10);
		lasttnametext.sendKeys(lname);
	}

	public void setSearchClick() {
		waiter.WaitForElement(scrchbttn, 10);
		scrchbttn.click();
	}
	public String getSearchtext()
	{	
		String text=searchtext.getText();
		return text;
	}

	public int getRowsCount() {
		int noOfrows = rows.size();
		return noOfrows;
	}

	public int getColumncount() {
		int noOfcols = cols.size();
		return noOfcols;
	}
	public boolean validateCustomerByName(String firstname,String lastname)
	{
		boolean flag=false;
		for(int i=1;i<=getRowsCount();i++)
		{
			String Actualname=	driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println("found name is "+Actualname);
			String arr[]=Actualname.split(" ");
			if(arr[0].equals(firstname)&&arr[1].equals(lastname))
			{
				flag=true;
			}


		}
		return flag;

	}
	public boolean validateCustomerByEmailId(String Email)
	{
		boolean flag=false;
		for(int i=1;i<=getRowsCount();i++)
		{
			String Actualmail=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("Found EmailId is "+Actualmail);
			if(Actualmail.equals(Email))
			{
				flag=true;
			}
		}
		return flag;
	}
}
