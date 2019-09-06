Feature: UPS.com Login feature

As a user, 
I want to login with my credentials
So that i can create shipping

Scenario Outline: UPS.com Login Test Scenario

Given user is already on UPS home page "https://www.ups.com/us/en/Home.page"
When user clicks on SignIn link
Then UPS SingIn page should display
Then user enters valid credentials "<username>", "<password>"
And user clicks on signin button
Then user is on home page
And user clicks on sign out button
Then UPS Home Page is displayed

Examples:
		| username    | password    |
	    | employe10   | comPany1245 |
	    
	    
Scenario: User enters wrong password

Given a registered user with UPS.com
And I am on the login page
When I enter valid username "employe10"
And I enter invalid password "land4Evering"
And I click on login button
Then I should see "Password is required" message



	    
	

