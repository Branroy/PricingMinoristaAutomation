package pe.com.bif.techcases.testautomation.ui.tasks.CompiteEntidadFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectProductoOfert implements Task {
    private final String productoofert;

    public SelectProductoOfert(String productoofert) {
        this.productoofert = productoofert;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRODUCTOOFERT, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(productoofert).from(SolicitudNuevo.PRODUCTOOFERT));
    }
}
