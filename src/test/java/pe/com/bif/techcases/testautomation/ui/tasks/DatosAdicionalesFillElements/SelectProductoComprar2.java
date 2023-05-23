package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectProductoComprar2 implements Task {
    private final String productocomprar2;

    public SelectProductoComprar2(String productocomprar2) {
        this.productocomprar2 = productocomprar2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(productocomprar2).from(SolicitudNuevo.PRODUCTOCOMPRAR2));
    }
}
