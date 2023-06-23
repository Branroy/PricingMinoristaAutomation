package pe.com.bif.techcases.testautomation.ui.mapping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BandejaCotizacionesFDN {
    public static final Target NUEVACOTIZACION = Target
            .the("nuevacotizacion")
            .located(By.xpath("//*[@id=\"optNuevaCotizacion\"]/a"));
    public static final Target COTIZACIONES = Target
            .the("cotizaciones")
            .located(By.xpath("//*[@id=\"optCotizaciones\"]/a/i"));

    public static final Target COMBOESTADO = Target
            .the("comboestado")
            .located(By.xpath("//*[@id=\"cboEstado\"]"));

    public static final Target GENERARFICHA = Target
            .the("generarficha")
            .located(By.xpath("//*[@id=\"tblFiltroSolicitudes\"]/tbody/tr/td[4]/button[2]"));

    public static final Target SIGENERARFICHA = Target
            .the("sigenerarficha")
            .located(By.xpath("/html/body/div[10]/div/div[3]/button[2]"));

    public static final Target CONFIRMARGENERARFICHA = Target
            .the("confirmargenerarficha")
            .located(By.xpath("/html/body/div[10]/div/div[3]/button[2]"));

    public static final Target ACEPTARGENERARFICHA = Target
            .the("aceptargenerarficha")
            .located(By.xpath("/html/body/div[10]/div/div[3]/button[1]"));

    public static final Target BUSCARID = Target
            .the("buscarid")
            .located(By.xpath("//*[@id=\"txtIDCotizacion\"]"));

    public static final Target BTNBUSCAR = Target
            .the("btnbucar")
            .located(By.xpath("//*[@id=\"btnbuscar\"]"));

    public static final Target VINCULAROPERACION = Target
            .the("vincularoperacion")
            .located(By.xpath("//*[@id=\"tblFiltroSolicitudes\"]/tbody/tr/td[4]/button[1]"));

    public static final Target NROCONTRATO = Target
            .the("nrocontrato")
            .located(By.xpath("/html/body/div[7]/div/div/div[2]/div/div[2]/div/input"));

    public static final Target ACEPTARVINCULAROPERACION = Target
            .the("aceptarvincularoperacion")
            .located(By.xpath("//*[@id=\"btnVincularOperacion\"]"));

    public static final Target SIVINCULAROPERACION = Target
            .the("sivincularoperacion")
            .located(By.xpath("/html/body/div[11]/div/div[3]/button[2]"));

    public static final Target ACEPTAREXITOVINCULAROPERACION = Target
            .the("sivincularoperacion")
            .located(By.xpath("/html/body/div[10]/div/div[3]/button[1]"));




    public static final Target FEEDBACK = Target
            .the("feedback")
            .located(By.xpath("//*[@id=\"tblFiltroSolicitudes\"]/tbody/tr/td[4]/button[3]"));

    public static final Target COMBOMOTIVOFEEDBACK = Target
            .the("combomotivofeedback")
            .located(By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/select"));

    public static final Target SUSTENTOFEEDBACK = Target
            .the("sustentofeedback")
            .located(By.xpath("//*[@id=\"txtSustentoPerdida\"]"));

    public static final Target GUARDARFEEDBACK = Target
            .the("guardarfeedback")
            .located(By.xpath("//*[@id=\"btnRegistrarPerdida\"]"));

    public static final Target SIGUARDARFEEDBACK = Target
            .the("siguardarfeedback")
            .located(By.xpath("/html/body/div[11]/div/div[3]/button[2]"));

    public static final Target ACEPTARGUARDARFEEDBACK = Target
            .the("aceptarguardarfeedback")
            .located(By.xpath("/html/body/div[10]/div/div[3]/button[1]"));






}

