package pe.com.bif.techcases.testautomation.ui.tasks.CompiteEntidadFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillMontoOfert implements Task {
    private final String montoofert;

    public FillMontoOfert(String montoofert) {
        this.montoofert = montoofert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MONTOOFERT),
                Enter.theValue(montoofert).into(SolicitudNuevo.MONTOOFERT));
    }
}
