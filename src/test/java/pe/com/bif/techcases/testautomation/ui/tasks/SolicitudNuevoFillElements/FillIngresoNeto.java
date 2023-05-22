package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillIngresoNeto implements Task {
    private final String ingresoneto;

    public FillIngresoNeto(String ingresoneto) {
        this.ingresoneto = ingresoneto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.INGRESONETO),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETO),
                Enter.theValue(ingresoneto).into(SolicitudNuevo.INGRESONETO));
    }
}
