package FrontEnd.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/return.txt"
        },
        features = "src/test/resources/features",
        glue = "FrontEnd/StepDefinitions",
        dryRun = false,
        tags = ""

)
public class CucumberRunner {


}
