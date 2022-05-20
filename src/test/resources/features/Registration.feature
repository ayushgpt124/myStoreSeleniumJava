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
	Then user fills form 
		| FirstName | LastName | Email	  | Phone     | Comment          |
		| John      | Doe      | jdoe     | testPass1 | jdoe@email.com |	