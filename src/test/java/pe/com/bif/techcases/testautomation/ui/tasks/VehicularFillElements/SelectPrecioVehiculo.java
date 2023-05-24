package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectPrecioVehiculo implements Task {
    private final String preciovehiculo;

    public SelectPrecioVehiculo(String preciovehiculo) {
        this.preciovehiculo = preciovehiculo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRECIOVEHICULO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(preciovehiculo).from(SolicitudNuevo.PRECIOVEHICULO));
    }
}
