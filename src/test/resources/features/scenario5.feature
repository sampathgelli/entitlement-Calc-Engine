Feature: Scenario3 : Entitlement over time Benefit Calculation 

Scenario Outline:Applicant after claiming youth allowance reports part time job 

	Given User initiates for EOT 
	When User applies for EOT with "<customernumber>" for part time job 
	Then verify the EOT 
	
	Examples: 
		| customernumber|
		|204794278|
