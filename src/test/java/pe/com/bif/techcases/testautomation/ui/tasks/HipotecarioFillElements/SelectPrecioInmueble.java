package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectPrecioInmueble implements Task {
    private final String precioinmueble;

    public SelectPrecioInmueble(String precioinmueble) {
        this.precioinmueble = precioinmueble;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRECIOINMUEBLE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(precioinmueble).from(SolicitudNuevo.PRECIOINMUEBLE));

    }
}
