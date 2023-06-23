package pe.com.bif.techcases.testautomation.ui.get;

import org.openqa.selenium.By;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;

public class SolicitudNuevoGets {

    public static Map<String, String> idcotizacion() {
        String idsol = getDriver().findElement(By.xpath(String.valueOf(SolicitudNuevo.IDCOTIZACION))).getText();
        System.out.println("+++++++++++++"+idsol+"+++++++++++++");

        String connectionString =
                "jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";
        String login =
                "usr_princing";
        String pass =
                "43#pr1@8";

        Map<String, String> keyValueMap = new HashMap<>();

        try{
            Connection connection = DriverManager.getConnection(connectionString,login,pass);
            System.out.println("Connection established.");

            Statement mystatement = connection.createStatement();
            ResultSet bd = mystatement.executeQuery(
                    "DECLARE @IDSOL AS INT='"+idsol+"'\n" +
                            "DECLARE @PLAZO AS INT\n" +
                            "DECLARE @TIPO_PLAZO AS VARCHAR(10)\n" +
                            "DECLARE @DIVISA AS VARCHAR(10)\n" +
                            "DECLARE @DIAS AS INT\n" +
                            "DECLARE @PRODUCTO AS VARCHAR(100)\n" +
                            "DECLARE @COD_PROD AS INT\n" +
                            "\n" +
                            "SELECT @PRODUCTO=PRODUCTO, @DIVISA=DIVISA, @PLAZO=PLAZO, @TIPO_PLAZO=UNIDAD_PLAZO FROM SOL_OPERACION WHERE IDSOL=@IDSOL\n" +
                            "SELECT @COD_PROD=CODIGO FROM SOL_PRODUCTO WHERE NOMBRE=@PRODUCTO\n" +
                            "\n" +
                            "BEGIN IF @TIPO_PLAZO='MES' \n" +
                            "\tselect @DIAS=@PLAZO*30 \n" +
                            "ELSE IF @TIPO_PLAZO='AÑO' \n" +
                            "\tSELECT @DIAS=@PLAZO*360 ELSE \n" +
                            "\tSELECT @DIAS=@PLAZO END\n" +
                            "\n" +
                            "BEGIN IF @DIVISA = 'PEN'\n" +
                            "SELECT * FROM (SELECT TT,LLE,COD_CLUSTER,TEAPIZ,TEASOL FROM SOL_TASA WHERE IDSOL = @IDSOL AND APLICACION ='1') AS T1,\n" +
                            "(SELECT TASA_TRANSFERENCIA FROM CFG_COSTO_FONDEO_CONSUMO WHERE DIAS=@DIAS AND COD_PRODUCTO=@COD_PROD) AS T2,\n" +
                            "(SELECT NOMCLIENTE FROM SOL_CLIENTE WHERE IDSOL = @IDSOL AND APLICACION ='1') AS T3\n" +
                            "\n" +
                            "ELSE \n" +
                            "\n" +
                            "SELECT * FROM (SELECT TT,LLE,COD_CLUSTER,TEAPIZ,TEASOL FROM SOL_TASA WHERE IDSOL = @IDSOL AND APLICACION ='1') AS T1,\n" +
                            "(SELECT TASA_TRANSFERENCIA FROM CFG_COSTO_FONDEO WHERE DIAS=@DIAS AND MONEDA=@DIVISA) AS T2,\n" +
                            "(SELECT NOMCLIENTE FROM SOL_CLIENTE WHERE IDSOL = @IDSOL AND APLICACION ='1') AS T3\n" +
                            "END");

            while (bd.next()) {
                keyValueMap.put("TT", bd.getString(1));
                keyValueMap.put("LLE", bd.getString(2));
                keyValueMap.put("CLUSTER", bd.getString(3));
                keyValueMap.put("TASA_MINIMA", bd.getString(4));
                keyValueMap.put("TASA_SUGERIDA", bd.getString(5));
                keyValueMap.put("TT_ESPERADO",bd.getString(6));
                keyValueMap.put("ID_COTIZACION",idsol);
                keyValueMap.put("NAME",bd.getString(7));

                //System.out.println(keyValueMap);
            }

        }
        catch (SQLException e){
            System.out.println("Error connection to the database");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return keyValueMap;
    }
}
