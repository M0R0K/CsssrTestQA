package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/features/TestLink.feature",
        glue = ("stepDefinitions"),
        tags = "@all"

)

public class Runner {
}
