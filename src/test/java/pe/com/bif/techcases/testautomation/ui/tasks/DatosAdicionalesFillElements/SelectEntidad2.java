package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectEntidad2 implements Task {
    private final String entidad2;

    public SelectEntidad2(String entidad2) {
        this.entidad2 = entidad2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.ENTIDAD2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(entidad2).from(SolicitudNuevo.ENTIDAD2));
    }
}
