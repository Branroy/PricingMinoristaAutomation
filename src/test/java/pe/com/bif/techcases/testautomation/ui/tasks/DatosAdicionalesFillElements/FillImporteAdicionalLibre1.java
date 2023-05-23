package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteAdicionalLibre1 implements Task {
    private final String importeadicionallibre1;

    public FillImporteAdicionalLibre1(String importeadicionallibre1) {
        this.importeadicionallibre1 = importeadicionallibre1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                Enter.theValue(importeadicionallibre1).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1));
    }
}
