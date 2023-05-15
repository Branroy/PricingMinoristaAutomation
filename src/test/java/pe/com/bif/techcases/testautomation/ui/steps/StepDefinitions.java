package pe.com.bif.techcases.testautomation.ui.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import pe.com.bif.techcases.testautomation.ui.actors.DefaultUser;


import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitions {

    @Steps
    DefaultUser user;

    @ParameterType(".*")
    public DefaultUser user(String user) {
        try {
            return (DefaultUser) Class.forName("pe.com.bif.techcases.testautomation.ui.actors." + user)
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException
                 | NoSuchMethodException
                 | IllegalAccessException
                 | InstantiationException
                 | IllegalArgumentException
                 | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("a user visits {page}")
    public void visits(Class<PageObject> page) throws IllegalAccessException, InterruptedException {
        user.goToPage(page);
        //Debería estar la lógica que donde busca que Usuario esta dispinible segun el cargo escogido.
        //Y debería traer el usuario y contraseña de base de datos
        //Login
        user.fillsField("Usuario","RPADILLA");
        user.fillsField("Password","123456789");
        user.clicksOn("Entrar");

        //Ingreso a cotizaciones
        //1. Datos del Cliente
        user.clicksOn("Nueva Cotización");
        user.selectText("cboTipoDocumento","DNI");
        user.fillsField("txtNroDocumento","74649971");
        user.clicksOnButtonByID("btn");
        user.clicksOn("Nueva Solicitud");
        //Thread.sleep(1000);

    }
    @When("the user selects product {string} and modality {string}")
    public void clicksG(String product,String modality) throws IllegalAccessException, InterruptedException {
        //2. Datos del producto
        user.waitElement("loader");
        user.selectText("cboTipoProducto", "PLD");
        user.waitElement("loader");
        user.selectText("cboProducto", product);
        user.waitElement("loader");
        user.selectText("cboModalidad", modality);
        user.waitElement("loader");
        user.selectText("cboTipoIngreso", "INGRESO INDIVIDUAL");
        user.waitElement("loader");
        user.selectText("cboTipoRelacionLaboral", "INDEPENDIENTE");
        user.waitElement("loader");
        user.fillsFieldbyId("txtIngresoEstimado", "10500.50");


        //3. Datos del préstamo
        user.selectValue("cboMonedaOperacion", "USD");
        user.fillsFieldbyId("txtMontoOperacion", "500000.50");
        user.selectText("cboGarantia", "SIN GARANTIA");
        user.selectText("cboPlazo", "AÑO");
        user.fillsFieldbyId("txtPlazo", "5");


        //Fecha de Primera Cuota, selecciona el mes siguiente.
        user.clicksOnButtonByID("txtFechaPrimeraC");
        user.clicksOnByXpath("/html/body/div[15]/div/div[1]/div[1]/div[1]/div[3]/a/i");
        user.clicksOnByXpath("/html/body/div[15]/div/div[2]/button[4]");
        //Este clic es solo para que tome la foto cuando todos los campos estén llenos.
        //CAPTURA DE PANTALLA-Se debe tomar la foto aqui para la documentación
        user.clicksOn("Nueva Solicitud");

        //4. Tasas sugeridas
        user.clicksOnButtonByID("btnCalcularTasa");
        user.waitElement("loader");
        //CAPTURA DE PANTALLA:Se debe tomar la foto aqui para la documentación
        user.clicksOnButtonByID("btnGuardarOperacion");
        //Confirma Aprobación en Tarifario
        user.waitElement("loader");
        user.clicksOnByXpath("/html/body/div[16]/div/div[3]/button[2]");

    }

    @Then("The Page says {string}")
    public void thePageSays(String text) throws IllegalAccessException{
        assertThat(user.isAbleToSee(text)).isTrue();
    }

    @ParameterType(".*")
    public Class<PageObject> page(String pageName) {
        try {
            return (Class<PageObject>) Class.forName("pe.com.bif.techcases.testautomation.ui.pages." + pageName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }