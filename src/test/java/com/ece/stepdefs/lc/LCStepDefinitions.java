/**
 * 
 */
package com.ece.stepdefs.lc;
//package com.ece.stepdefs;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import com.ece.cucumber.steps.LCSteps;
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
public class LCStepDefinitions {
	
	ValidatableResponse response = null;
	SoftAssertions softAssertions=null;
	
	@Steps
	LCSteps steps;
	
    @Given("^User initiates for LC$")
    public void user_initiates_for_LC() {
        // Write code here that turns the phrase above into concrete actions
    	Serenity.recordReportData().withTitle("ApplicationURL").andContents(RestAssured.baseURI);
    }


    @When("^entitlement eligibility recalculation due to legislation change for \"([^\"]*)\"$")
    public void entitlement_eligibility_recalculation_due_to_legislation_change_for(String customernumber) {
        // Write code here that turns the phrase above into concrete actions
    	response = steps.sendLCRequest(customernumber); 
    }

    @Then("^verify the LC amount$")
    public void verify_the_LC_amount() {
        // Write code here that turns the phrase above into concrete actions
    	Assert.assertEquals("true", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.IsEligible").toString());
    	Assert.assertEquals("445.8", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.Amount").toString());

    }
	
}
