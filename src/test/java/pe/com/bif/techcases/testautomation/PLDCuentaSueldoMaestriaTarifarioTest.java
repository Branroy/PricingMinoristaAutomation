package pe.com.bif.techcases.testautomation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pe.com.bif.techcases.testautomation.ui.actors.BaseConf;
import pe.com.bif.techcases.testautomation.ui.tasks.BandejaCotizacionesFDNActions;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginActions;
import pe.com.bif.techcases.testautomation.ui.tasks.NavigateTo;
import pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoActions;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/testdata/PLDCuentaSueldoMaestriaTarifario.csv")
public class PLDCuentaSueldoMaestriaTarifarioTest extends BaseConf {
    private String usuario;
    private String password;
    private String nrodocumento;

    private String producto;
    private String escliente;
    private String requieresustento;

    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioCuentaSueldoMaestria() {

        actor.attemptsTo(
                LoginActions.usuario(usuario),
                LoginActions.password(password),
                LoginActions.entrar(),
                BandejaCotizacionesFDNActions.nuevacotizacion(),
                SolicitudNuevoActions.nrodocumento(nrodocumento),
                SolicitudNuevoActions.buscarcliente(),
                SolicitudNuevoActions.nombrecliente(escliente),
                SolicitudNuevoActions.macroproducto("PLD"),
                SolicitudNuevoActions.producto(producto),
                SolicitudNuevoActions.modalidad("NUEVO"),
                SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                SolicitudNuevoActions.relacionlaboral("MIXTA"),
                SolicitudNuevoActions.ingresonetoconsustento(1300.00,requieresustento),
                SolicitudNuevoActions.importe("USD"),
                SolicitudNuevoActions.montooperacion("60000.00"),
                SolicitudNuevoActions.garantia("SIN GARANTIA"),
                SolicitudNuevoActions.plazo("MES"),
                SolicitudNuevoActions.nroplazo("22"),
                SolicitudNuevoActions.opencalendar(),
                SolicitudNuevoActions.nextmonthcalendar(),
                SolicitudNuevoActions.okcalendar(),
                SolicitudNuevoActions.calculartasa()
                    /*SolicitudNuevoActions.guardaroperacion(),
                    SolicitudNuevoActions.confirmaroperacion()*/
        );

    }
}
