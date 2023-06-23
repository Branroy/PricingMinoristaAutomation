package pe.com.bif.techcases.testautomation.ui.questions.SolicitudNuevoQuestions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class ValidaGuardarOperacion implements Question<String> {

    @Override
    public String answeredBy(Actor actor){
        return SolicitudNuevo.MSGOPERACIONEXISTO.resolveFor(actor).getText();
        //return BrowseTheWeb.as(actor).find(SolicitudNuevo.MSGOPERACIONEXISTO).getText();
    }

    public static Question<String> value(){
        return new ValidaGuardarOperacion();
    }

}
