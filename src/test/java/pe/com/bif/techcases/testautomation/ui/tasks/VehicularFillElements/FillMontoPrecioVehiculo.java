package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillMontoPrecioVehiculo implements Task {
    private final String montopreciovehiculo;

    public FillMontoPrecioVehiculo(String montopreciovehiculo) {
        this.montopreciovehiculo = montopreciovehiculo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MONTOPRECIOVEHICULO),
                Enter.theValue(montopreciovehiculo).into(SolicitudNuevo.MONTOPRECIOVEHICULO));
    }
}
