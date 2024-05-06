package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "feature",
        glue = {"stepDefinitions"},
        tags = "@activity3"
)

public class gactivity3 {
}
