Feature: CRM basic functional Testing
  I want to use this template for my feature file

Background:
	Given User logged into CRM application
	
  @tag1
  Scenario Outline: Login CRM application
    Given User is on CRM login page
    When User entered <username> and <password>
    Then Login should be successful
		Examples:
		      | username 			  			| password 	  |
					| sachin.4648@gmail.com | Nandini@123 |
					
	@RegTest				
	Scenario Outline: Add new Contact
		Given User navigated to Contact
		When User clicks on Create button
		When User enters required details <Name>,<LName>
		Then Contact <Name> will be created
	Examples: 
			|Name  | LName 	  |
      |Admin | Admin123 |
      |Test  | Test123  | 
      |Suite | Suite123 |