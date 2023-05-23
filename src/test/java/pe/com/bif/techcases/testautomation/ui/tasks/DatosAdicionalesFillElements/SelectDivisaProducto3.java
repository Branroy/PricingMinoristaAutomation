package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectDivisaProducto3 implements Task {
    private final String divisaproducto3;

    public SelectDivisaProducto3(String divisaproducto3) {
        this.divisaproducto3 = divisaproducto3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(divisaproducto3).from(SolicitudNuevo.DIVISAPRODUCTO3));
    }
}
