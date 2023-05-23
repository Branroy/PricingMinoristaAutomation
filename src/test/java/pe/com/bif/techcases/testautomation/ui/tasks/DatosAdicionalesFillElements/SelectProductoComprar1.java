package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectProductoComprar1 implements Task {
    private final String productocomprar1;

    public SelectProductoComprar1(String productocomprar1) {
        this.productocomprar1 = productocomprar1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(productocomprar1).from(SolicitudNuevo.PRODUCTOCOMPRAR1));
    }
}
