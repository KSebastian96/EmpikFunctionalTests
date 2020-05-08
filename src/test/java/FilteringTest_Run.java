import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/filtering.feature",
        plugin = {"pretty", "html:report"})
public class FilteringTest_Run {
}
