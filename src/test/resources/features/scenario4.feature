Feature: Scenario4 : Legislative Change

Scenario Outline:Entitlement eligibility is Re Run due to Rule changes due to legislation change 

	Given User initiates for LC 
	When entitlement eligibility recalculation due to legislation change for "<customernumber>"
	Then verify the LC amount 
	
	Examples: 
		| customernumber|
		|204794278|
