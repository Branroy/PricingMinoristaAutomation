package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectProductoComprar3 implements Task {
    private final String productocomprar3;

    public SelectProductoComprar3(String productocomprar3) {
        this.productocomprar3 = productocomprar3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(productocomprar3).from(SolicitudNuevo.PRODUCTOCOMPRAR3));
    }
}
