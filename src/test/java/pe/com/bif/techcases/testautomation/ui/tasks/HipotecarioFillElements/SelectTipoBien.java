package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectTipoBien implements Task {
    private final String tipobien;

    public SelectTipoBien(String tipobien) {
        this.tipobien = tipobien;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.TIPOBIEN, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(tipobien).from(SolicitudNuevo.TIPOBIEN));

    }
}
