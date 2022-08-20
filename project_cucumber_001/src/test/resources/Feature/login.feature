Feature: Login
@sanity
Scenario: Login with valid credentials
Given User launching the browser
When user open the browser with url as "https://admin-demo.nopcommerce.com/" 
And user enter email as "admin@yourstore.com" and password as "admin"
And user click the login button
Then Homepage title should be "Dashboard / nopCommerce administration"
When user perform the logout
Then Login page title should be "Your store. Login"
Then close the browser
@run
Scenario Outline: Login with dataDriven
Given User launching the browser
When user open the browser with url as "https://admin-demo.nopcommerce.com/" 
And user enter email as "<Email>" and password as "<Password>"
And user click the login button
Then Homepage title should be "Dashboard / nopCommerce administration"
When user perform the logout
Then Login page title should be "Your store. Login"
Then close the browser

Examples:
|Email|Password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin|