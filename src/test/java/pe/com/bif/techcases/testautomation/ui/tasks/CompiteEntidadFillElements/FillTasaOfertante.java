package pe.com.bif.techcases.testautomation.ui.tasks.CompiteEntidadFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillTasaOfertante implements Task {
    private final String tasaofertante;

    public FillTasaOfertante(String tasaofertante) {
        this.tasaofertante = tasaofertante;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.TASAOFERTANTE),
                Enter.theValue(tasaofertante).into(SolicitudNuevo.TASAOFERTANTE));
    }
}
