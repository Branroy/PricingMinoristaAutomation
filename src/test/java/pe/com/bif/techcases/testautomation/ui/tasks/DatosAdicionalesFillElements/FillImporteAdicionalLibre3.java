package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteAdicionalLibre3 implements Task {
    private final String importeadicionallibre3;

    public FillImporteAdicionalLibre3(String importeadicionallibre3) {
        this.importeadicionallibre3 = importeadicionallibre3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE3),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE3),
                Enter.theValue(importeadicionallibre3).into(SolicitudNuevo.IMPORTEADICIONALLIBRE3));
    }
}
