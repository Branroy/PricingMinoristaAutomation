package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectMacroProducto implements Task {
    private final String macroproducto;

    public SelectMacroProducto(String macroproducto) {
        this.macroproducto = macroproducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.MACROPRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(macroproducto).from(SolicitudNuevo.MACROPRODUCTO));
    }
}
