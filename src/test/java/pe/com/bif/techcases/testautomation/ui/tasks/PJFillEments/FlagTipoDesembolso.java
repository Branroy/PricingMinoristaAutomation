package pe.com.bif.techcases.testautomation.ui.tasks.PJFillEments;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FlagTipoDesembolso implements Task {
    private final String tipodesembolso;

    public FlagTipoDesembolso(String tipodesembolso) {
        this.tipodesembolso = tipodesembolso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.TIPODESEMBOLSO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Click.on(SolicitudNuevo.TIPODESEMBOLSO));

    }
}
