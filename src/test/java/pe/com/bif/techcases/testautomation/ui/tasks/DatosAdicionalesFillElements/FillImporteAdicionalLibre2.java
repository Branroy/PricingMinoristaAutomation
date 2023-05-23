package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteAdicionalLibre2 implements Task {
    private final String importeadicionallibre2;

    public FillImporteAdicionalLibre2(String importeadicionallibre2) {
        this.importeadicionallibre2 = importeadicionallibre2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE2),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE2),
                Enter.theValue(importeadicionallibre2).into(SolicitudNuevo.IMPORTEADICIONALLIBRE2));
    }
}
