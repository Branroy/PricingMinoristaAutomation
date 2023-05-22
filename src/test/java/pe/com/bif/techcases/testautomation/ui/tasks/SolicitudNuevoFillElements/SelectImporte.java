package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectImporte implements Task {
    private final String importe;

    public SelectImporte(String importe) {
        this.importe = importe;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.IMPORTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(importe).from(SolicitudNuevo.IMPORTE));
    }
}
