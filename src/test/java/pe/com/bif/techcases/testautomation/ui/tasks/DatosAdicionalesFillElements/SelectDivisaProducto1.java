package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectDivisaProducto1 implements Task {
    private final String divisaproducto1;

    public SelectDivisaProducto1(String divisaproducto1) {
        this.divisaproducto1 = divisaproducto1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(divisaproducto1).from(SolicitudNuevo.DIVISAPRODUCTO1));
    }
}
