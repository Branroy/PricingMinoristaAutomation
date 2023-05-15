package pe.com.bif.techcases.testautomation;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="pe.com.bif.techcases.testautomation")
public class Tests {

}
