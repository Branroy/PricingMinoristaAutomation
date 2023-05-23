package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteComprar3 implements Task {
    private final String importecomprar3;

    public FillImporteComprar3(String importecomprar3) {
        this.importecomprar3 = importecomprar3;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTECOMPRAR3),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR3),
                Enter.theValue(importecomprar3).into(SolicitudNuevo.IMPORTECOMPRAR3));
    }
}
