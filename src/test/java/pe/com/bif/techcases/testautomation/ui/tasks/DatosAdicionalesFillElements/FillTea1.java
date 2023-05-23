package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillTea1 implements Task {
    private final String tea1;

    public FillTea1(String tea1) {
        this.tea1 = tea1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.TEA1),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA1),
                Enter.theValue(tea1).into(SolicitudNuevo.TEA1));
    }
}
