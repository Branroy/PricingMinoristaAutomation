package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectDivisaProducto2 implements Task {
    private final String divisaproducto2;

    public SelectDivisaProducto2(String divisaproducto2) {
        this.divisaproducto2 = divisaproducto2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(divisaproducto2).from(SolicitudNuevo.DIVISAPRODUCTO2));
    }
}
