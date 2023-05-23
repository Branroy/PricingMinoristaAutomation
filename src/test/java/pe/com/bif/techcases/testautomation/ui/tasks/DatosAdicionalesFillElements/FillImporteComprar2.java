package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteComprar2 implements Task {
    private final String importecomprar2;

    public FillImporteComprar2(String importecomprar2) {
        this.importecomprar2 = importecomprar2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTECOMPRAR2),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR2),
                Enter.theValue(importecomprar2).into(SolicitudNuevo.IMPORTECOMPRAR2));
    }
}
