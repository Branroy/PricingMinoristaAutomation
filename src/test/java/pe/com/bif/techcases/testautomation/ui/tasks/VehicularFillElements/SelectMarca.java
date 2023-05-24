package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectMarca implements Task {
    private final String marca;

    public SelectMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.MARCA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(marca).from(SolicitudNuevo.MARCA));
    }
}