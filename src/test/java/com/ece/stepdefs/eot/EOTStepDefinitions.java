/**
 * 
 */
package com.ece.stepdefs.eot;
//package com.ece.stepdefs;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import com.ece.cucumber.steps.EOTSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
/**
 * @author gellisampath.kumar
 *
 */
public class EOTStepDefinitions {
	
	ValidatableResponse response = null;
	SoftAssertions softAssertions=null;
	
	@Steps
	EOTSteps steps;
	
    @Given("^User initiates for EOT$")                                        
    public void user_initiates_for_EOT() {                                    
        // Write code here that turns the phrase above into concrete actions  
    	Serenity.recordReportData().withTitle("ApplicationURL").andContents(RestAssured.baseURI);                                         
    }                                                                         
                                                                              
                                                                              
    @When("^User applies for EOT with \"([^\"]*)\" for part time job$")       
    public void user_applies_for_EOT_with_for_part_time_job(String customernumber) {    
        // Write code here that turns the phrase above into concrete actions  
    	response = steps.sendEOTRequest(customernumber);                                        
    }                                                                         
                                                                              
    @Then("^verify the EOT$")                                                 
    public void verify_the_EOT() {                                            
        // Write code here that turns the phrase above into concrete actions  
    	Assert.assertEquals("true", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.IsEligible").toString());
    	Assert.assertEquals("293.6", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.Amount").toString());
                                             
    }                                                                         
	
}
