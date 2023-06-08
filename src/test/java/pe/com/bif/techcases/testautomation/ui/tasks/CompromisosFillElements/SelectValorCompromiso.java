package pe.com.bif.techcases.testautomation.ui.tasks.CompromisosFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectValorCompromiso implements Task {
    private final String valorcompromiso;

    public SelectValorCompromiso(String valorcompromiso) {
        this.valorcompromiso = valorcompromiso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.VALORCOMPROMISO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(valorcompromiso).from(SolicitudNuevo.VALORCOMPROMISO));
    }
}
