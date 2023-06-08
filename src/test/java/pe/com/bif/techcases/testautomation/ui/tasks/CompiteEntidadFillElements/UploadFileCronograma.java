package pe.com.bif.techcases.testautomation.ui.tasks.CompiteEntidadFillElements;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFileCronograma {

/*
    @Override
    public <T extends Actor> void performAs (T actor) {

        String pathFile = "D:\\WorkSpaceIntellij\\PricingMinoristaAutomation\\src\\test\\resources\\archivos\\Logo.jpg";

        try {
            StringSelection stringSelection = new StringSelection(pathFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            actor.attemptsTo(Task.where("{0} select archivo cronograma",
                    JavaScriptClick.on(SolicitudNuevo.CONFIRMARCRONOGRAMA),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARCRONOGRAMA)));

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static Performable uploadfilecompiteentidad(String compite){

        String pathFile = "D:\\WorkSpaceIntellij\\PricingMinoristaAutomation\\src\\test\\resources\\archivos\\Logo.jpg";
        if ("SI".equalsIgnoreCase(compite)){
        try {
            StringSelection stringSelection = new StringSelection(pathFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return Task.where("{0} select archivo cronograma",
                    JavaScriptClick.on(SolicitudNuevo.CONFIRMARCRONOGRAMA),
                    JavaScriptClick.on(SolicitudNuevo.ACEPTARCRONOGRAMA));


        } catch (Exception e){
            e.printStackTrace();
        }

    }else {
            return Task.where("{0} select archivo cronograma no aplica");
        }
        return Task.where("{0} select archivo cronograma no aplica");
    }

*/


    public static void uploadfilecompiteentidad(String compite) throws AWTException, InterruptedException {

        if ("SI".equalsIgnoreCase(compite)){
        String pathFile = "D:\\ArchivosMinorista\\CARGA_ARCHIVO_PDF_TEST.pdf";

            try {
                StringSelection stringSelection = new StringSelection(pathFile);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(3000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("No aplica archivo cronograma");
        }
    }

}

