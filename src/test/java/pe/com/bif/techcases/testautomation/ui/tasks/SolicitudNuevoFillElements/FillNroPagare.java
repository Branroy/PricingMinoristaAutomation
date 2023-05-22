package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillNroPagare implements Task {

    private final String nropagare;

    public FillNroPagare(String nropagare) {
        this.nropagare = nropagare;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.NROPAGARE),
                Enter.theValue(nropagare).into(SolicitudNuevo.NROPAGARE));
    }
}
