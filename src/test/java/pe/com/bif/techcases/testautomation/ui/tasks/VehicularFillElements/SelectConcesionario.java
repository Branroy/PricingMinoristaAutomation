package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectConcesionario implements Task {
    private final String concesionario;

    public SelectConcesionario(String concesionario) {
        this.concesionario = concesionario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.CONCESIONARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(concesionario).from(SolicitudNuevo.CONCESIONARIO));
    }
}