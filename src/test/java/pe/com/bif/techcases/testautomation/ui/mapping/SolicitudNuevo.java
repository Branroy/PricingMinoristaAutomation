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

    public static final Target PLANAHORRO = Target
            .the("planahorro")
            .located(By.xpath("//*[@id=\"dvPlanAhorro\"]/div/div/div/div/label[1]"));

    //TIPO DE INGRESO DEL CLIENTE:
    public static final Target TIPOINGRESO = Target
            .the("tipoingreso")
            .located(By.xpath("//*[@id=\"cboTipoIngreso\"]"));

    public static final Target RELACIONLABORAL = Target
            .the("relacionlaboral")
            .located(By.xpath("//*[@id=\"cboTipoRelacionLaboral\"]"));

    public static final Target INGRESONETO = Target
            .the("ingresoneto")
            .located(By.xpath("//*[@id=\"txtIngresoEstimado\"]"));

    public static final Target INGRESONETOCODEUDOR = Target
            .the("ingresonetocodeudor")
            .located(By.xpath("//*[@id=\"txtIngresoCodeudor\"]"));

    //DATOS DEL BIEN -- HIPOTECARIO

    public static final Target NROVIVIENDA = Target
            .the("nrovivienda")
            .located(By.xpath("//*[@id=\"cboNroVivienda\"]"));

    public static final Target TIPOBIEN = Target
            .the("tipobien")
            .located(By.xpath("//*[@id=\"cboTipoBien\"]"));

    public static final Target PROYECTOBANCO = Target
            .the("proyectobanco")
            .located(By.xpath("//*[@id=\"dvProyectoBanco\"]/div/div/div/div/label[1]"));

    public static final Target NOMBREPROYECTO = Target
            .the("nombreproyecto")
            .located(By.xpath("//*[@id=\"cboNombreProyecto\"]"));

    public static final Target PRECIOINMUEBLE = Target
            .the("precioinmueble")
            .located(By.xpath("//*[@id=\"cboPVInmueble\"]"));

    public static final Target MONTOPRECIOINMUEBLE = Target
            .the("montoprecioinmueble")
            .located(By.xpath("//*[@id=\"txtPrecioVenta\"]"));

    //DATOS DEL BIEN -- VEHICULAR

    public static final Target CONCESIONARIO = Target
            .the("concesionario")
            .located(By.xpath("//*[@id=\"cboConcesionario\"]"));

    public static final Target MARCA = Target
            .the("marca")
            .located(By.xpath("//*[@id=\"cboMarca\"]"));

    public static final Target MODELO = Target
            .the("modelo")
            .located(By.xpath("//*[@id=\"txtModelo\"]"));

    public static final Target PRECIOVEHICULO = Target
            .the("preciovehiculo")
            .located(By.xpath("//*[@id=\"cboPVVehiculo\"]"));

    public static final Target MONTOPRECIOVEHICULO = Target
            .the("montopreciovehiculo")
            .located(By.xpath("//*[@id=\"txtPrecioVentaVehiculo\"]"));

    public static final Target COMISION = Target
            .the("comision")
            .located(By.xpath("//*[@id=\"cboComisionPara\"]"));

    public static final Target TASACOMISION = Target
            .the("tasacomision")
            .located(By.xpath("//*[@id=\"txtComision\"]"));

    public static final Target CLASIFICACION = Target
            .the("clasificacion")
            .located(By.xpath("//*[@id=\"cboClasificacioncliente\"]"));

    //DATOS ADICIONALES DEL PRODUCTO - COMPRA DEUDA:

    public static final Target ENTIDAD1 = Target
            .the("entidad1")
            .located(By.xpath("//*[@id=\"cboEntidadDatosA_1\"]"));
    public static final Target ENTIDAD2 = Target
            .the("entidad2")
            .located(By.xpath("//*[@id=\"cboEntidadDatosA_2\"]"));
    public static final Target ENTIDAD3 = Target
            .the("entidad3")
            .located(By.xpath("//*[@id=\"cboEntidadDatosA_3\"]"));

    public static final Target PRODUCTOCOMPRAR1 = Target
            .the("productocomprar1")
            .located(By.xpath("//*[@id=\"cboProductocomprarDatosA_1\"]"));
    public static final Target PRODUCTOCOMPRAR2 = Target
            .the("productocomprar2")
            .located(By.xpath("//*[@id=\"cboProductocomprarDatosA_2\"]"));
    public static final Target PRODUCTOCOMPRAR3 = Target
            .the("productocomprar3")
            .located(By.xpath("//*[@id=\"cboProductocomprarDatosA_3\"]"));

    public static final Target DIVISAPRODUCTO1 = Target
            .the("divisaproducto1")
            .located(By.xpath("//*[@id=\"cboDivisaproductoDatosA_1\"]"));
    public static final Target DIVISAPRODUCTO2 = Target
            .the("divisaproducto2")
            .located(By.xpath("//*[@id=\"cboDivisaproductoDatosA_2\"]"));
    public static final Target DIVISAPRODUCTO3 = Target
            .the("divisaproducto3")
            .located(By.xpath("//*[@id=\"cboDivisaproductoDatosA_3\"]"));

    public static final Target IMPORTECOMPRAR1 = Target
            .the("importecomprar1")
            .located(By.xpath("//*[@id=\"txtMontocomprarDatosA_1\"]"));
    public static final Target IMPORTECOMPRAR2 = Target
            .the("importecomprar2")
            .located(By.xpath("//*[@id=\"txtMontocomprarDatosA_2\"]"));
    public static final Target IMPORTECOMPRAR3 = Target
            .the("importecomprar3")
            .located(By.xpath("//*[@id=\"txtMontocomprarDatosA_3\"]"));

    public static final Target IMPORTEADICIONALLIBRE1 = Target
            .the("importeadicionallibre1")
            .located(By.xpath("//*[@id=\"txtMontoadicionallibreDatosA_1\"]"));
    public static final Target IMPORTEADICIONALLIBRE2 = Target
            .the("importeadicionallibre2")
            .located(By.xpath("//*[@id=\"txtMontoadicionallibreDatosA_2\"]"));
    public static final Target IMPORTEADICIONALLIBRE3 = Target
            .the("importeadicionallibre3")
            .located(By.xpath("//*[@id=\"txtMontoadicionallibreDatosA_3\"]"));

    public static final Target TEA1 = Target
            .the("tea1")
            .located(By.xpath("//*[@id=\"txtTasaDatosA_1\"]"));
    public static final Target TEA2 = Target
            .the("tea2")
            .located(By.xpath("//*[@id=\"txtTasaDatosA_2\"]"));
    public static final Target TEA3 = Target
            .the("tea3")
            .located(By.xpath("//*[@id=\"txtTasaDatosA_3\"]"));

    public static final Target TASAADICIONALLIBRE = Target
            .the("tasaadicionallibre")
            .located(By.xpath("//*[@id=\"dvTasaAdicionalLibre\"]/div/i"));

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
