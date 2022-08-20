package Stepdefinitions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.Addcustomerpage;
import pageobjects.Loginpage;
import pageobjects.SearchCustomerpage;
import utilities.Waithelper;


public class Loginsteps extends BaseClass  {
	@Before
	public void setUP() throws IOException
	{
		//Reading the properties 
		logprop = new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		logprop.load(fis);
		String br=logprop.getProperty("browser");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		logger=Logger.getLogger("project_cucumber_001");//added logger
		PropertyConfigurator.configure("logger.properties");

		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", logprop.getProperty("chromepath"));
			logger.info("*****Browser started to launch*****");
			driver=new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", logprop.getProperty("firefoxpath"));
			logger.info("*****Browser started to launch*****");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", logprop.getProperty("iepath"));
			logger.info("*****Browser started to launch*****");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", logprop.getProperty("edgepath"));
			logger.info("*****Browser started to launch*****");
			driver=new EdgeDriver();
			driver.manage().window().maximize();

		}



	}

	@Given("User launching the browser")
	public void user_launching_the_browser() {



		lp=new Loginpage(driver);
	}

	@When("user open the browser with url as {string}")
	public void user_open_the_browser_with_url_as(String url) {
		logger.info("****Opening the URL****");
		driver.get(url);
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		logger.info("***Providing the valid login details***");
		lp.setEmail(email);
		lp.setPassword(pwd);

	}

	@When("user click the login button")
	public void user_click_the_login_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("****Clicking the login button****");
		lp.setLogin();
		Thread.sleep(3000);
	}

	@Then("Homepage title should be {string}")
	public void homepage_title_should_be(String string) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("****Getting the actual homepage title*****");
		String title=driver.getTitle();
		logger.info("****Validating the actual and Expected title of Homepage*****");
		Assert.assertEquals(title, string);
		logger.info("***Printing the HomePage Title***");
		System.out.println("Homepage title is "+title);

	}

	@When("user perform the logout")
	public void user_perform_the_logout() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("***Clicking the logout button***");
		lp.setLogout();
		Thread.sleep(4000);
	}

	@Then("Login page title should be {string}")
	public void login_page_title_should_be(String Exp) {
		// Write code here that turns the phrase above into concrete actions
		logger.info("***Getting the login page Title***");
		String loginpagetitle=driver.getTitle();
		logger.info("****Validating the actual and Expected title of Loginpage*****");
		Assert.assertEquals(Exp, loginpagetitle);
		logger.info("****Printing the LoginPage title****");
		System.out.println("Loginpage title is "+loginpagetitle);
	}



	@Then("close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("***Closing the browser***");
		driver.close();
	}

	//Steps to add new Customer
	@Then("user can view the dashboard page title as {string}")
	public void user_can_view_the_dashboard_page_title_as(String string) {
		logger.info("***Initializing the addcustomerpage object***");
		addcust=new Addcustomerpage(driver);
		logger.info("***Getting the addcustomer page title***");
		String title=addcust.gettitle();
		Assert.assertEquals(string, title);
	}

	@When("user click on the Customers menu")
	public void user_click_on_the_customers_menu() throws InterruptedException {
		logger.info("****Clicking the customer menu option***");
		addcust.setCusomermenuclick();
		Thread.sleep(3000);
	}

	@Then("user can veiw the Customers option")
	public void user_can_veiw_the_customers_option() {
		logger.info("***Getting the customers option text and validating the text with expected text***");
		String Actualtext=addcust.clickcust1.getText();
		Assert.assertEquals(Actualtext, "Customers");
	}

	@When("user click on the Customers option")
	public void user_click_on_the_customers_option() throws InterruptedException {
		logger.info("****clicking the customers option****");
		addcust.setClickCustomer();
		Thread.sleep(4000);
	}


	@Then("user can view the AddNew button")
	public void user_can_view_the_add_new_button() {

		String actualtext= addcust.addnewbttn.getText();
		Assert.assertEquals("Add new", actualtext);
	}

	@When("user click on the AddNew button")
	public void user_click_on_the_add_new_button() throws InterruptedException {
		logger.info("***Clicking the Addnew button***");
		addcust.setAddnewCustomer();
		Thread.sleep(3000);
	}

	@Then("user can view the Addnewcustomer page title as {string}")
	public void user_can_view_the_addnewcustomer_page_title_as(String string) {
		String actualtitle=addcust.gettitle();
		Assert.assertEquals(string, actualtitle);
	}

	@Then("User enters the customer info")
	public void user_enters_the_customer_info() throws InterruptedException {
		logger.info("***Entering the required data into the customer info ****");
		String uniquemail= randomestring()+"@gmail.com";
		addcust.setEmail(uniquemail);
		addcust.setPassword("@bvndj123");
		addcust.setFirstName("Arun");
		addcust.setLastName("Singh");
		addcust.setGender("male");
		addcust.setDate_Of_Birth("12/12/1991");
		addcust.setCompany_Name("Birlasoft");
		Thread.sleep(6000);
		addcust.setNewsletter("Test store 2");
		Thread.sleep(4000);
		addcust.setRoles("Forum Moderators");
		addcust.setVendor("Not a vendor");
		Thread.sleep(4000);
		addcust.setAdmincomment("This is a customer comment");
		Thread.sleep(5000);

	}

	@Then("user save the  details")
	public void user_save_the_details() throws InterruptedException {
		logger.info("****Saving the details****");
		addcust.setCustomer_Info_Save();
		Thread.sleep(4000);
	}

	@Then("user can view the success message as {string}")
	public void user_can_view_the_success_message_as(String string) {
		Assert.assertTrue(addcust.successmessage.getText().contains(string));
	}

	@Then("user click on logout")
	public void user_click_on_logout() throws InterruptedException {
		addcust.setLogout();
		Thread.sleep(2500);

	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		logger.info("*****Closing the browser****");
		driver.close();
	}

	//steps to search customer by EmailID
	@Then("user enters the emailid")
	public void user_enters_the_emailid() {
		logger.info("****Initializing the SearchCustomerpage object***");
		srchcust=new SearchCustomerpage(driver);
		logger.info("***Entering the emailID to search customer***");
		srchcust.setEmailId("victoria_victoria@nopCommerce.com");
	}

	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		logger.info("***Clicking the search button***");
		srchcust.setSearchClick();
		Thread.sleep(4000);
	}

	@Then("user can able to  view the emailID")
	public void user_can_able_to_view_the_email_id() throws InterruptedException {

		boolean ans= srchcust.validateCustomerByEmailId("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, ans);
		Thread.sleep(3000);
	}

	//steps to find customer by name
	@Then("user should able to see the Search option")
	public void user_should_able_to_see_the_search_option() {
		srchcust=new SearchCustomerpage(driver);
		String text1=srchcust.getSearchtext();
		Assert.assertEquals("Search", text1);
	}

	@Then("user enter the firstname")
	public void user_enter_the_firstname() {
		logger.info("***Entering the firstname to search Customer***");
		srchcust.setFirstName("James");
	}

	@Then("user enter the last name")
	public void user_enter_the_last_name() {
		logger.info("****Entering the lastname to search Customer***");
		srchcust.setLastName("Pan");
	}

	@Then("user can able to view the name")
	public void user_can_able_to_view_the_name() {
		logger.info("****Searching the customer by fullname****");
		boolean ans= srchcust.validateCustomerByName("James", "Pan");
		Assert.assertEquals(true, ans);
	}


}
