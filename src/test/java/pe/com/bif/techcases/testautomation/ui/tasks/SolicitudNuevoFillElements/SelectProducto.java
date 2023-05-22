package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectProducto implements Task {
    private final String producto;

    public SelectProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(producto).from(SolicitudNuevo.PRODUCTO));
    }
}
