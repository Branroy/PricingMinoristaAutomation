package pe.com.bif.techcases.testautomation.ui.tasks.LoginfillElements;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;

public class FillPassword implements Task {
        private final String password;

        public FillPassword(String password) {
            this.password = password;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Clear.field(Login.PASSWORD),
                    Enter.theValue(password).into(Login.PASSWORD));
        }
}
