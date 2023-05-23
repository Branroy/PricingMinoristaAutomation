package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillMontoPrecioInmueble implements Task {
    private final String montoprecioinmueble;

    public FillMontoPrecioInmueble(String montoprecioinmueble) {
        this.montoprecioinmueble = montoprecioinmueble;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MONTOPRECIOINMUEBLE),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETOCODEUDOR),
                Enter.theValue(montoprecioinmueble).into(SolicitudNuevo.MONTOPRECIOINMUEBLE));
    }
}
