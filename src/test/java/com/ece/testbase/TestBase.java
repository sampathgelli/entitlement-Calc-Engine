package com.ece.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class TestBase {
	
	static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = variables.getProperty("ece.dev.baseurl");
	}
}
