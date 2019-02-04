/**
 * 
 */
package com.ece.stepdefs.yal;
//package com.ece.stepdefs;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import com.ece.cucumber.steps.YALSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author gellisampath.kumar
 *
 */
public class YALStepDefinitions {
	
	ValidatableResponse response = null;
	SoftAssertions softAssertions=null;
	
	@Steps
	YALSteps steps;
	
    @Given("^User initiatiates eligibility for YAL$")
    public void user_initiatiates_eligibility_for_YAL() {
                Serenity.recordReportData().withTitle("ApplicationURL").andContents(RestAssured.baseURI);
    }

    @When("^User applies for youth allowance with \"([^\"]*)\"$")
    public void user_applies_for_youth_allowance_with(String customernumber) {
    	response = steps.sendYALRequest(customernumber);
    }

    @Then("^Calculate eligibility for user$")
    public void calculate_eligibility_for_user() {
        // Write code here that turns the phrase above into concrete actions
    	//assertThat(actualValue, hasValue(email));
    	
    	//softAssertions = new SoftAssertions();
    	//softAssertions.assertThat("true").isEqualTo(response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.IsEligible").toString());
    	//Serenity.recordReportData().withTitle("Sales details").andContents(softAssertions.toString());
    	Assert.assertEquals("true", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.IsEligible").toString());
    	Assert.assertEquals("293.6", response.extract().body().jsonPath().get("AssessmentResults.Customers[0].Claims[0].Calculations.Amount").toString());
    	//Serenity.recordReportData().withTitle("Sales details").andContents(assertThat());
    	
    }	
	



}
