package pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillIngresoNetoCodeudor implements Task {
    private final String ingresonetocodeudor;

    public FillIngresoNetoCodeudor(String ingresonetocodeudor) {
        this.ingresonetocodeudor = ingresonetocodeudor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.INGRESONETOCODEUDOR),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETOCODEUDOR),
                Enter.theValue(ingresonetocodeudor).into(SolicitudNuevo.INGRESONETOCODEUDOR));
    }
}
