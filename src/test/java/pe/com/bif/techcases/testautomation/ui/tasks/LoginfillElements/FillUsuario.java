package pe.com.bif.techcases.testautomation.ui.tasks.LoginfillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;

public class FillUsuario implements Task {
    private final String usuario;

    public FillUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(Login.USUARIO),
                Enter.theValue(usuario).into(Login.USUARIO));
    }
}
