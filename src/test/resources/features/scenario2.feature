Feature: Scenario2 : Parental Family Tax Benefit Calculation 

Scenario Outline:Calculate the parental family tax benefit 

	Given User initiates for FTB 
	When User applies for FTB with "<customernumber>" 
	Then verify the FTB 
	
	Examples: 
		| customernumber|
		|204794278|
