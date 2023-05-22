package pe.com.bif.techcases.testautomation.ui.mapping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BandejaCotizacionesFDN {
    public static final Target NUEVACOTIZACION = Target
            .the("nuevacotizacion")
            .located(By.xpath("//*[@id=\"optNuevaCotizacion\"]/a"));
}

