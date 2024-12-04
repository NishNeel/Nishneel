
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/main/resources/Features",  // Location of your feature files
	    glue = {"src/main/java/setpDefination", "src/main/java/Hooks/BaseClass"},  // Location of your step definition classes
	    plugin = {"pretty", "html:target/cucumber-report.html"}  // Reporting options
	    //monochrome = true // Improve readability of console output
	    // tags = "@smoke"  // Run tests with specific tags (optional)
	    )

public class TestRunner {

	
	
}
