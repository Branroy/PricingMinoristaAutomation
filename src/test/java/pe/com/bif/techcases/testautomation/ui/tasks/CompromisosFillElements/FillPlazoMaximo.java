package pe.com.bif.techcases.testautomation.ui.tasks.CompromisosFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillPlazoMaximo implements Task {
    private final String plazomaximo;

    public FillPlazoMaximo(String plazomaximo) {
        this.plazomaximo = plazomaximo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.PLAZOMAXDIAS),
                Enter.theValue(plazomaximo).into(SolicitudNuevo.PLAZOMAXDIAS));
    }
}
