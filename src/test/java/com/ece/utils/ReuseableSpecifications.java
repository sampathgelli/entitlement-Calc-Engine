package com.ece.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.apache.commons.net.util.Base64;

public class ReuseableSpecifications {
	
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
	
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification responseSpecification;

	static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	static String authCookie = (variables.getProperty("application.userName") + ":" + variables.getProperty("application.password"));
	static String authCookieEncoded = new String(Base64.encodeBase64(authCookie.getBytes()));
	public static RequestSpecification getGenericRequestSpec(){
		
		rspec = new RequestSpecBuilder();
		rspec.addHeader("Authorization", "Basic "+ authCookieEncoded);
		rspec.setContentType(ContentType.JSON);
		requestSpecification = rspec.build();
		return requestSpecification;
		
	}
	
	public static ResponseSpecification getGenericResponseSpec(){
		respec = new ResponseSpecBuilder();
		respec.expectHeader("Content-Type","application/json;charset=UTF-8");
		//respec.expectHeader("Transfer-Encoding","chunked");
		respec.expectResponseTime(lessThan(15L),TimeUnit.SECONDS);
		responseSpecification = respec.build();
		return responseSpecification;
		
	}
}
