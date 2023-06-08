package pe.com.bif.techcases.testautomation.ui.tasks.CompromisosFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectCompromiso implements Task {
    private final String compromiso;

    public SelectCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.COMPROMISO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(compromiso).from(SolicitudNuevo.COMPROMISO));
    }
}