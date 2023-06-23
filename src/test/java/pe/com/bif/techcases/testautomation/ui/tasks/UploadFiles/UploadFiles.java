package pe.com.bif.techcases.testautomation.ui.tasks.UploadFiles;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFiles {

    public static void uploadfilecompiteentidad(String compite) throws AWTException, InterruptedException {

        if ("SI".equalsIgnoreCase(compite)){
        String pathFile = "D:\\ArchivosMinorista\\CARGA_ARCHIVO_PDF_TEST.pdf";

            try {
                StringSelection stringSelection = new StringSelection(pathFile);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
                Robot robot = new Robot();
                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("No aplica archivo cronograma");
        }
    }


    public static void uploadfilerequieresustento(String requieresustento) throws AWTException, InterruptedException {

        if ("SI".equalsIgnoreCase(requieresustento)){
            String pathFile = "D:\\ArchivosMinorista\\CARGA_ARCHIVO_PDF_TEST.pdf";

            try {
                StringSelection stringSelection = new StringSelection(pathFile);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
                Robot robot = new Robot();
                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("No aplica requiere sustento ingreso netos");
        }
    }
}

