package pe.com.bif.techcases.testautomation.ui.tasks.VehicularFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class FillModelo implements Task {
    private final String modelo;

    public FillModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(SolicitudNuevo.MODELO),
                Enter.theValue(modelo).into(SolicitudNuevo.MODELO));
    }
}
