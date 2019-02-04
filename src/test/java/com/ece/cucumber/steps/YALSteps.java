/**
 * 
 */
package com.ece.cucumber.steps;

import org.json.JSONObject;
import com.ece.utils.ReuseableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

/**
 * @author gellisampath.kumar
 *
 */
public class YALSteps {
	
	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	   
	@Step("Creating youth allowance with customernumber:{0}")
	public ValidatableResponse sendYALRequest(String customernumber){
		
		JSONObject obj=new JSONObject();
        obj.put("RequestExecutionDate", "20180305");
        obj.put("ScenarioType", "Scenario1");
        JSONObject objp=new JSONObject();
        objp.put("SSOR", customernumber);
        obj.put("Customer", objp.toString());
	
	return	SerenityRest.rest()
			.given()
				.spec(ReuseableSpecifications.getGenericRequestSpec())
			.when()
				.body(obj.toString())
				.post(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("yal.resource"))
			.then()
				.spec(ReuseableSpecifications.getGenericResponseSpec());
				
	}

}
