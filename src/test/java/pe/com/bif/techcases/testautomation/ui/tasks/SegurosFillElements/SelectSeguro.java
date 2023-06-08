package pe.com.bif.techcases.testautomation.ui.tasks.SegurosFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectSeguro implements Task {
    private final String seguro;

    public SelectSeguro(String seguro) {
        this.seguro = seguro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.SEGUROS, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(seguro).from(SolicitudNuevo.SEGUROS));
    }
}
