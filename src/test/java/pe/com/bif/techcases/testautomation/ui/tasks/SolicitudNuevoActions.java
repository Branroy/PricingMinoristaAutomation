package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

public class SolicitudNuevoActions {
    public static Performable nrodocumento(String nrodocumento) {
        return Task.where("{0} enters nro documento '" + nrodocumento + "'",
                Clear.field(SolicitudNuevo.NRODOCUMENTO),
                Enter.theValue(nrodocumento).into(SolicitudNuevo.NRODOCUMENTO));
    }

    public static Performable nombrecliente(String escliente) {

        if("NO".equalsIgnoreCase(escliente)){
            return Task.where("{0} enters nombre cliente CLIENTE TEST AUTOMATIZADO",
                    Click.on(SolicitudNuevo.CONFIRMARALERTACLIENTE),
                    WaitUntil.the(SolicitudNuevo.NOMBRECLIENTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
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
                WaitUntil.the(SolicitudNuevo.MACROPRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(macroproducto).from(SolicitudNuevo.MACROPRODUCTO));
    }

    public static Performable producto(String producto) {
        return Task.where("{0} select producto '" + producto + "'",
                WaitUntil.the(SolicitudNuevo.PRODUCTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(producto).from(SolicitudNuevo.PRODUCTO));
    }

    public static Performable modalidad(String modalidad) {
        return Task.where("{0} select modalidad '" + modalidad + "'",
                WaitUntil.the(SolicitudNuevo.MODALIDAD, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(modalidad).from(SolicitudNuevo.MODALIDAD));
    }

    public static Performable nrovivienda(String nrovivienda) {
        return Task.where("{0} select nro vivienda '" + nrovivienda + "'",
                WaitUntil.the(SolicitudNuevo.NROVIVIENDA, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(nrovivienda).from(SolicitudNuevo.NROVIVIENDA));
    }

    public static Performable tipobien(String tipobien) {
        return Task.where("{0} select tipo de bien '" + tipobien + "'",
                WaitUntil.the(SolicitudNuevo.TIPOBIEN, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(tipobien).from(SolicitudNuevo.TIPOBIEN));
    }

    public static Performable planahorro(String planahorro) {
        if ("SI".equalsIgnoreCase(planahorro))
        return Task.where("{0} select planahorro SI",
                WaitUntil.the(SolicitudNuevo.PLANAHORRO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                JavaScriptClick.on(SolicitudNuevo.PLANAHORRO));
        else{
            return Task.where("{0} select planahorro NO");
        }
    }

    public static Performable nombreproyecto(String nombreproyecto) {
        return Task.where("{0} select nombre del proyecto '" + nombreproyecto + "'",
                WaitUntil.the(SolicitudNuevo.NOMBREPROYECTO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(nombreproyecto).from(SolicitudNuevo.NOMBREPROYECTO));
    }

    public static Performable precioinmueble(String precioinmueble) {
        return Task.where("{0} select precio venta del inmueble '" + precioinmueble + "'",
                WaitUntil.the(SolicitudNuevo.PRECIOINMUEBLE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(precioinmueble).from(SolicitudNuevo.PRECIOINMUEBLE));
    }

    public static Performable montoprecioinmueble(String montoprecioinmueble) {

        return Task.where("{0} enters monto precio venta del inmueble '" + montoprecioinmueble + "'",
                Clear.field(SolicitudNuevo.MONTOPRECIOINMUEBLE),
                Enter.theValue(Keys.ARROW_RIGHT).into(SolicitudNuevo.MONTOPRECIOINMUEBLE),
                Enter.theValue(montoprecioinmueble).into(SolicitudNuevo.MONTOPRECIOINMUEBLE));
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
                WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(tipoingreso).from(SolicitudNuevo.TIPOINGRESO));
    }

    public static Performable tipoingresocodeudor(String codeudor) {
        if ("SI".equalsIgnoreCase(codeudor)){
        return Task.where("{0} select tipo de ingreso codeudor",
                WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option("INGRESO CODEUDOR").from(SolicitudNuevo.TIPOINGRESO));
        }else {
            return Task.where("{0} select tipo de ingreso individual",
                    WaitUntil.the(SolicitudNuevo.TIPOINGRESO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option("INGRESO INDIVIDUAL").from(SolicitudNuevo.TIPOINGRESO));
        }

    }

    public static Performable relacionlaboral(String relacionlaboral) {
        return Task.where("{0} select tipo relacion laboral '" + relacionlaboral + "'",
                WaitUntil.the(SolicitudNuevo.RELACIONLABORAL, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
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
                    WaitUntil.the(SolicitudNuevo.PROYECTOBANCO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    JavaScriptClick.on(SolicitudNuevo.PROYECTOBANCO));
        }else{
            return Task.where("{0} select proyectobanco NO");
        }
    }


    public static Performable importe(String importe) {
        return Task.where("{0} select importe '" + importe + "'",
        WaitUntil.the(SolicitudNuevo.IMPORTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
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
                WaitUntil.the(SolicitudNuevo.IMPORTE, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(garantia).from(SolicitudNuevo.GARANTIA));
    }

    public static Performable plazo(String plazo) {
        return Task.where("{0} select plazo '" + plazo + "'",
                WaitUntil.the(SolicitudNuevo.PLAZO, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
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
                Click.on(SolicitudNuevo.OKCALENDAR));
    }

    public static Performable calculartasa() {
        return Task.where("{0} click on calcular tasa",
                Click.on(SolicitudNuevo.CALCULARTASA));
    }

    public static Performable guardaroperacion() {
        return Task.where("{0} click on guardar operacion",
                Click.on(SolicitudNuevo.GUARDAROPERACION));
    }

    public static Performable confirmaroperacion() {
        return Task.where("{0} click on confirmar operación",
                Click.on(SolicitudNuevo.CONFIRMAROPERACION));
    }

    public static Performable tasaadicionallibre(String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre) ){
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'");
        } else if ("2".equalsIgnoreCase(tasaadicionallibre)) {
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'",
                    JavaScriptClick.on(SolicitudNuevo.TASAADICIONALLIBRE));
        /*}else if ("3".equalsIgnoreCase(tasaadicionallibre)){
            return Task.where("{0} select cantidad de datos adicionales '" + tasaadicionallibre + "'",
                    Click.on(SolicitudNuevo.TASAADICIONALLIBRE),
                    Click.on(SolicitudNuevo.TASAADICIONALLIBRE));*/
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
                WaitUntil.the(SolicitudNuevo.ENTIDAD1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(entidad1).from(SolicitudNuevo.ENTIDAD1));
        }else{
            return Task.where("{0} select entidad1 '" + entidad1 + "'",
                    WaitUntil.the(SolicitudNuevo.ENTIDAD1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(entidad1).from(SolicitudNuevo.ENTIDAD1));
        }

    }

    public static Performable entidad2(String entidad2,String tasaadicionallibre) {
            if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

                return Task.where("{0} select entidad2 '" + entidad2 + "'",
                        WaitUntil.the(SolicitudNuevo.ENTIDAD2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                        Select.option(entidad2).from(SolicitudNuevo.ENTIDAD2));
            }else{
                return Task.where("{0} no aplica entidad2");
            }
    }

    public static Performable entidad3(String entidad3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select entidad3 '" + entidad3 + "'",
                    WaitUntil.the(SolicitudNuevo.ENTIDAD3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(entidad3).from(SolicitudNuevo.ENTIDAD3));
        }else{
            return Task.where("{0} no aplica entidad2");
        }
    }

    public static Performable productocomprar1(String productocomprar1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar1 '" + productocomprar1 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(productocomprar1).from(SolicitudNuevo.PRODUCTOCOMPRAR1));
        }else{
            return Task.where("{0} select productocomprar1 '" + productocomprar1 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(productocomprar1).from(SolicitudNuevo.PRODUCTOCOMPRAR1));
        }

    }

    public static Performable productocomprar2(String productocomprar2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar2 '" + productocomprar2 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(productocomprar2).from(SolicitudNuevo.PRODUCTOCOMPRAR2));
        }else{
            return Task.where("{0} no aplica productocomprar2");
        }
    }

    public static Performable productocomprar3(String productocomprar3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select productocomprar3 '" + productocomprar3 + "'",
                    WaitUntil.the(SolicitudNuevo.PRODUCTOCOMPRAR3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(productocomprar3).from(SolicitudNuevo.PRODUCTOCOMPRAR3));
        }else{
            return Task.where("{0} no aplica productocomprar3");
        }
    }

    public static Performable divisaproducto1(String divisaproducto1,String tasaadicionallibre) {
        if ("1".equalsIgnoreCase(tasaadicionallibre)|| "".equalsIgnoreCase(tasaadicionallibre) || "0".equalsIgnoreCase(tasaadicionallibre)
                || "2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto1 '" + divisaproducto1 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(divisaproducto1).from(SolicitudNuevo.DIVISAPRODUCTO1));
        }else{
            return Task.where("{0} select divisaproducto1 '" + divisaproducto1 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO1, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(divisaproducto1).from(SolicitudNuevo.DIVISAPRODUCTO1));
        }

    }

    public static Performable divisaproducto2(String divisaproducto2,String tasaadicionallibre) {
        if ("2".equalsIgnoreCase(tasaadicionallibre) || "3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto2 '" + divisaproducto2 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO2, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                    Select.option(divisaproducto2).from(SolicitudNuevo.DIVISAPRODUCTO2));
        }else{
            return Task.where("{0} no aplica divisaproducto2");

        }
    }


    public static Performable divisaproducto3(String divisaproducto3,String tasaadicionallibre) {
        if ("3".equalsIgnoreCase(tasaadicionallibre)){

            return Task.where("{0} select divisaproducto3 '" + divisaproducto3 + "'",
                    WaitUntil.the(SolicitudNuevo.DIVISAPRODUCTO3, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
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

}
