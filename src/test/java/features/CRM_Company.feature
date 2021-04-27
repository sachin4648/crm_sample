Feature: CRM basic functional Testing
  I want to use this template for my feature file

Background:
	Given User logged into CRM application

	@RegTest				
	Scenario Outline: Add new Comany
		Given User navigated to Company
		When User clicks on Create button
		When User enters company <Cname> name
		Then Company record will be created
	Examples: 
			|	Cname  	 |
      |	Google 	 |
      |	Facebook |
      | Amazon   |
