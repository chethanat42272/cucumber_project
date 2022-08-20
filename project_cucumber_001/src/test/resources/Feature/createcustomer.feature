Feature: Customers

Background: Below steps are common for all Scenarios

Given User launching the browser
When user open the browser with url as "https://admin-demo.nopcommerce.com/" 
And user enter email as "admin@yourstore.com" and password as "admin"
And user click the login button
Then user can view the dashboard page title as "Dashboard / nopCommerce administration"
When user click on the Customers menu
Then user can veiw the Customers option
When user click on the Customers option

Scenario: Creating a new customer
zz
Then user can view the AddNew button
When user click on the AddNew button
Then user can view the Addnewcustomer page title as "Add a new customer / nopCommerce administration"
And User enters the customer info
And user save the  details
Then user can view the success message as "The new customer has been added successfully."
And user click on logout
And user close the browser

@sanity
Scenario: Search customer by EmailID

Then user enters the emailid
When user click on search button
Then user can able to  view the emailID
And user click on logout
And user close the browser

Scenario: Search customer By fullname

Then user should able to see the Search option
And user enter the firstname
And user enter the last name
When user click on search button
Then user can able to view the name
And user click on logout
And user close the browser
 
