package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;


public class LoginFill {

    public static Performable usuario(String usuario) {
        return Task.where("{0} enters usuario '" + usuario + "'",
                Clear.field(Login.USUARIO),
                Enter.theValue(usuario).into(Login.USUARIO));
    }

    public static Performable password(String password) {
        return Task.where("{0} enters password '" + password + "'",
                Clear.field(Login.PASSWORD),
                Enter.theValue(password).into(Login.PASSWORD));
    }

    public static Performable enter() {
        return Task.where("{0} click on entrar",
                Click.on(Login.ENTRAR));
    }

}
