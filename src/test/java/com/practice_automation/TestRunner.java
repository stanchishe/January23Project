package com.practice_automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/practice_automation/Login.feature"},

        plugin = {"pretty",
                "html:target/cucumber.html"}
)
public class TestRunner {


}
