package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillTea2 implements Task {
    private final String tea2;

    public FillTea2(String tea2) {
        this.tea2 = tea2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.TEA2),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA2),
                Enter.theValue(tea2).into(SolicitudNuevo.TEA2));
    }
}
