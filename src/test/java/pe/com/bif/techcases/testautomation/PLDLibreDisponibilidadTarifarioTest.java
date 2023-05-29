package pe.com.bif.techcases.testautomation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pe.com.bif.techcases.testautomation.ui.actors.BaseConf;
import pe.com.bif.techcases.testautomation.ui.mapping.SolicitudNuevo;
import pe.com.bif.techcases.testautomation.ui.tasks.BandejaCotizacionesFDNActions;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginActions;
import pe.com.bif.techcases.testautomation.ui.tasks.NavigateTo;
import pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoActions;

import java.sql.*;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/testdata/PLDLibreDisponibilidadTarifario.csv")
public class PLDLibreDisponibilidadTarifarioTest extends BaseConf {

    String connectionString ="jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";
    String login ="usr_princing";
    String pass ="43#pr1@8";


    private String cargo;
    private String escliente;
    private String segmentacion;
    private String modalidad;
    private String requieresustento;

    @Before
    public void navigate() { actor.attemptsTo(NavigateTo.signUpPage());

    }

    @Test
    public void CotizacionTarifarioPLD() {

        String connectionString =
                "jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";

        String login =
                "usr_princing";

        String pass =
                "43#pr1@8";


        //String cargo = "GERENTE DE OFICINA";
        try{
            Connection connection = DriverManager.getConnection(connectionString,login,pass);
            System.out.println("Connection established.");

            Statement mystatement = connection.createStatement();

            ResultSet bd = mystatement.executeQuery(
                    "SELECT * FROM (SELECT TOP 1 REGISTRO,PASSWORD FROM ORG_INTEGRANTE2 WHERE PRESENCIA = 1 AND LOGUEO = 1 AND ESTADO = 1 AND ESTADO_SOL_ACTIVACION = 'ACTIVO' AND DESC_CARGO = 'REPRESENTANTE DE SERVICIO AL CLIENTE' ORDER BY NEWID()\n" +
                            ") AS T1, (SELECT TOP(1) l.num_doc_identidad as NRODOCUMENTO, I.INGRESO_NETO AS INGRESOS, D.COD_CUENTA AS NROPAGARE, D.DIVISA AS DIVISA FROM CFG_LLE L INNER JOIN CFG_CLIENTES C ON L.num_doc_identidad = C.NRO_DOCUMENTO \n" +
                            "JOIN CFG_INGRESOS I ON I.NUM_DOC_IDENTIDAD = L.num_doc_identidad\n" +
                            "JOIN CFG_INFOADICIONAL_DESEMBOLSOS D ON D.NRO_DOCUMENTO = L.num_doc_identidad\n" +
                            "WHERE L.tip_doc_identidad = '1' AND L.NUM_DOC_IDENTIDAD != ' ' AND C.RANGO_INGRESO != '0.0' AND C.CLIENTE_BIF = '0' AND C.SEGMENTACION_RIESGOS = '4'\n" +
                            "AND L.cliente_bif = '0' AND L.Segmentacion ='4' AND I.TIP_DOC_IDENTIDAD = '1' ORDER BY NEWID()) AS T2");

            while (bd.next()){
                String usuario = bd.getString(1);
                String password = bd.getString(2);
                String nrodocumento = bd.getString(3);
                double ingresoneto = bd.getDouble(4);
                String nropagare = bd.getString(5);
                String divisa = bd.getString(6);

                actor.attemptsTo(
                        LoginActions.usuario(usuario),
                        LoginActions.password(password),
                        LoginActions.entrar(),
                        BandejaCotizacionesFDNActions.nuevacotizacion(),
                        SolicitudNuevoActions.nrodocumento(nrodocumento),
                        SolicitudNuevoActions.buscarcliente(),
                        //SolicitudNuevoActions.nombrecliente(escliente),
                        SolicitudNuevoActions.macroproducto("PLD"),
                        SolicitudNuevoActions.producto("PTMO. LIBRE DISPONIBILIDAD"),
                        SolicitudNuevoActions.modalidad(modalidad),
                        SolicitudNuevoActions.nropagare(nropagare,modalidad),
                        SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                        SolicitudNuevoActions.relacionlaboral("MIXTA"),
                        SolicitudNuevoActions.ingresonetoconsustento(ingresoneto,requieresustento),
                        SolicitudNuevoActions.importe(divisa),
                        SolicitudNuevoActions.montooperacion("30000.00"),
                        SolicitudNuevoActions.garantia("SIN GARANTIA"),
                        SolicitudNuevoActions.plazo("AÑO"),
                        SolicitudNuevoActions.nroplazo("3"),
                        SolicitudNuevoActions.opencalendar(),
                        SolicitudNuevoActions.nextmonthcalendar(),
                        SolicitudNuevoActions.okcalendar(),
                        SolicitudNuevoActions.calculartasa()
                    /*SolicitudNuevoActions.guardaroperacion(),
                    SolicitudNuevoActions.confirmaroperacion()*/
                );


            }

        } catch (SQLException e){
            System.out.println("Error connection to the database");
            e.printStackTrace();
        }


    }



}
