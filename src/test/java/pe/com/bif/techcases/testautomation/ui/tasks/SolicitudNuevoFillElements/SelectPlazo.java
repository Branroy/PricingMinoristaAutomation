package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectPlazo implements Task {
    private final String plazo;

    public SelectPlazo(String plazo) {
        this.plazo = plazo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PLAZO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(plazo).from(SolicitudNuevo.PLAZO));
    }
}
