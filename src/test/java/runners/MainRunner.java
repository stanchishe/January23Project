package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", features = "src/test/resources/features", glue = "stepDefinitions",
        plugin = {})

public class MainRunner {

}
