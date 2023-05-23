package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillImporteComprar1 implements Task {
    private final String importecomprar1;

    public FillImporteComprar1(String importecomprar1) {
        this.importecomprar1 = importecomprar1;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.IMPORTECOMPRAR1),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR1),
                Enter.theValue(importecomprar1).into(SolicitudNuevo.IMPORTECOMPRAR1));
    }
}
