package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillTasaComision implements Task {
    private final String tasacomision;

    public FillTasaComision(String tasacomision) {
        this.tasacomision = tasacomision;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.TASACOMISION),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TASACOMISION),
                Enter.theValue(tasacomision).into(SolicitudNuevo.TASACOMISION));
    }
}
