package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable signUpPage() {
        return Task.where("{0} opens the Sign Up  page",
                Open.url("http://bif3pricing10/PricingMinoristaInc/Login"));
    }
}
