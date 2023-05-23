package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectNombreProyecto implements Task {
    private final String nombreproyecto;

    public SelectNombreProyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.PROYECTOBANCO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(nombreproyecto).from(SolicitudNuevo.PROYECTOBANCO));

    }
}
