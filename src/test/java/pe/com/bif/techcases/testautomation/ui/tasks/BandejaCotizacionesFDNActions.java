package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import pe.com.bif.techcases.testautomation.ui.mapping.BandejaCotizacionesFDN;

public class BandejaCotizacionesFDNActions {
    public static Performable nuevacotizacion() {
        return Task.where("{0} click on nueva Cotización",
                Click.on(BandejaCotizacionesFDN.NUEVACOTIZACION));
    }

}
