package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\Features",
        glue = {"TestCases"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
class TestRunner {
}
