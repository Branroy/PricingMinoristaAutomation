package pe.com.bif.techcases.testautomation.ui.questions.SolicitudNuevoQuestions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class ValidaIdCotizacion implements Question<String> {



    @Override
    public String answeredBy(Actor actor) {
            return actor.asksFor(Text.of(SolicitudNuevo.IDCOTIZACION));
        }

    // idcotizacion = actor.asksFor(new ValidaIdCotizacion());

    }

