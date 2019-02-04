/**
 * 
 */
package com.ece.stepdefs.ftb;
//package com.ece.stepdefs;

import org.junit.Assert;
import com.ece.cucumber.steps.FTBSteps;
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
public class FTBStepDefinitions {
	
	ValidatableResponse response = null;
	

	@Steps
	FTBSteps steps;
	
    @Given("^User initiates for FTB$")
    public void user_initiates_calculates_for_FTB() {
        // Write code here that turns the phrase above into concrete actions
    	Serenity.recordReportData().withTitle("ApplicationURL").andContents(RestAssured.baseURI);
    }


    @When("^User applies for FTB with \"([^\"]*)\"$")
    public void user_applies_for_FTB_with(String customernumber) {
        // Write code here that turns the phrase above into concrete actions
    	response = steps.sendFTBRequest(customernumber);
    }

    @Then("^verify the FTB$")
    public void verify_the_FTB() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertEquals("true", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.IsEligible").toString());
    	Assert.assertEquals("445.8", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.Amount").toString());
    }



}
