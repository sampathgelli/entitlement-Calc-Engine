Feature: Scenario1 : Eligibility For youth allowance 

Scenario Outline:To calculate eligibility and entitlement for youth allowance for the applicants with basic calculations. 

	Given User initiatiates eligibility for YAL 
	When User applies for youth allowance with "<customernumber>" 
	Then Calculate eligibility for user 
	
	Examples: 
		| customernumber|
		|204794278|
