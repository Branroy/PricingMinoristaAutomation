package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillMontoOperacion implements Task {
    private final String montooperacion;

    public FillMontoOperacion(String montooperacion) {
        this.montooperacion = montooperacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MONTOOPERACION),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOOPERACION),
                Enter.theValue(montooperacion).into(SolicitudNuevo.MONTOOPERACION));
    }
}
