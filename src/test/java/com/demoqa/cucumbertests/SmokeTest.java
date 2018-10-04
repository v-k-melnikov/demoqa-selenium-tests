package com.demoqa.cucumbertests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/demoqa/cucumbertests/resources/features",
        glue = "com.demoqa.cucumbertests",
        tags = "@smoke",
        snippets = SnippetType.CAMELCASE
)

public class SmokeTest {
}