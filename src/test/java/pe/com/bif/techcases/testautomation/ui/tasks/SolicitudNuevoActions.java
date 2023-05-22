package pe.com.bif.techcases.testautomation.ui.tasks;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.selectactions.SelectByIndexFromElement;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.ensure.Expectation;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.matchers.statematchers.IsNotVisibleMatcher;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextValue;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.ui.TextArea;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.serenitybdd.screenplay.waits.WaitWithTimeout;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pe.com.bif.techcases.testautomation.ui.mapping.Login;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public static Performable relacionlaboral(String relacionlaboral) {
        return Task.where("{0} select tipo relacion laboral '" + relacionlaboral + "'",
                WaitUntil.the(SolicitudNuevo.RELACIONLABORAL, WebElementStateMatchers.isEnabled()).forNoMoreThan(20l).seconds(),
                Select.option(relacionlaboral).from(SolicitudNuevo.RELACIONLABORAL));
    }


    public static Performable ingresoneto(double ingresoneto,String requieresustento) {

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


}
