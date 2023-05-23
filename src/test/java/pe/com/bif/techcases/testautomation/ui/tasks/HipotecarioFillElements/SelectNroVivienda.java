package pe.com.bif.techcases.testautomation.ui.tasks.HipotecarioFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SelectNroVivienda implements Task {
    private final String nrovivienda;

    public SelectNroVivienda(String nrovivienda) {
        this.nrovivienda = nrovivienda;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SolicitudNuevo.NROVIVIENDA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(nrovivienda).from(SolicitudNuevo.NROVIVIENDA));

    }
}
