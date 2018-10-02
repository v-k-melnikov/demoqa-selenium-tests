package com.demoqa.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/demoqa/tests/features",
        glue = "com.demoqa.tests",
        tags = "@all",
        snippets = SnippetType.CAMELCASE
)

public class RunnerTest  {
}