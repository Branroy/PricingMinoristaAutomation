package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import pe.com.bif.techcases.testautomation.ui.mapping.BandejaCotizacionesFDN;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SolicitudNuevoActions {


    public static Performable tipodocumento(String tipodocumento) {
        return Task.where("{0} select tipo producto '" + tipodocumento + "'",
                WaitUntil.the(SolicitudNuevo.TIPODOCUMENTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(tipodocumento).from(SolicitudNuevo.TIPODOCUMENTO));
    }
    public static Performable nrodocumento(String nrodocumento) {
        return Task.where("{0} enters nro documento '" + nrodocumento + "'",
                Clear.field(SolicitudNuevo.NRODOCUMENTO),
                Enter.theValue(nrodocumento).into(SolicitudNuevo.NRODOCUMENTO));
    }

    public static Performable nombrecliente(String escliente) {

        if("NO".equalsIgnoreCase(escliente)){
            return Task.where("{0} enters nombre cliente CLIENTE TEST AUTOMATIZADO",
                    WaitUntil.the(SolicitudNuevo.CONFIRMARALERTACLIENTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Click.on(SolicitudNuevo.CONFIRMARALERTACLIENTE),
                    WaitUntil.the(SolicitudNuevo.NOMBRECLIENTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Clear.field(SolicitudNuevo.NOMBRECLIENTE),
                    Enter.theValue("CLIENTE TEST AUTOMATIZADO").into(SolicitudNuevo.NOMBRECLIENTE));

        }else {
            return Task.where("{0} no aplica ingreso de nombre cliente");
        }

    }

    public static Performable buscarcliente() {
        return Task.where("{0} click on buscar cliente",
                Click.on(SolicitudNuevo.BUSCARCLIENTE));
    }

    public static Performable macroproducto(String macroproducto) {
        return Task.where("{0} select macroproducto '" + macroproducto + "'",
                WaitUntil.the(SolicitudNuevo.MACROPRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(macroproducto).from(SolicitudNuevo.MACROPRODUCTO));
    }

    public static Performable producto(String producto) {
        return Task.where("{0} select producto '" + producto + "'",
                WaitUntil.the(SolicitudNuevo.PRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(producto).from(SolicitudNuevo.PRODUCTO));
    }

    public static Performable modalidad(String modalidad) {
        return Task.where("{0} select modalidad '" + modalidad + "'",
                WaitUntil.the(SolicitudNuevo.MODALIDAD, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(modalidad).from(SolicitudNuevo.MODALIDAD));
    }

    // DATOS DEL BIEN: Hipotecario
    public static Performable nrovivienda(String nrovivienda) {
        return Task.where("{0} select nro vivienda '" + nrovivienda + "'",
                WaitUntil.the(SolicitudNuevo.NROVIVIENDA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(nrovivienda).from(SolicitudNuevo.NROVIVIENDA));
    }


    public static Performable tipobien(String tipobien) {
        return Task.where("{0} select tipo de bien '" + tipobien + "'",
                WaitUntil.the(SolicitudNuevo.TIPOBIEN, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(tipobien).from(SolicitudNuevo.TIPOBIEN));
    }

    public static Performable planahorro(String planahorro) {
        if ("SI".equalsIgnoreCase(planahorro))
        return Task.where("{0} select planahorro SI",
                WaitUntil.the(SolicitudNuevo.PLANAHORRO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                JavaScriptClick.on(SolicitudNuevo.PLANAHORRO));
        else{
            return Task.where("{0} select planahorro NO");
        }
    }

    public static Performable nombreproyecto(String nombreproyecto) {
        return Task.where("{0} select nombre del proyecto '" + nombreproyecto + "'",
                WaitUntil.the(SolicitudNuevo.NOMBREPROYECTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(nombreproyecto).from(SolicitudNuevo.NOMBREPROYECTO));
    }

    public static Performable precioinmueble(String precioinmueble) {
        return Task.where("{0} select moneda venta del inmueble '" + precioinmueble + "'",
                WaitUntil.the(SolicitudNuevo.PRECIOINMUEBLE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(precioinmueble).from(SolicitudNuevo.PRECIOINMUEBLE));
    }

    public static Performable montoprecioinmueble(String montoprecioinmueble) {

        return Task.where("{0} enters monto precio venta del inmueble '" + montoprecioinmueble + "'",
                Clear.field(SolicitudNuevo.MONTOPRECIOINMUEBLE),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOPRECIOINMUEBLE),
                Enter.theValue(montoprecioinmueble).into(SolicitudNuevo.MONTOPRECIOINMUEBLE));
    }
    // PAGARE COMERCIAL, LEASING, COMEX
    public static Performable amortizacion(String amotizacion) {
        if ("SI".equalsIgnoreCase(amotizacion))
            return Task.where("{0} select amortización SI",
                    WaitUntil.the(SolicitudNuevo.AMORTIZACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.AMORTIZACION));
        else{
            return Task.where("{0} select amortizacion NO");
        }
    }
    public static Performable tipodesembolso(String tipodesembolso,String modalidad) {
        if ("SI".equalsIgnoreCase(tipodesembolso) && "LINEA".equalsIgnoreCase(modalidad)){
            return Task.where("{0} select tipo desembolso SI",
                    WaitUntil.the(SolicitudNuevo.TIPODESEMBOLSO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.TIPODESEMBOLSO));

        }else if ("NO".equalsIgnoreCase(tipodesembolso) && "LINEA".equalsIgnoreCase(modalidad)){
            return Task.where("{0} select tipo desembolso NO");

        }else{
            return Task.where("{0} select tipo desembolso no aplica");
        }
    }


    public static Performable nropagare(String nropagare,String modalidad) {
        if("REENGANCHE".equalsIgnoreCase(modalidad)){
            return Task.where("{0} select nro pagare '" + nropagare + "'",
                    Clear.field(SolicitudNuevo.NROPAGARE),
                    Enter.theValue(nropagare).into(SolicitudNuevo.NROPAGARE));
        }else {
            return Task.where("{0} no aplica ingreso de nro pagare");
        }
    }

    public static Performable tipoingreso(String tipoingreso) {
        return Task.where("{0} select tipo de ingreso '" + tipoingreso + "'",
                WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(tipoingreso).from(SolicitudNuevo.TIPOINGRESO));
    }

    public static Performable tipoingresocodeudor(String codeudor) {
        if ("SI".equalsIgnoreCase(codeudor)){
        return Task.where("{0} select tipo de ingreso codeudor",
                WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option("INGRESO CODEUDOR").from(SolicitudNuevo.TIPOINGRESO));
        }else {
            return Task.where("{0} select tipo de ingreso individual",
                    WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option("INGRESO INDIVIDUAL").from(SolicitudNuevo.TIPOINGRESO));
        }

    }


    public static Performable relacionlaboral(String relacionlaboral) {
        return Task.where("{0} select tipo relacion laboral '" + relacionlaboral + "'",
                WaitUntil.the(SolicitudNuevo.RELACIONLABORAL, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(relacionlaboral).from(SolicitudNuevo.RELACIONLABORAL));
    }


    public static Performable ingresonetoconsustento(double ingresoneto,String requieresustento) {

        if ("NO".equalsIgnoreCase(requieresustento)){
            double min = Math.ceil(1);
            double max = Math.floor(ingresoneto);
            double r = Math.floor(Math.random() * (max - min + 1) + min);
            String result = String.valueOf(r);
        return Task.where("{0} enters ingreso titular neto '" + result + "'",
                Clear.field(SolicitudNuevo.INGRESONETO),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETO),
                Enter.theValue(result).into(SolicitudNuevo.INGRESONETO));
        } else {
            double min = Math.ceil(ingresoneto);
            double max = Math.floor(999999);
            double r = Math.floor(Math.random() * (max - min + 1) + min);
            String result = String.valueOf(r);
            return Task.where("{0} enters ingreso titular neto '" + result + "'",
                    Clear.field(SolicitudNuevo.INGRESONETO),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETO),
                    Enter.theValue(result).into(SolicitudNuevo.INGRESONETO));
        }
    }

    public static Performable ingresonetosinsustento(String ingresoneto) {

            return Task.where("{0} enters ingreso titular neto '" + ingresoneto + "'",
                    Clear.field(SolicitudNuevo.INGRESONETO),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETO),
                    Enter.theValue(ingresoneto).into(SolicitudNuevo.INGRESONETO));
    }

    public static Performable ingresonetoscodeudor(String ingresonetocodeudor) {

        return Task.where("{0} enters ingreso titular neto '" + ingresonetocodeudor + "'",
                Clear.field(SolicitudNuevo.INGRESONETOCODEUDOR),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.INGRESONETOCODEUDOR),
                Enter.theValue(ingresonetocodeudor).into(SolicitudNuevo.INGRESONETOCODEUDOR));
    }


    public static Performable proyectobanco(String proyectobanco, String producto) {
        if ("CREDITO TECHO PROPIO".equalsIgnoreCase(producto))
            return Task.where("{0} select proyectobanco SI");
        else if("SI".equalsIgnoreCase(proyectobanco)){
            return Task.where("{0} select proyectobanco SI",
                    WaitUntil.the(SolicitudNuevo.PROYECTOBANCO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.PROYECTOBANCO));
        }else{
            return Task.where("{0} select proyectobanco NO");
        }
    }
    //DATOS DEL BIEN: VEHICULAR
    public static Performable concesionario(String concesionario) {

        return Task.where("{0} select concesionario '" + concesionario + "'",
                WaitUntil.the(SolicitudNuevo.CONCESIONARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(concesionario).from(SolicitudNuevo.CONCESIONARIO));
    }

    public static Performable marca(String marca) {
        return Task.where("{0} select marca '" + marca + "'",
                WaitUntil.the(SolicitudNuevo.MARCA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(marca).from(SolicitudNuevo.MARCA));
    }

    public static Performable modelo(String modelo) {

        return Task.where("{0} enters modelo '" + modelo + "'",
                Clear.field(SolicitudNuevo.MODELO),
                Enter.theValue(modelo).into(SolicitudNuevo.MODELO));
    }

    public static Performable preciovehiculo(String preciovehiculo) {
        return Task.where("{0} select moenda venta del vehiculo '" + preciovehiculo + "'",
                WaitUntil.the(SolicitudNuevo.PRECIOVEHICULO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(preciovehiculo).from(SolicitudNuevo.PRECIOVEHICULO));
    }

    public static Performable montopreciovehiculo(String montopreciovehiculo) {
        return Task.where("{0} enters monto precio del vehiculo '" + montopreciovehiculo + "'",
                Clear.field(SolicitudNuevo.MONTOPRECIOVEHICULO),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOPRECIOVEHICULO),
                Enter.theValue(montopreciovehiculo).into(SolicitudNuevo.MONTOPRECIOVEHICULO));
    }

    public static Performable comision(String comision) {
        return Task.where("{0} select comisión para '" + comision + "'",
                WaitUntil.the(SolicitudNuevo.COMISION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(comision).from(SolicitudNuevo.COMISION));
    }

    public static Performable tasacomision(String tasacomision) {
        return Task.where("{0} enters % comisión '" + tasacomision + "'",
                Clear.field(SolicitudNuevo.TASACOMISION),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TASACOMISION),
                Enter.theValue(tasacomision).into(SolicitudNuevo.TASACOMISION));
    }

    public static Performable clasificacion(String clasificacion,String comision) {
        if ("AMICAR".equalsIgnoreCase(comision)){
            return Task.where("{0} select comisión para '" + clasificacion + "'",
                    WaitUntil.the(SolicitudNuevo.CLASIFICACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(clasificacion).from(SolicitudNuevo.CLASIFICACION));
        }
        return Task.where("{0} clasificación no aplica");
    }

    public static Performable importe(String importe) {
        return Task.where("{0} select importe '" + importe + "'",
        WaitUntil.the(SolicitudNuevo.IMPORTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(importe).from(SolicitudNuevo.IMPORTE));
    }

    public static Performable montooperacion(String montooperacion) {
        return Task.where("{0} enters monto de operacion '" + montooperacion + "'",
                Clear.field(SolicitudNuevo.MONTOOPERACION),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOOPERACION),
                Enter.theValue(montooperacion).into(SolicitudNuevo.MONTOOPERACION));

    }

    public static Performable garantia(String garantia) {
        return Task.where("{0} select garantia '" + garantia + "'",
                WaitUntil.the(SolicitudNuevo.IMPORTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(garantia).from(SolicitudNuevo.GARANTIA));
    }

    public static Performable plazo(String plazo) {
        return Task.where("{0} select plazo '" + plazo + "'",
                WaitUntil.the(SolicitudNuevo.PLAZO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(plazo).from(SolicitudNuevo.PLAZO));
    }

    public static Performable nroplazo(String nroplazo) {
        return Task.where("{0} enters nroplazo '" + nroplazo + "'",
                Clear.field(SolicitudNuevo.NROPLAZO),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.NROPLAZO),
                Enter.theValue(nroplazo).into(SolicitudNuevo.NROPLAZO));
    }

    public static Performable opencalendar() {
        return Task.where("{0} click on abrir calendario",
                Click.on(SolicitudNuevo.OPENCALENDAR));
    }

    public static Performable nextmonthcalendar() {
        return Task.where("{0} click on siguiente mes calendario",
                Click.on(SolicitudNuevo.NEXTMONTHCALENDAR));
    }

    public static Performable okcalendar() {
        return Task.where("{0} click on confirmar calendario",
                Click.on(SolicitudNuevo.OKCALENDAR),
                Click.on(SolicitudNuevo.MONTOOPERACION),
                Click.on(SolicitudNuevo.FONDOTASAPRODUCTO));

    }

    public static Performable calculartasa() {
            return Task.where("{0} click on calcular tasa",
                    Click.on(SolicitudNuevo.CALCULARTASA));
    }

    public static Performable validaperfilcomercial(String validaperfilcomercial) {

        if(validaperfilcomercial.equalsIgnoreCase("SI")){
            return Task.where("{0} Validar perfil comercial",
                    Clear.field(SolicitudNuevo.MONTONIVELVENTAS),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTONIVELVENTAS),
                    Enter.theValue("1000000.00").into(SolicitudNuevo.MONTONIVELVENTAS),
                    Click.on(SolicitudNuevo.GUARDARNIVELVENTAS),
                    Click.on(SolicitudNuevo.CONFIRMARPERFILCOMERCIAL),
                    Click.on(SolicitudNuevo.OKPERFILCOMERCIAL));

        }else{
            return Task.where("{0} Validar perfil comercial no aplica");
        }

    }

    public static Performable guardaroperacion() {
        return Task.where("{0} click on guardar operacion",
                WaitUntil.the(SolicitudNuevo.GUARDAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(SolicitudNuevo.GUARDAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Click.on(SolicitudNuevo.GUARDAROPERACION));
    }

    public static Performable confirmaroperacion() {
        return Task.where("{0} click on confirmar operación",
                WaitUntil.the(SolicitudNuevo.CHECKEXISTO, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                Click.on(SolicitudNuevo.CONFIRMAROPERACION),
                WaitUntil.the(SolicitudNuevo.ACEPTARGUARDAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(SolicitudNuevo.ACEPTARGUARDAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds());

    }

    public static Performable aceptarperacion() {
        return Task.where("{0} click on aceptar operación",
                Click.on(SolicitudNuevo.ACEPTARGUARDAROPERACION),
                WaitUntil.the(SolicitudNuevo.IDCOTIZACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(SolicitudNuevo.IDCOTIZACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds());



    }

    public static Performable tasaadicionallibre(String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre) ){
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'");
        } else if ("2".equalsIgnoreCase(tasaadicionallibre)) {
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'",
                    JavaScriptClick.on(SolicitudNuevo.TASAADICIONALLIBRE));
        }else {
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'",
                    JavaScriptClick.on(SolicitudNuevo.TASAADICIONALLIBRE),
                    JavaScriptClick.on(SolicitudNuevo.TASAADICIONALLIBRE));
        }

    }

    public static Performable entidad1(String entidad1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select entidad1 '" + entidad1 + "'",
                WaitUntil.the(SolicitudNuevo.ENTIDAD1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(entidad1).from(SolicitudNuevo.ENTIDAD1));
        }else{
            return Task.where("{0} select entidad1 '" + entidad1 + "'",
                    WaitUntil.the(SolicitudNuevo.ENTIDAD1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(entidad1).from(SolicitudNuevo.ENTIDAD1));
        }

    }

    public static Performable entidad2(String entidad2,String tasaadicionallibre) {
            if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

                return Task.where("{0} select entidad2 '" + entidad2 + "'",
                        WaitUntil.the(SolicitudNuevo.ENTIDAD2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                        Select.option(entidad2).from(SolicitudNuevo.ENTIDAD2));
            }else{
                return Task.where("{0} no aplica entidad2");
            }
    }

    public static Performable entidad3(String entidad3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select entidad3 '" + entidad3 + "'",
                    WaitUntil.the(SolicitudNuevo.ENTIDAD3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(entidad3).from(SolicitudNuevo.ENTIDAD3));
        }else{
            return Task.where("{0} no aplica entidad2");
        }
    }

    public static Performable productocomprar1(String productocomprar1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar1 '" + productocomprar1 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(productocomprar1).from(SolicitudNuevo.PRODUCTOCOMPRAR1));
        }else{
            return Task.where("{0} select productocomprar1 '" + productocomprar1 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(productocomprar1).from(SolicitudNuevo.PRODUCTOCOMPRAR1));
        }

    }

    public static Performable productocomprar2(String productocomprar2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar2 '" + productocomprar2 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(productocomprar2).from(SolicitudNuevo.PRODUCTOCOMPRAR2));
        }else{
            return Task.where("{0} no aplica productocomprar2");
        }
    }

    public static Performable productocomprar3(String productocomprar3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar3 '" + productocomprar3 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(productocomprar3).from(SolicitudNuevo.PRODUCTOCOMPRAR3));
        }else{
            return Task.where("{0} no aplica productocomprar3");
        }
    }

    public static Performable divisaproducto1(String divisaproducto1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto1 '" + divisaproducto1 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(divisaproducto1).from(SolicitudNuevo.DIVISAPRODUCTO1));
        }else{
            return Task.where("{0} select divisaproducto1 '" + divisaproducto1 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(divisaproducto1).from(SolicitudNuevo.DIVISAPRODUCTO1));
        }

    }

    public static Performable divisaproducto2(String divisaproducto2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto2 '" + divisaproducto2 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(divisaproducto2).from(SolicitudNuevo.DIVISAPRODUCTO2));
        }else{
            return Task.where("{0} no aplica divisaproducto2");

        }
    }


    public static Performable divisaproducto3(String divisaproducto3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto3 '" + divisaproducto3 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(divisaproducto3).from(SolicitudNuevo.DIVISAPRODUCTO3));
        }else{
            return Task.where("{0} no aplica divisaproducto3");
        }
    }


    public static Performable importecomprar1(String importecomprar1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){
            return Task.where("{0} select importecomprar1 '" + importecomprar1 + "'",
                    Clear.field(SolicitudNuevo.IMPORTECOMPRAR1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR1),
                    Enter.theValue(importecomprar1).into(SolicitudNuevo.IMPORTECOMPRAR1));
        }else{
            return Task.where("{0} select importecomprar1 '" + importecomprar1 + "'",
                    Clear.field(SolicitudNuevo.IMPORTECOMPRAR1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR1),
                    Enter.theValue(importecomprar1).into(SolicitudNuevo.IMPORTECOMPRAR1));
        }
    }

    public static Performable importecomprar2(String importecomprar2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select importecomprar2 '" + importecomprar2 + "'",
                    Clear.field(SolicitudNuevo.IMPORTECOMPRAR2),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR2),
                    Enter.theValue(importecomprar2).into(SolicitudNuevo.IMPORTECOMPRAR2));
        }else{
            return Task.where("{0} no aplica importecomprar2");
        }
    }

    public static Performable importecomprar3(String importecomprar3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select importecomprar3 '" + importecomprar3 + "'",
                    Clear.field(SolicitudNuevo.IMPORTECOMPRAR3),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTECOMPRAR3),
                    Enter.theValue(importecomprar3).into(SolicitudNuevo.IMPORTECOMPRAR3));
        }else{
            return Task.where("{0} no aplica importecomprar3");
        }
    }

    public static Performable importeadicionallibre1(String importeadicionallibre1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){
            return Task.where("{0} select importeadicionallibre1 '" + importeadicionallibre1 + "'",
                    Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                    Enter.theValue(importeadicionallibre1).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1));
        }else{
            return Task.where("{0} select importeadicionallibre1 '" + importeadicionallibre1 + "'",
                    Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1),
                    Enter.theValue(importeadicionallibre1).into(SolicitudNuevo.IMPORTEADICIONALLIBRE1));
        }
    }

    public static Performable importeadicionallibre2(String importeadicionallibre2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select importeadicionallibre2 '" + importeadicionallibre2 + "'",
                    Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE2),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE2),
                    Enter.theValue(importeadicionallibre2).into(SolicitudNuevo.IMPORTEADICIONALLIBRE2));
        }else{
            return Task.where("{0} no aplica importeadicionallibre2");
        }
    }

    public static Performable importeadicionallibre3(String importeadicionallibre3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select importeadicionallibre3 '" + importeadicionallibre3 + "'",
                    Clear.field(SolicitudNuevo.IMPORTEADICIONALLIBRE3),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEADICIONALLIBRE3),
                    Enter.theValue(importeadicionallibre3).into(SolicitudNuevo.IMPORTEADICIONALLIBRE3));
        }else{
            return Task.where("{0} no aplica importeadicionallibre3");
        }
    }

    public static Performable tea1(String tea1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){
            return Task.where("{0} select tea1 '" + tea1 + "'",
                    Clear.field(SolicitudNuevo.TEA1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA1),
                    Enter.theValue(tea1).into(SolicitudNuevo.TEA1));
        }else{
            return Task.where("{0} select tea1 '" + tea1 + "'",
                    Clear.field(SolicitudNuevo.TEA1),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA1),
                    Enter.theValue(tea1).into(SolicitudNuevo.TEA1));
        }
    }

    public static Performable tea2(String tea2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select tea2 '" + tea2 + "'",
                    Clear.field(SolicitudNuevo.TEA2),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA2),
                    Enter.theValue(tea2).into(SolicitudNuevo.TEA2));
        }else{
            return Task.where("{0} no aplica tea2");
        }
    }

    public static Performable tea3(String tea3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select tea3 '" + tea3 + "'",
                    Clear.field(SolicitudNuevo.TEA3),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TEA3),
                    Enter.theValue(tea3).into(SolicitudNuevo.TEA3));
        }else{
            return Task.where("{0} no aplica tea3");
        }
    }

    // 6. PRODUCTOS ADICIONALES

    public static Performable seguro(String seguro,String descripcion) {
        if ("SI".equalsIgnoreCase(seguro)){

            return Task.where("{0} select seguro '" + descripcion + "'",
                    WaitUntil.the(SolicitudNuevo.SEGUROS, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(descripcion).from(SolicitudNuevo.SEGUROS));

        }else{
            return Task.where("{0} no aplica seguro");
        }
    }

    // 7. SOLICITUD DE TASA PREFERENCIAL

    public static Performable compiteentidad(String compite,String bancoof,String monedaof){
        if ("SI".equalsIgnoreCase(compite)){
            double min1 = Math.ceil(1);
            double max1 = Math.floor(99);
            double r1 = Math.floor(Math.random() * (max1 - min1 + 1) + min1);
            String tasaof = String.valueOf(r1);

            double min2 = Math.ceil(100);
            double max2 = Math.floor(1000000);
            double r2 = Math.floor(Math.random() * (max2 - min2 + 1) + min2);
            String montoof = String.valueOf(r2);

            double min3 = Math.ceil(1);
            double max3 = Math.floor(999);
            double r3 = Math.floor(Math.random() * (max3 - min3 + 1) + min3);
            String plazoof = String.valueOf(r3);

            List<String> listproductoof = new ArrayList<>(Arrays.asList("LIBRE DISPONIBILIDAD","COMPRA DEUDA","CONVENIO","CREDITO HIPOTECARIO","PRESTAMO VEHICULAR"));
            Random random = new Random();
            int index = random.nextInt(listproductoof.size());
            String productoof = listproductoof.get(index);

            String pathFile = "D:\\WorkSpaceIntellij\\PricingMinoristaAutomation\\src\\test\\resources\\archivos\\Logo.jpg";
            //Robot robot = new Robot();

            /*StringSelection stringSelection = new StringSelection(pathFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection,null);*/

            return Task.where("{0} Banco ofertante: '" + bancoof + " ,Producto ofertante: '" + productoof
                            + " ,Moneda ofertante: '" + monedaof + " ,Tasa ofertante(%): '" + tasaof
                            + " ,Monto ofertante: '" + montoof + " ,Plazo ofertante(mes): '" + plazoof + "'",
                    JavaScriptClick.on(SolicitudNuevo.COMPITEENTIDAD),
                    WaitUntil.the(SolicitudNuevo.BANCAOFERTANTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(bancoof).from(SolicitudNuevo.BANCAOFERTANTE),
                    WaitUntil.the(SolicitudNuevo.PRODUCTOOFERT, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(productoof).from(SolicitudNuevo.PRODUCTOOFERT),
                    WaitUntil.the(SolicitudNuevo.MONEDAOFERTADA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(monedaof).from(SolicitudNuevo.MONEDAOFERTADA),
                    Clear.field(SolicitudNuevo.TASAOFERTANTE),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.TASAOFERTANTE),
                    Enter.theValue(tasaof).into(SolicitudNuevo.TASAOFERTANTE),
                    Clear.field(SolicitudNuevo.MONTOOFERT),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOOFERT),
                    Enter.theValue(montoof).into(SolicitudNuevo.MONTOOFERT),
                    Clear.field(SolicitudNuevo.PLAZOOFERT),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.PLAZOOFERT),
                    Enter.theValue(plazoof).into(SolicitudNuevo.PLAZOOFERT),

                    JavaScriptClick.on(SolicitudNuevo.ADJUNTARCRONOGRAMA),
                    JavaScriptClick.on(SolicitudNuevo.AGREGARCRONOGRAMA));




        }else{
            return Task.where("{0} no aplica Compite con otra entiendad");
        }
    }

    public static Performable aceptacompiteentidad(String compite){
        if ("SI".equalsIgnoreCase(compite)){
            return Task.where("{0} confirmar Archivo Cronograma : ",
                    JavaScriptClick.on(SolicitudNuevo.CONFIRMARCRONOGRAMA),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARCRONOGRAMA));
        }else{
            return Task.where("{0} no aplica Archivo Cronograma");
        }
    }

    public static Performable compromiso(String compromiso) {
        if ("SI".equalsIgnoreCase(compromiso)){
            double min1 = Math.ceil(30);
            double max1 = Math.floor(180);
            double r1 = Math.floor(Math.random() * (max1 - min1 + 1) + min1);
            String plazomaxdias = String.valueOf(r1);

            double min2 = Math.ceil(100);
            double max2 = Math.floor(1000000);
            double r2 = Math.floor(Math.random() * (max2 - min2 + 1) + min2);
            String montovalor = String.valueOf(r2);

            List<String> listcombocompromiso = new ArrayList<>(Arrays.asList("Pago de Haberes","CTS","Tarjeta de Crédito","Depósito a Plazos"));
            List<String> listvalorcompromiso = new ArrayList<>(Arrays.asList("USD","PEN"));
            Random random = new Random();
            int index = random.nextInt(listcombocompromiso.size());
            String combocompromiso = listcombocompromiso.get(index);

            int index2 = random.nextInt(listvalorcompromiso.size());;
            String valorcompromiso = listvalorcompromiso.get(index2);

            return Task.where("{0} Compromiso: '" + combocompromiso + " ,Plazo Máx. (Días): '" + plazomaxdias
                            + " ,Valor: '" + valorcompromiso + " ,Monto: '" + montovalor+ "'",
                    JavaScriptClick.on(SolicitudNuevo.COMPROMISO),
                    JavaScriptClick.on(SolicitudNuevo.REGISTRARCOMPROMISO),
                    WaitUntil.the(SolicitudNuevo.COMBOCOMPROMISO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(combocompromiso).from(SolicitudNuevo.COMBOCOMPROMISO),
                    Clear.field(SolicitudNuevo.PLAZOMAXDIAS),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.PLAZOMAXDIAS),
                    Enter.theValue(plazomaxdias).into(SolicitudNuevo.PLAZOMAXDIAS),
                    WaitUntil.the(SolicitudNuevo.VALORCOMPROMISO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(valorcompromiso).from(SolicitudNuevo.VALORCOMPROMISO),
                    Clear.field(SolicitudNuevo.MONTOVALOR),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOVALOR),
                    Enter.theValue(montovalor).into(SolicitudNuevo.MONTOVALOR),
                    JavaScriptClick.on(SolicitudNuevo.AGREGARCOMPROMISO),
                    JavaScriptClick.on(SolicitudNuevo.CONFIRMARCOMPROMISO));
        }else{
            return Task.where("{0} no aplica Compromisos");
        }
    }
    public static Performable adjuntarsustentoingresosnetos(String requieresustento) {

        if ("SI".equalsIgnoreCase(requieresustento)){
            return Task.where("{0} adjunto sustento de ingresos netos",
                    JavaScriptClick.on(SolicitudNuevo.GENERARFICHA),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARGENERARFICHA),
                    JavaScriptClick.on(SolicitudNuevo.ADJUNTARSUSTENTO),
                    JavaScriptClick.on(SolicitudNuevo.AGREGARSUSTENTO));
        }else{
            return Task.where("{0} no aplica adjunto sustento de ingresos netos");
        }

    }
    public static Performable aceptasustentoingresosnetos(String requieresustento){
        if ("SI".equalsIgnoreCase(requieresustento)){
            return Task.where("{0} confirmar adjunto sustento ingreso netos",
                    JavaScriptClick.on(SolicitudNuevo.CONFIRMARSUSTENTO),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARSUSTENTO));
        }else{
            return Task.where("{0} no aplica adjunto sustento ingreso netos");
        }
    }

    public static Performable modificacionimporte(String modificacionimporte) {

        String importe = "100000";
        if ("SI".equalsIgnoreCase(modificacionimporte)){
            return Task.where("{0} Se modifica el importe a 100000 ",
                    WaitUntil.the(SolicitudNuevo.IMPORTEFINAL, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(SolicitudNuevo.IMPORTEFINAL, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Clear.field(SolicitudNuevo.IMPORTEFINAL),
                    Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.IMPORTEFINAL),
                    Enter.theValue(importe).into(SolicitudNuevo.IMPORTEFINAL),
                    WaitUntil.the(SolicitudNuevo.MODIFICARCONDICIONES, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(SolicitudNuevo.MODIFICARCONDICIONES, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.MODIFICARCONDICIONES),
                    WaitUntil.the(SolicitudNuevo.SIMODIFICARCONDICIONES, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(SolicitudNuevo.SIMODIFICARCONDICIONES, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.SIMODIFICARCONDICIONES),
                    WaitUntil.the(SolicitudNuevo.ACEPTARMODIFICARCONDICIONES, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(SolicitudNuevo.ACEPTARMODIFICARCONDICIONES, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARMODIFICARCONDICIONES));
        }else {
            return Task.where("{0} No aplica Modificación de importe");
        }

    }


    public static Performable generarfichaPLD(String modificacionimporte,String idcotizacion) {
        String comboestado="Aprobada";
        System.out.println("---Si trae el ID:-----+"+idcotizacion+"+----------");
        String idcotizacions = idcotizacion;
        if ("NO".equalsIgnoreCase(modificacionimporte)){
        return Task.where("{0} click on generarficha",
                JavaScriptClick.on(BandejaCotizacionesFDN.COTIZACIONES),
                WaitUntil.the(BandejaCotizacionesFDN.COMBOESTADO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                Select.option(comboestado).from(BandejaCotizacionesFDN.COMBOESTADO),
                /*WaitUntil.the(BandejaCotizacionesFDN.BUSCARID, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(BandejaCotizacionesFDN.BUSCARID, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),*/
                Clear.field(BandejaCotizacionesFDN.BUSCARID),
                Enter.theValue(idcotizacions).into(BandejaCotizacionesFDN.BUSCARID),
                JavaScriptClick.on(BandejaCotizacionesFDN.BTNBUSCAR),
                WaitUntil.the(BandejaCotizacionesFDN.GENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(BandejaCotizacionesFDN.GENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                JavaScriptClick.on(BandejaCotizacionesFDN.GENERARFICHA),
                WaitUntil.the(BandejaCotizacionesFDN.SIGENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(BandejaCotizacionesFDN.SIGENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                JavaScriptClick.on(BandejaCotizacionesFDN.SIGENERARFICHA),
                WaitUntil.the(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                JavaScriptClick.on(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA),
                WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                JavaScriptClick.on(BandejaCotizacionesFDN.ACEPTARGENERARFICHA));
        }else {

            return Task.where("{0} click on generarficha",
                    JavaScriptClick.on(BandejaCotizacionesFDN.COTIZACIONES),
                    WaitUntil.the(BandejaCotizacionesFDN.COMBOESTADO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.option(comboestado).from(BandejaCotizacionesFDN.COMBOESTADO),
                    /*WaitUntil.the(BandejaCotizacionesFDN.BUSCARID, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.BUSCARID, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),*/
                    Clear.field(BandejaCotizacionesFDN.BUSCARID),
                    Enter.theValue(idcotizacions).into(BandejaCotizacionesFDN.BUSCARID),
                    JavaScriptClick.on(BandejaCotizacionesFDN.BTNBUSCAR),
                    WaitUntil.the(BandejaCotizacionesFDN.GENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.GENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.GENERARFICHA),
                    WaitUntil.the(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.CONFIRMARGENERARFICHA),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGENERARFICHA, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGENERARFICHA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.ACEPTARGENERARFICHA));
        }

    }

    public static Performable desembolsofeedback(String v){

        double min1 = Math.ceil(000000001);
        double max1 = Math.floor(999999999);
        double r1 = Math.floor(Math.random() * (max1 - min1 + 1) + min1);
        String contrato = "123"+String.valueOf(r1);
        System.out.println("+++++++++++++++++++++"+contrato);

        String motivo = "El cliente no está interesado en la oferta";
        String sustento = "Test automatizado";

        if ("D".equalsIgnoreCase(v)){
            return Task.where("{0} Se desembolsa la cotización",
                    WaitUntil.the(BandejaCotizacionesFDN.VINCULAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.VINCULAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.VINCULAROPERACION),
                    WaitUntil.the(BandejaCotizacionesFDN.NROCONTRATO, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.NROCONTRATO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Enter.theValue(contrato).into(BandejaCotizacionesFDN.NROCONTRATO),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARVINCULAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARVINCULAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.ACEPTARVINCULAROPERACION),
                    WaitUntil.the(BandejaCotizacionesFDN.SIVINCULAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.SIVINCULAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.SIVINCULAROPERACION));
        }else{
            return Task.where("{0} Se da por perdida la cotización",
                    WaitUntil.the(BandejaCotizacionesFDN.FEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.FEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.FEEDBACK),
                    WaitUntil.the(BandejaCotizacionesFDN.COMBOMOTIVOFEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.COMBOMOTIVOFEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Select.value(motivo).from(BandejaCotizacionesFDN.COMBOMOTIVOFEEDBACK),
                    WaitUntil.the(BandejaCotizacionesFDN.SUSTENTOFEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.SUSTENTOFEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    Enter.theValue(sustento).into(BandejaCotizacionesFDN.SUSTENTOFEEDBACK),
                    WaitUntil.the(BandejaCotizacionesFDN.GUARDARFEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.GUARDARFEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.GUARDARFEEDBACK),
                    WaitUntil.the(BandejaCotizacionesFDN.SIGUARDARFEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.SIGUARDARFEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.SIGUARDARFEEDBACK));
        }
    }


    public static Performable aceptardesembolsofeedback(String v){

        if ("D".equalsIgnoreCase(v)){
            return Task.where("{0} Se acepta desembolsar la cotización",
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTAREXITOVINCULAROPERACION, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTAREXITOVINCULAROPERACION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.ACEPTAREXITOVINCULAROPERACION));
        }else{
            return Task.where("{0} Se acepta dar por perdida la cotización",
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGUARDARFEEDBACK, WebElementStateMatchers.isVisible()).forNoMoreThan(20L).seconds(),
                    WaitUntil.the(BandejaCotizacionesFDN.ACEPTARGUARDARFEEDBACK, WebElementStateMatchers.isEnabled()).forNoMoreThan(20L).seconds(),
                    JavaScriptClick.on(BandejaCotizacionesFDN.ACEPTARGUARDARFEEDBACK));
        }
    }
}
