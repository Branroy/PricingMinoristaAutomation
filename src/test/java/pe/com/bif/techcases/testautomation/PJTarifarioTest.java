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
@UseTestDataFrom(value="src/test/resources/testdata/PJTarifario.csv")
public class PJTarifarioTest extends BaseConf {
    private String usuario;
    private String password;
    private String nrodocumento;
    private String escliente;
    private String producto;
    private String modalidad;
    private String amortizacion;
    private String tipodesembolso;


    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioHIPOTECARIO() {

        actor.attemptsTo(
                LoginActions.usuario(usuario),
                LoginActions.password(password),
                LoginActions.entrar(),
                BandejaCotizacionesFDNActions.nuevacotizacion(),
                SolicitudNuevoActions.tipodocumento("RUC"),
                SolicitudNuevoActions.nrodocumento(nrodocumento),
                SolicitudNuevoActions.buscarcliente(),
                SolicitudNuevoActions.nombrecliente(escliente),
                SolicitudNuevoActions.macroproducto(producto),
                SolicitudNuevoActions.producto(producto),
                SolicitudNuevoActions.modalidad(modalidad),
                SolicitudNuevoActions.amortizacion(amortizacion),
                SolicitudNuevoActions.tipodesembolso(tipodesembolso,modalidad),
                SolicitudNuevoActions.importe("USD"),
                SolicitudNuevoActions.montooperacion("1500000.00"),
                SolicitudNuevoActions.garantia("OTRAS GARANTIAS"),
                SolicitudNuevoActions.plazo("AÑO"),
                SolicitudNuevoActions.nroplazo("1"),
                SolicitudNuevoActions.calculartasa(),
                SolicitudNuevoActions.guardaroperacion(),
                SolicitudNuevoActions.confirmaroperacion()
        );

    }
}

