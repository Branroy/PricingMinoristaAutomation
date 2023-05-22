package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectTipoIngreso implements Task {
    private final String tipoingreso;

    public SelectTipoIngreso(String tipoingreso) {
        this.tipoingreso = tipoingreso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(tipoingreso).from(SolicitudNuevo.TIPOINGRESO));
    }
}
