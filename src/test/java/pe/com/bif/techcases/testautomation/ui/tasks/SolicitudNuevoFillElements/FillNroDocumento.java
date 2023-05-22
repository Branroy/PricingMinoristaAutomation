package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillNroDocumento implements Task {
    private final String nrodocumento;

    public FillNroDocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.NRODOCUMENTO),
                Enter.theValue(nrodocumento).into(SolicitudNuevo.NRODOCUMENTO));
    }
}
