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
@UseTestDataFrom(value="src/test/resources/testdata/VEHITarifario.csv")
public class VEHITarifarioTest extends BaseConf {
    private String usuario;
    private String password;
    private String nrodocumento;
    private String escliente;
    private String modalidad;
    private String requieresustento;
    private String comision;
    private String clasificacion;
    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioVEHICULAR() {

        actor.attemptsTo(
                LoginActions.usuario(usuario),
                LoginActions.password(password),
                LoginActions.entrar(),
                BandejaCotizacionesFDNActions.nuevacotizacion(),
                SolicitudNuevoActions.nrodocumento(nrodocumento),
                SolicitudNuevoActions.buscarcliente(),
                SolicitudNuevoActions.nombrecliente(escliente),
                SolicitudNuevoActions.macroproducto("VEHICULAR"),
                SolicitudNuevoActions.producto("PTMO. VEHICULAR"),
                SolicitudNuevoActions.modalidad(modalidad),
                SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                SolicitudNuevoActions.relacionlaboral("INDEPENDIENTE"),
                SolicitudNuevoActions.ingresonetoconsustento(15000.00,requieresustento),
                SolicitudNuevoActions.preciovehiculo("PEN"),
                SolicitudNuevoActions.montopreciovehiculo("100000.00"),
                SolicitudNuevoActions.importe("PEN"),
                SolicitudNuevoActions.montooperacion("80000.00"),
                SolicitudNuevoActions.concesionario("INCHCAPE LATAM PERU SA"),
                SolicitudNuevoActions.marca("RAM"),
                SolicitudNuevoActions.modelo("MODELOTEST"),
                SolicitudNuevoActions.comision(comision),
                SolicitudNuevoActions.tasacomision("2.00"),
                SolicitudNuevoActions.clasificacion(clasificacion,comision),
                SolicitudNuevoActions.garantia("GARANTIA MOBILIARIA"),
                SolicitudNuevoActions.plazo("AÑO"),
                SolicitudNuevoActions.nroplazo("5"),
                SolicitudNuevoActions.opencalendar(),
                SolicitudNuevoActions.nextmonthcalendar(),
                SolicitudNuevoActions.okcalendar(),
                SolicitudNuevoActions.calculartasa(),
                SolicitudNuevoActions.guardaroperacion(),
                SolicitudNuevoActions.confirmaroperacion()
        );

    }
}
