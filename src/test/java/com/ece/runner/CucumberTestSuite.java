package com.ece.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import com.ece.testbase.TestBase;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue= {"com.ece.stepdefs.yal","com.ece.stepdefs.ftb","com.ece.stepdefs.eot","com.ece.stepdefs.lc"},
        //glue={"classpath/com/ece/stepdefs"},
        features = {"classpath:features"}
)
public class CucumberTestSuite extends TestBase {
}
