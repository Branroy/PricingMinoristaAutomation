package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FlagPlanAhorro implements Task {
    private final String planahorro;

    public FlagPlanAhorro(String planahorro) {
        this.planahorro = planahorro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PLANAHORRO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Click.on(SolicitudNuevo.PLANAHORRO));

    }
}
