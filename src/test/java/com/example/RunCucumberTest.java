package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/resources/features",
        plugin = {"pretty", "html:target/Repports/ithsRapport.html"})
public class RunCucumberTest {

}
