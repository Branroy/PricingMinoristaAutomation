package pe.com.bif.techcases.testautomation.ui.tasks.CompromisosFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillMontoValor implements Task {
    private final String montovalor;

    public FillMontoValor(String montovalor) {
        this.montovalor = montovalor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MONTOVALOR),
                Enter.theValue(montovalor).into(SolicitudNuevo.MONTOVALOR));
    }
}
