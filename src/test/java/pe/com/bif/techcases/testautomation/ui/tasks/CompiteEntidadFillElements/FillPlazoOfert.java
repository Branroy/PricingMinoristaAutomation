package pe.com.bif.techcases.testautomation.ui.tasks.CompiteEntidadFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillPlazoOfert implements Task {
    private final String plazoofert;

    public FillPlazoOfert(String plazoofert) {
        this.plazoofert = plazoofert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.PLAZOOFERT),
                Enter.theValue(plazoofert).into(SolicitudNuevo.PLAZOOFERT));
    }
}
