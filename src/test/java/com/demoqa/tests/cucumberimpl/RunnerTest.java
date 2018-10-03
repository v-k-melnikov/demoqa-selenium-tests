package com.demoqa.tests.cucumberimpl;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/demoqa/tests/features",
        glue = "com.demoqa.tests.cucumberimpl",
        tags = "@all",
        snippets = SnippetType.UNDERSCORE
)

public class RunnerTest  {
}