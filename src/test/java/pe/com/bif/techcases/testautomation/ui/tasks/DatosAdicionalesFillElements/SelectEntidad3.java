package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectEntidad3 implements Task {
    private final String entidad3;

    public SelectEntidad3(String entidad3) {
        this.entidad3 = entidad3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.ENTIDAD3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(entidad3).from(SolicitudNuevo.ENTIDAD3));
    }
}
