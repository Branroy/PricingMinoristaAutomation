package pe.com.bif.techcases.testautomation.ui.tasks.DatosAdicionalesFillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;
import sun.rmi.server.UnicastRef;

public class SelectTasaAdicionalLibre implements Task {
    private final String tasaadicionallibre;

    public SelectTasaAdicionalLibre(String tasaadicionallibre) {
        this.tasaadicionallibre = tasaadicionallibre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(SolicitudNuevo.TASAADICIONALLIBRE));
    }

}
