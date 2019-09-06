Feature: Create shipping

Scenario: Enter originating shippin address

Given  a user navigates to create shipping page
When user enters shipping address info 
	| FullName   | Address      | ZipCode | Email         | Phone      |
	| Tom Peter  | 123 Home St. | 46835   | tom@gmail.com | 2023334578 |
	
Then system autofiles city and state based on zipcode entered
And user clicks on continue button
Then system displays address entered with edit option
Then close browser
