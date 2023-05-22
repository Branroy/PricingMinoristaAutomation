package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillNroPlazo implements Task {
    private final String nroplazo;

    public FillNroPlazo(String nroplazo) {
        this.nroplazo = nroplazo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.NROPLAZO),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.NROPLAZO),
                Enter.theValue(nroplazo).into(SolicitudNuevo.NROPLAZO));
    }
}
