package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FlagProyectoBanco implements Task {
    private final String proyectobanco;

    public FlagProyectoBanco(String proyectobanco) {
        this.proyectobanco = proyectobanco;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PROYECTOBANCO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Click.on(SolicitudNuevo.PROYECTOBANCO));

    }
}
