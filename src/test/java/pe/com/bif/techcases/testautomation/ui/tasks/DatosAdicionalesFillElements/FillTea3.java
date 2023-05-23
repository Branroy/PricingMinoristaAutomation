package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillTea3 implements Task {
    private final String tea3;

    public FillTea3(String tea3) {
        this.tea3 = tea3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.TEA3),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA3),
                Enter.theValue(tea3).into(SolicitudNuevo.TEA3));
    }
}
