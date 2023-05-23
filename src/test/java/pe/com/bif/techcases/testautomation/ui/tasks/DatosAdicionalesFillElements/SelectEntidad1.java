package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectEntidad1 implements Task {
    private final String entidad1;

    public SelectEntidad1(String entidad1) {
        this.entidad1 = entidad1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.ENTIDAD1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(entidad1).from(SolicitudNuevo.ENTIDAD1));
    }
}
