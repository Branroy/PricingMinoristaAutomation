package pe.com.bif.techcases.testautomation.ui.actors;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Field;

public class DefaultUser extends ScenarioSteps {


    static class PageContainer {
        private static PageObject CURRENT_PAGE;

        public static PageObject getCurrentPage() {
            return CURRENT_PAGE;
        }

        public static PageObject setCurrentPage(PageObject page) {
            CURRENT_PAGE = page;
            return CURRENT_PAGE;
        }
    }

    @Step
    public PageObject goToPage(Class<PageObject> pageClass) {
        PageObject page = getPages().get(pageClass);
        page.open();
        PageContainer.setCurrentPage(page);
        return page;
    }

    @Step
    public PageObject goToPage(Class<PageObject> pageClass, String method, String[] params) {
        PageObject page = getPages().get(pageClass);
        page.open(method, params);
        PageContainer.setCurrentPage(page);
        return page;
    }

    @Step
    public void clicksOn(String elementName) throws IllegalAccessException {
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollIntoView();arguments[0].click()",
                getReflexiveElement(elementName));
    }

    @Step
    public void clicksOnButtonByID(String elementName) throws IllegalAccessException,InterruptedException {
        getDriver().findElement(By.id(elementName)).click();
        Thread.sleep(500);

    }
    @Step
    public void clicksOnByXpath(String elementName) throws IllegalAccessException,InterruptedException {
        getDriver().findElement(By.xpath(elementName)).click();
        Thread.sleep(500);

    }


    public void clicksOnText(String elementName) throws IllegalAccessException {
        if(isAbleToSee(elementName)){
            ((JavascriptExecutor)getDriver()).executeScript(
                    "arguments[0].scrollIntoView();arguments[0].click()",
                    getReflexiveElement(elementName));
        }else{
            System.out.println("IS NOT DISPLAYED");
        }
    }


    @Step
    public void fillsField(String elementName, String value) throws IllegalAccessException {
        ((JavascriptExecutor)getDriver()).executeScript(
                "arguments[0].scrollIntoView();arguments[0].setAttribute('value', arguments[1])",
                getReflexiveElement(elementName), value);

    }

    @Step
    public void validacionClient() throws IllegalAccessException,InterruptedException {
        Thread.sleep(2000);
        if(isAbleToSee("No se encontró ningún cliente con los datos especificados. \n" +
                " Por favor ingrese el nombre del cliente.")){
            clicksOnByXpath("/html/body/div[16]/div/div[3]/button[1]");
            fillsField("txtNombre","CLIENTE TEST AUTOMATIZADO");
        }
    }

    @Step
    public void validacionModality(String nropagare) throws IllegalAccessException,InterruptedException {
        Thread.sleep(500);
        if(isAbleToSee("Nro. Pagaré:")){
            fillsFieldbyId("txtNroPagarePLD",nropagare);
        }
    }

    @Step
    public void fillsFieldbyId(String elementName, String value) throws IllegalAccessException,InterruptedException {
        getDriver().findElement(By.id(elementName)).sendKeys(Keys.HOME);
        getDriver().findElement(By.id(elementName)).sendKeys(Keys.ARROW_RIGHT);
        getDriver().findElement(By.id(elementName)).sendKeys(value);
        Thread.sleep(500);
    }

    @Step
    public void fillsFieldbyClic(String elementName, String value) throws IllegalAccessException,InterruptedException {
        String elementNameT = '"'+elementName+'"';
        getDriver().findElement(By.xpath("//*[@id="+elementNameT+"]")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//*[@id="+elementNameT+"]")).sendKeys(""+value+"");
    }

    @Step
    public void selectText(String elementName, String value) throws IllegalAccessException,InterruptedException {
        clicksOn(elementName);
        Thread.sleep(100);
        clicksOn(value);
    }

    @Step
    public void selectValue(String elementName, String value) throws IllegalAccessException,InterruptedException {
        Select obj = new Select(getDriver().findElement(By.id(elementName)));
        obj.selectByValue(value);
    }

    @Step
    public boolean isAbleToSee(String elementName) throws IllegalAccessException {
        try{
            return getReflexiveElement(elementName).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    @Step
    public void waitElement(String elementName) throws IllegalAccessException,InterruptedException {
        while (isAbleToSee(elementName)) {
            Thread.sleep(250);
        }
    }


    private WebElement getReflexiveElement(String elementName) throws IllegalAccessException {
        try {
            Field field = PageContainer.getCurrentPage()
                    .getClass().getDeclaredField(elementName);
            field.setAccessible(true);
            return (WebElement)field.get(
                    PageContainer.getCurrentPage());
        } catch(NoSuchFieldException e) {
            try {
                return getDriver().findElement(
                        By.xpath("//*[ contains (text(), '"+elementName+"')] | //*[@*='"+elementName+"']"));
            } catch (NoSuchElementException ee) {
                throw new NoSuchElementException(
                        "Cannot find element with text: "+elementName+".\nPlease use specific locator to find it", ee);
            }

        }
    }

    private WebElement getReflexiveElementID(String elementName) throws IllegalAccessException {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println('"'+elementName+'"');
            boolean present;
            try {
                getDriver().findElement(By.id('"'+elementName+'"'));
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
            }

            return getDriver().findElement(By.id('"'+elementName+'"'));


        } catch(NoSuchElementException e) {
            throw new NoSuchElementException(
                    "Cannot find element with id: "+elementName+".\nPlease use specific locator to find it", e);

        }
    }



}
