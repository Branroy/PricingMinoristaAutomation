package pe.com.bif.techcases.testautomation.ui.mapping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login {
    public static final Target USUARIO = Target
            .the("usuario")
            .located(By.xpath("//*[@id=\"txtUsuario\"]"));

    public static final Target PASSWORD = Target
            .the("password")
            .located(By.xpath("//*[@id=\"txtPassword\"]"));

    public static final Target ENTRAR = Target
            .the("entrar")
            .located(By.xpath("//*[@id=\"btnLogin\"]"));

}
