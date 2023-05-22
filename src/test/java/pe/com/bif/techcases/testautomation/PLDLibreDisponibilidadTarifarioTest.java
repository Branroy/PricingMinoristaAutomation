package pe.com.bif.techcases.testautomation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pe.com.bif.techcases.testautomation.ui.actors.BaseConf;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;
import pe.com.bif.techcases.testautomation.ui.tasks.BandejaCotizacionesFDNActions;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginActions;
import pe.com.bif.techcases.testautomation.ui.tasks.NavigateTo;
import pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoActions;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/testdata/PLDLibreDisponibilidadTarifario.csv")
public class PLDLibreDisponibilidadTarifarioTest extends BaseConf {

    private String usuario;
    private String password;
    private String nrodocumento;
    private String modalidad;
    private String nropagare;
    private String escliente;
    private String requieresustento;

    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioPLD() {

            actor.attemptsTo(
                    LoginActions.usuario(usuario),
                    LoginActions.password(password),
                    LoginActions.entrar(),
                    BandejaCotizacionesFDNActions.nuevacotizacion(),
                    SolicitudNuevoActions.nrodocumento(nrodocumento),
                    SolicitudNuevoActions.buscarcliente(),
                    SolicitudNuevoActions.nombrecliente(escliente),
                    SolicitudNuevoActions.macroproducto("PLD"),
                    SolicitudNuevoActions.producto("PTMO. LIBRE DISPONIBILIDAD"),
                    SolicitudNuevoActions.modalidad(modalidad),
                    SolicitudNuevoActions.nropagare(nropagare,modalidad),
                    SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                    SolicitudNuevoActions.relacionlaboral("MIXTA"),
                    SolicitudNuevoActions.ingresoneto(2000.00,requieresustento),
                    SolicitudNuevoActions.importe("PEN"),
                    SolicitudNuevoActions.montooperacion("30000.00"),
                    SolicitudNuevoActions.garantia("SIN GARANTIA"),
                    SolicitudNuevoActions.plazo("AÑO"),
                    SolicitudNuevoActions.nroplazo("3"),
                    SolicitudNuevoActions.opencalendar(),
                    SolicitudNuevoActions.nextmonthcalendar(),
                    SolicitudNuevoActions.okcalendar(),
                    SolicitudNuevoActions.calculartasa()
                    /*SolicitudNuevoActions.guardaroperacion(),
                    SolicitudNuevoActions.confirmaroperacion()*/
            );

        }

}
