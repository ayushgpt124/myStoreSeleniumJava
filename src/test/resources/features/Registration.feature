Feature: AutomationPractice Registration 

Scenario: AutomationPractice Registration 
	Given a web browser is on the HomePage 
	When user clicks in sign in button 
	Then user navigates to login page 
	When user enters Email Address and clicks on Create account 
		| Email |Error|
		| a@a.com | An account using this email address has already been registered. Please enter a valid password or request a new one. | 
		| testEmail1124@gmail.com | |
	Then user navigates to registration form 
	Then I click on Register button
	Then user fills form 
		| FirstName | LastName | Pass	  	| Days     | Month  | Year   | FirstAddressName | LastAddressName | CompanyName | Address | City | State | ZIP     |Country| Additional    |HomePhone |MobilePhone|AliasEmail     | 
		| John      | Doe      | johdoe     | 25       | 8      | 25     |	JohnAddress     | DoeAddress      | testCompany | Noida   | Noida| 3     |1234567  |	1  | testAdditional|1234567890|0987654321 |alias@Email.com|