package pe.com.bif.techcases.testautomation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pe.com.bif.techcases.testautomation.ui.actors.BaseConf;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginFill;
import pe.com.bif.techcases.testautomation.ui.tasks.NavigateTo;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginfillElements.FillUsuario;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/testdata/PLDTarifario.csv")
public class ParameterizedTest extends BaseConf {

    private String usuario;
    private String password;

    @Before
    public void navigate() {
        actor.attemptsTo(NavigateTo.signUpPage());
    }

    @Test
    public void CotizacionTarifarioPLD() {
        actor.attemptsTo(
                LoginFill.usuario(usuario),
                LoginFill.password(password),
                LoginFill.enter()
        );

    }

}
