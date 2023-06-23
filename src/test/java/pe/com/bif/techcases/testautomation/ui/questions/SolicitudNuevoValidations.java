package pe.com.bif.techcases.testautomation.ui.questions;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;
import pe.com.bif.techcases.testautomation.ui.questions.SolicitudNuevoQuestions.ValidaGuardarOperacion;
import pe.com.bif.techcases.testautomation.ui.questions.SolicitudNuevoQuestions.ValidaIdCotizacion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SolicitudNuevoValidations {

    public static void confirmaroperacion() {
        String expectedmsgtText = "Se guardó la operación con éxito.";
        OnStage.theActorInTheSpotlight().should(seeThat("Se valida mensaje:", ValidaGuardarOperacion.value(),
                equalTo(expectedmsgtText)));


    }


}
