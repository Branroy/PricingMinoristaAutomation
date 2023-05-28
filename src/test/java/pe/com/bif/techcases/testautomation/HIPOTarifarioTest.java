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

import java.beans.Visibility;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/testdata/HIPOTarifario.csv")
public class HIPOTarifarioTest extends BaseConf {
    private String usuario;
    private String password;
    private String nrodocumento;
    private String modalidad;
    private String producto;
    private String escliente;
    private String codeudor;
    private String planahorro;
    private String proyectobanco;


    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioHIPOTECARIO() {

        actor.attemptsTo(
                LoginActions.usuario(usuario),
                LoginActions.password(password),
                LoginActions.entrar(),
                BandejaCotizacionesFDNActions.nuevacotizacion(),
                SolicitudNuevoActions.nrodocumento(nrodocumento),
                SolicitudNuevoActions.buscarcliente(),
                SolicitudNuevoActions.nombrecliente(escliente),
                SolicitudNuevoActions.macroproducto("HIPOTECARIO"),
                SolicitudNuevoActions.producto(producto),
                SolicitudNuevoActions.modalidad(modalidad),
                SolicitudNuevoActions.planahorro(planahorro),
                SolicitudNuevoActions.tipoingresocodeudor(codeudor),
                SolicitudNuevoActions.relacionlaboral("MIXTA"),
                SolicitudNuevoActions.ingresonetosinsustento("15000.00"),
                SolicitudNuevoActions.ingresonetoscodeudor("2300"),
                SolicitudNuevoActions.precioinmueble("USD"),
                SolicitudNuevoActions.montoprecioinmueble("200000.00"),
                SolicitudNuevoActions.importe("USD"),
                SolicitudNuevoActions.montooperacion("100000.00"),
                SolicitudNuevoActions.nrovivienda("SEGUNDA A MAS"),
                SolicitudNuevoActions.tipobien("BIEN FUTURO"),
                SolicitudNuevoActions.proyectobanco(proyectobanco,producto),

                SolicitudNuevoActions.nombreproyecto("ALERIA - GRUPO DEGOL SAC"),
                SolicitudNuevoActions.garantia("GARANTIA INMOBILIARIA"),
                SolicitudNuevoActions.plazo("AÑO"),
                SolicitudNuevoActions.nroplazo("12"),
                SolicitudNuevoActions.opencalendar(),
                SolicitudNuevoActions.nextmonthcalendar(),
                SolicitudNuevoActions.okcalendar(),
                SolicitudNuevoActions.calculartasa(),
                SolicitudNuevoActions.guardaroperacion(),
                SolicitudNuevoActions.confirmaroperacion()
        );

    }
}
