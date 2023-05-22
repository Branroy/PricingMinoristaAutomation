package pe.com.bif.techcases.testautomation.ui.mapping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SolicitudNuevo {

    //INGRESO DE DATOS
    //1. DATOS DEL CLIENTE
    public static final Target NRODOCUMENTO = Target
            .the("nrodocumento")
            .located(By.xpath("//*[@id=\"txtNroDocumento\"]"));

    public static final Target BUSCARCLIENTE = Target
            .the("buscarcliente")
            .located(By.xpath("//*[@id=\"pnlDatosCliente\"]/div/div/div/div[4]/div"));
    //// //*[@id="btnBuscarCliente"] //*[@id="pnlDatosCliente"]/div/div/div/div[4]/div *[@id="btn"]/i

    public static final Target NOMBRECLIENTE = Target
            .the("nombrecliente")
            .located(By.xpath("//*[@id=\"txtNombre\"]"));

    //2. DATOS DEL PRODUCTO

    public static final Target MACROPRODUCTO = Target
            .the("macroproducto")
            .located(By.xpath("//*[@id=\"cboTipoProducto\"]"));

    public static final Target PRODUCTO = Target
            .the("producto")
            .located(By.xpath("//*[@id=\"cboProducto\"]"));

    public static final Target NROPAGARE = Target
            .the("nropagare")
            .located(By.xpath("//*[@id=\"txtNroPagarePLD\"]"));

    public static final Target MODALIDAD = Target
            .the("modalidad")
            .located(By.xpath("//*[@id=\"cboModalidad\"]"));

    public static final Target TIPOINGRESO = Target
            .the("tipoingreso")
            .located(By.xpath("//*[@id=\"cboTipoIngreso\"]"));

    public static final Target RELACIONLABORAL = Target
            .the("relacionlaboral")
            .located(By.xpath("//*[@id=\"cboTipoRelacionLaboral\"]"));

    public static final Target INGRESONETO = Target
            .the("ingresoneto")
            .located(By.xpath("//*[@id=\"txtIngresoEstimado\"]"));

    //3. DATOS DEL PRESTAMO

    public static final Target IMPORTE = Target
            .the("importe")
            .located(By.xpath("//*[@id=\"cboMonedaOperacion\"]"));

    public static final Target MONTOOPERACION = Target
            .the("montooperacion")
            .located(By.xpath("//*[@id=\"txtMontoOperacion\"]"));

    public static final Target GARANTIA = Target
            .the("garantia")
            .located(By.xpath("//*[@id=\"cboGarantia\"]"));

    public static final Target PLAZO = Target
            .the("plazo")
            .located(By.xpath("//*[@id=\"cboPlazo\"]"));

    public static final Target NROPLAZO = Target
            .the("nroplazo")
            .located(By.xpath("//*[@id=\"txtPlazo\"]"));

    //FECHA PRIMERA CUOTA
    public static final Target OPENCALENDAR = Target
            .the("opencalendar")
            .located(By.xpath("//*[@id=\"txtFechaPrimeraC\"]"));

    public static final Target NEXTMONTHCALENDAR = Target
            .the("nextmonthcalendar")
            .located(By.xpath("/html/body/div[15]/div/div[1]/div[1]/div[1]/div[3]"));

    public static final Target OKCALENDAR = Target
            .the("okcalendar")
            .located(By.xpath("/html/body/div[15]/div/div[2]/button[4]"));

    //4. TASAS SUGERIDAS
    public static final Target CALCULARTASA = Target
            .the("calculartasa")
            .located(By.xpath("//*[@id=\"btnCalcularTasa\"]"));

    public static final Target GUARDAROPERACION = Target
            .the("guardaroperacion")
            .located(By.xpath("//*[@id=\"btnGuardarOperacion\"]"));

    //VALIDACIONES, LOADERS Y CONFIRMACIONES -----------------------------------------------------------------
    //1. DATOS DEL CLIENTE
    public static final Target LOADER = Target
            .the("lodear")
            .located(By.xpath("//*[@id=\"loader\"]"));

    public static final Target INGRESENOMBRECLIENTE = Target
            .the("ingresenombrecliente")
            .located(By.xpath("//*[@id=\"swal2-content\"]"));

    public static final Target CONFIRMARALERTACLIENTE = Target
            .the("confirmaralertacliente")
            .located(By.xpath("/html/body/div[16]/div/div[3]/button[1]"));


    //4. TASAS SUGERIDAS

    public static final Target CONFIRMAROPERACION = Target
            .the("confirmaroperacion")
            .located(By.xpath("/html/body/div[16]/div/div[3]/button[2]"));

    public static final Target OPERACIONEXISTO = Target
            .the("operacionexisto")
            .located(By.xpath("//*[@id=\"swal2-content\"]"));



}
