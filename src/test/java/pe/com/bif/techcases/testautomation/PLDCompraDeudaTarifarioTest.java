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
@UseTestDataFrom(value="src/test/resources/testdata/PLDCompraDeudaTarifario.csv")
public class PLDCompraDeudaTarifarioTest extends BaseConf {
    private String usuario;
    private String password;
    private String nrodocumento;
    private String modalidad;
    private String escliente;
    private String requieresustento;
    private String productoadicional;

    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage()); }

    @Test
    public void CotizacionTarifarioCompraDeuda() {

        actor.attemptsTo(
                LoginActions.usuario(usuario),
                LoginActions.password(password),
                LoginActions.entrar(),
                BandejaCotizacionesFDNActions.nuevacotizacion(),
                SolicitudNuevoActions.nrodocumento(nrodocumento),
                SolicitudNuevoActions.buscarcliente(),
                SolicitudNuevoActions.nombrecliente(escliente),
                SolicitudNuevoActions.macroproducto("PLD"),
                SolicitudNuevoActions.producto("PTMO. COMPRA DEUDA"),
                SolicitudNuevoActions.modalidad(modalidad),
                SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                SolicitudNuevoActions.relacionlaboral("INDEPENDIENTE"),
                SolicitudNuevoActions.ingresonetoconsustento(1300.00,requieresustento),
                SolicitudNuevoActions.tasaadicionallibre(productoadicional),

                SolicitudNuevoActions.entidad1("BCP",productoadicional),
                SolicitudNuevoActions.productocomprar1("PLD",productoadicional),
                SolicitudNuevoActions.divisaproducto1("USD",productoadicional),
                SolicitudNuevoActions.importecomprar1("1000.10",productoadicional),
                SolicitudNuevoActions.importeadicionallibre1("10.01",productoadicional),
                SolicitudNuevoActions.tea1("11.10",productoadicional),

                SolicitudNuevoActions.entidad2("INTERBANK",productoadicional),
                SolicitudNuevoActions.productocomprar2("TC",productoadicional),
                SolicitudNuevoActions.divisaproducto2("PEN",productoadicional),
                SolicitudNuevoActions.importecomprar2("2000.02",productoadicional),
                SolicitudNuevoActions.importeadicionallibre2("20.20",productoadicional),
                SolicitudNuevoActions.tea2("22.22",productoadicional),

                SolicitudNuevoActions.entidad3("BBVA",productoadicional),
                SolicitudNuevoActions.productocomprar3("AMBOS",productoadicional),
                SolicitudNuevoActions.divisaproducto3("USD",productoadicional),
                SolicitudNuevoActions.importecomprar3("3000.30",productoadicional),
                SolicitudNuevoActions.importeadicionallibre3("30.03",productoadicional),
                SolicitudNuevoActions.tea3("33.33",productoadicional),
                SolicitudNuevoActions.importe("USD"),
                SolicitudNuevoActions.garantia("SIN GARANTIA"),
                SolicitudNuevoActions.plazo("MES"),
                SolicitudNuevoActions.nroplazo("10"),
                SolicitudNuevoActions.opencalendar(),
                SolicitudNuevoActions.nextmonthcalendar(),
                SolicitudNuevoActions.okcalendar(),
                SolicitudNuevoActions.calculartasa()
                /*    SolicitudNuevoActions.guardaroperacion(),
                    SolicitudNuevoActions.confirmaroperacion()*/
        );

    }
}

