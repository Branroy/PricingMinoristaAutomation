package pe.com.bif.techcases.testautomation.ui.tasks.GenerarFicha;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class GenerarFicha {
    public static void abrirfichapricing(String id,String name) throws AWTException, InterruptedException {


            String pathFile = "C:\\Users\\PERSONAL\\Downloads\\"+id+"-"+name+".pdf";

            try {
                StringSelection stringSelection = new StringSelection(pathFile);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
                //robot.keyRelease(KeyEvent.VK_R);
                Thread.sleep(1000);
                robot.keyRelease(KeyEvent.VK_DELETE);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(3000);


            } catch (Exception e){
                e.printStackTrace();
            }

    }


    public static void cerrarfichapricing() throws AWTException, InterruptedException {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            //robot.keyRelease(KeyEvent.VK_R);
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
