package pe.com.bif.techcases.testautomation;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pe.com.bif.techcases.testautomation.ui.actors.BaseConf;
import pe.com.bif.techcases.testautomation.ui.get.SolicitudNuevoGets;
import pe.com.bif.techcases.testautomation.ui.questions.SolicitudNuevoValidations;
import pe.com.bif.techcases.testautomation.ui.tasks.BandejaCotizacionesFDNActions;
import pe.com.bif.techcases.testautomation.ui.tasks.GenerarFicha.GenerarFicha;
import pe.com.bif.techcases.testautomation.ui.tasks.UploadFiles.UploadFiles;
import pe.com.bif.techcases.testautomation.ui.tasks.LoginActions;
import pe.com.bif.techcases.testautomation.ui.tasks.NavigateTo;
import pe.com.bif.techcases.testautomation.ui.tasks.SolicitudNuevoActions;
import pe.com.bif.techcases.testautomation.util.supportTools;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Map;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/testdata/PLDLibreDisponibilidadTarifario.csv")
public class PLDLibreDisponibilidadTarifarioTest extends BaseConf {

    String connectionString = "jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";
    String login = "usr_princing";
    String pass = "43#pr1@8";



    private String iniciativa;
    private String idcaso;
    private String cargo;
    private String clientebif;
    private String segmentacion;
    private String modalidad;
    private String requieresustento;
    private String divisa;
    private String monto;
    private String plazo;
    private String nroplazo;
    private String seguro;
    private String compiteentidad;
    private String compromiso;
    private String modificacionimporte;

    private String desembolsofeedback;





    //Variable en duro
    private String macroproducto = "PLD";
    private String producto = "PTMO. LIBRE DISPONIBILIDAD";

    @Before
    public void navigate() {
        actor.attemptsTo(NavigateTo.signUpPage());

    }

    @Test
    public void CotizacionTarifarioPLD() throws InterruptedException, AWTException {
        if (modalidad.equalsIgnoreCase("REENGANCHE")) {
            try {
                Connection connection = DriverManager.getConnection(connectionString, login, pass);
                System.out.println("Connection established.");

                Statement mystatement = connection.createStatement();
                ResultSet bd = mystatement.executeQuery(
                        "SELECT * FROM (SELECT TOP 1 REGISTRO,PASSWORD FROM ORG_INTEGRANTE2 WHERE PRESENCIA = 1 AND LOGUEO = 1 AND ESTADO = 1 AND ESTADO_SOL_ACTIVACION = 'ACTIVO' AND DESC_CARGO = '"+cargo+"' ORDER BY NEWID()\n" +
                                ") AS T1, (SELECT TOP(1) l.num_doc_identidad as NRODOCUMENTO, I.INGRESO_NETO AS INGRESOS, D.COD_CUENTA AS NROPAGARE, D.DIVISA AS DIVISA FROM CFG_LLE L INNER JOIN CFG_CLIENTES C ON L.num_doc_identidad = C.NRO_DOCUMENTO \n" +
                                "JOIN CFG_INGRESOS I ON I.NUM_DOC_IDENTIDAD = L.num_doc_identidad\n" +
                                "JOIN CFG_INFOADICIONAL_DESEMBOLSOS D ON D.NRO_DOCUMENTO = L.num_doc_identidad\n" +
                                "WHERE L.tip_doc_identidad = '1' AND L.NUM_DOC_IDENTIDAD != ' ' AND C.RANGO_INGRESO != '0.0' AND C.CLIENTE_BIF = '"+clientebif+"' AND C.SEGMENTACION_RIESGOS = '"+segmentacion+"'\n" +
                                "AND L.cliente_bif = '"+clientebif+"' AND L.Segmentacion ='"+segmentacion+"' AND I.TIP_DOC_IDENTIDAD = '1' ORDER BY NEWID()) AS T2,\n" +
                                "(SELECT TOP(1) OPCION AS TIPORELACIONLABORAL FROM VLR_VARIABLE WHERE VARIABLE = 'TIPO_REL_LABORAL' AND COD_PRODUCTO = '1' ORDER BY NEWID()) as T3,\n" +
                                "(SELECT TOP(1) DESCRIPCION FROM CFG_SEGUROS WHERE MACROPRODUCTO = '1' AND ESTADO = '1' ORDER BY NEWID()) AS T4,\n" +
                                "(SELECT TOP(1) OPCION AS ENTIDAD FROM VLR_VARIABLE WHERE VARIABLE = 'BANCO_PERDIDA' AND APLICACION = '1' ORDER BY NEWID()) AS T5,\n" +
                                "(SELECT TOP(1) OPCION AS DIVISAC FROM VLR_VARIABLE WHERE VARIABLE = 'DIVISA' ORDER BY NEWID()) AS T6");

                while (bd.next()) {
                    String usuario = bd.getString(1);
                    String password = bd.getString(2);
                    String nrodocumento = bd.getString(3);
                    double ingresoneto = bd.getDouble(4);
                    String nropagare = bd.getString(5);
                    String divisa = bd.getString(6);
                    String tiporelacionlaboral = bd.getString(7);
                    String segurodesc = bd.getString(8);
                    String entidad = bd.getString(9);
                    String divisac = bd.getString(10);

                    actor.attemptsTo(
                            LoginActions.usuario(usuario),
                            LoginActions.password(password),
                            LoginActions.entrar(),
                            BandejaCotizacionesFDNActions.nuevacotizacion(),
                            SolicitudNuevoActions.tipodocumento("DNI"),
                            SolicitudNuevoActions.nrodocumento(nrodocumento),
                            SolicitudNuevoActions.buscarcliente(),
                            //SolicitudNuevoActions.nombrecliente(escliente),
                            SolicitudNuevoActions.macroproducto(macroproducto),
                            SolicitudNuevoActions.producto(producto),
                            SolicitudNuevoActions.modalidad(modalidad),
                            SolicitudNuevoActions.nropagare(nropagare, modalidad),
                            SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"),
                            SolicitudNuevoActions.relacionlaboral(tiporelacionlaboral),
                            SolicitudNuevoActions.ingresonetoconsustento(ingresoneto, requieresustento),
                            SolicitudNuevoActions.importe(divisa),
                            SolicitudNuevoActions.montooperacion(monto),
                            SolicitudNuevoActions.garantia("SIN GARANTIA"),
                            SolicitudNuevoActions.plazo(plazo),
                            SolicitudNuevoActions.nroplazo(nroplazo),
                            SolicitudNuevoActions.opencalendar(),
                            SolicitudNuevoActions.nextmonthcalendar(),
                            SolicitudNuevoActions.okcalendar(),
                            SolicitudNuevoActions.calculartasa(),
                            SolicitudNuevoActions.seguro(seguro,segurodesc),
                            SolicitudNuevoActions.compiteentidad(compiteentidad,entidad,divisac));

                            actor.attemptsTo(
                                    SolicitudNuevoActions.compromiso(compromiso));
                            //SolicitudNuevoActions.guardaroperacion(),
                            //SolicitudNuevoActions.confirmaroperacion());

                }
            } catch (SQLException e) {
                System.out.println("Error connection to the database");
                e.printStackTrace();
            }


        } else {
            try {
                Connection connection = DriverManager.getConnection(connectionString, login, pass);
                System.out.println("Connection established.");

                Statement mystatement = connection.createStatement();
                ResultSet bd = mystatement.executeQuery(
                        "SELECT * FROM (SELECT TOP 1 REGISTRO,PASSWORD FROM ORG_INTEGRANTE2 WHERE PRESENCIA = 1 AND LOGUEO = 1 AND ESTADO = 1 AND ESTADO_SOL_ACTIVACION = 'ACTIVO' AND DESC_CARGO = '"+cargo+"' ORDER BY NEWID()\n" +
                                ") AS T1, (SELECT TOP(1) l.num_doc_identidad as NRODOCUMENTO, I.INGRESO_NETO AS INGRESOS FROM CFG_LLE L INNER JOIN CFG_CLIENTES C ON L.num_doc_identidad = C.NRO_DOCUMENTO \n" +
                                "JOIN CFG_INGRESOS I ON I.NUM_DOC_IDENTIDAD = L.num_doc_identidad\n" +
                                "WHERE L.tip_doc_identidad = '1' AND L.NUM_DOC_IDENTIDAD != ' ' AND C.RANGO_INGRESO != '0.0' AND C.CLIENTE_BIF = '"+clientebif+"' AND C.SEGMENTACION_RIESGOS = '"+segmentacion+"'\n" +
                                "AND L.cliente_bif = '"+clientebif+"' AND L.Segmentacion ='"+segmentacion+"' AND I.TIP_DOC_IDENTIDAD = '1' AND L.num_doc_identidad LIKE '72%' ORDER BY NEWID()) AS T2, \n" +
                                "(SELECT TOP(1) OPCION AS TIPORELACIONLABORAL FROM VLR_VARIABLE WHERE VARIABLE = 'TIPO_REL_LABORAL' AND COD_PRODUCTO = '1' ORDER BY NEWID()) as T3,\n" +
                                "(SELECT TOP(1) DESCRIPCION FROM CFG_SEGUROS WHERE MACROPRODUCTO = '1' AND ESTADO = '1' ORDER BY NEWID()) AS T4,\n" +
                                "(SELECT TOP(1) OPCION AS ENTIDAD FROM VLR_VARIABLE WHERE VARIABLE = 'BANCO_PERDIDA' AND APLICACION = '1' ORDER BY NEWID()) AS T5,\n" +
                                "(SELECT TOP(1) OPCION AS DIVISAC FROM VLR_VARIABLE WHERE VARIABLE = 'DIVISA' ORDER BY NEWID()) AS T6");


                while (bd.next()) {
                    String usuario = bd.getString(1);
                    String password = bd.getString(2);
                    String nrodocumento = bd.getString(3);
                    double ingresoneto = bd.getDouble(4);
                    String nropagare = "";
                    String tiporelacionlaboral = bd.getString(5);
                    String segurodesc = bd.getString(6);
                    String entidad = bd.getString(7);
                    String divisac = bd.getString(8);

                    String dirPath = "d:/EvidenciasMinorista/";

                    XWPFDocument docx = new XWPFDocument();
                    //create header
                    /*XWPFHeaderFooterPolicy headerFooterPolicy = docx.getHeaderFooterPolicy();
                    if (headerFooterPolicy == null) headerFooterPolicy = docx.createHeaderFooterPolicy();
                    XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
                    XWPFParagraph paragraph = header.createParagraph();
                    paragraph.setAlignment(ParagraphAlignment.LEFT);
                    XWPFRun xwpfrunheader = paragraph.createRun();
                    xwpfrunheader.setBold(false);
                    xwpfrunheader.setFontSize(10);
                    xwpfrunheader.setColor("000000");
                    xwpfrunheader.setText("Fecha de Ejecución: "+supportTools.datetime());
                    xwpfrunheader.addBreak();
                    xwpfrunheader.setText("Test Case ID: "+idcaso);
                    */

                    //create title
                    XWPFParagraph title = docx.createParagraph();
                    title.setAlignment(ParagraphAlignment.CENTER);
                    XWPFRun xwpfrun = title.createRun();
                    xwpfrun.setBold(true);
                    xwpfrun.setFontSize(16);
                    xwpfrun.setColor("0070C0");
                    xwpfrun.setText("Evidencia de Pruebas Automatizadas");
                    //create descripción
                    XWPFParagraph text = docx.createParagraph();
                    text.setAlignment(ParagraphAlignment.LEFT);
                    XWPFRun xwpfrunText = text.createRun();
                    xwpfrunText.setFontSize(12);
                    xwpfrunText.setColor("000000");
                    xwpfrunText.setText("Fecha de Ejecución: "+supportTools.datetime());
                    xwpfrunText.addBreak();
                    xwpfrunText.setText("Test Case ID: "+idcaso);
                    xwpfrunText.addBreak();
                    xwpfrunText.setText("Casuística de la prueba:");
                    xwpfrunText.addBreak();

                    //create table 1
                    XWPFTable table = docx.createTable();
                    table.removeBorders();
                    table.setTableAlignment(TableRowAlign.LEFT);
                    table.setWidth("100%");
                    XWPFStyles styles = docx.createStyles();
                    XWPFStyle style = supportTools.createTableStyle(styles, "ListTableStyle");
                    table.setStyleID(style.getStyleId());

                    XWPFTableRow tableRowOne = table.getRow(0);
                    tableRowOne.getCell(0).setText("CAMPOS");
                    tableRowOne.addNewTableCell().setText("VALORES");
                    XWPFTableRow tableRowTwo = table.createRow();
                    tableRowTwo.getCell(0).setText("CARGO");
                    tableRowTwo.getCell(1).setText(cargo);
                    XWPFTableRow tableRowThree = table.createRow();
                    tableRowThree.getCell(0).setText("USUARIO");
                    tableRowThree.getCell(1).setText(usuario);
                    XWPFTableRow tableRowFour = table.createRow();
                    tableRowFour.getCell(0).setText("CLIENTE BANBIF");
                    tableRowFour.getCell(1).setText(clientebif);
                    XWPFTableRow tableRowFive = table.createRow();
                    tableRowFive.getCell(0).setText("SEGMENTACION");
                    tableRowFive.getCell(1).setText(segmentacion);
                    XWPFTableRow tableRowSix = table.createRow();
                    tableRowSix.getCell(0).setText("NRO. DOCUMENTO");
                    tableRowSix.getCell(1).setText(nrodocumento);
                    XWPFTableRow tableRowSeven = table.createRow();
                    tableRowSeven.getCell(0).setText("MACROPRODUCTO");
                    tableRowSeven.getCell(1).setText(macroproducto);
                    XWPFTableRow tableRowEight = table.createRow();
                    tableRowEight.getCell(0).setText("PRODUCTO");
                    tableRowEight.getCell(1).setText(producto);
                    XWPFTableRow tableRowNine = table.createRow();
                    tableRowNine.getCell(0).setText("MODALIDAD");
                    tableRowNine.getCell(1).setText(modalidad);

                    XWPFTableRow tableRowTen = table.createRow();
                    tableRowTen.getCell(0).setText("INGRESO NETO");
                    tableRowTen.getCell(1).setText(""+ingresoneto);
                    XWPFTableRow tableRowEleven = table.createRow();
                    tableRowEleven.getCell(0).setText("¿REQUIERE SUSTENTO DE INGRESOS?");
                    tableRowEleven.getCell(1).setText(requieresustento);
                    XWPFTableRow tableRowTwelve = table.createRow();
                    tableRowTwelve.getCell(0).setText("DIVISA");
                    tableRowTwelve.getCell(1).setText(divisa);
                    XWPFTableRow tableRowThirteen = table.createRow();
                    tableRowThirteen.getCell(0).setText("MONTO");
                    tableRowThirteen.getCell(1).setText(monto);
                    XWPFTableRow tableRowFourteen = table.createRow();
                    tableRowFourteen.getCell(0).setText("PLAZO");
                    tableRowFourteen.getCell(1).setText(plazo);
                    XWPFTableRow tableRowFifteen = table.createRow();
                    tableRowFifteen.getCell(0).setText("NRO. PLAZO");
                    tableRowFifteen.getCell(1).setText(nroplazo);

                    XWPFTableRow tableRowSixteen = table.createRow();
                    tableRowSixteen.getCell(0).setText("SEGURO");
                    tableRowSixteen.getCell(1).setText(seguro);
                    XWPFTableRow tableRowSeventeen = table.createRow();
                    tableRowSeventeen.getCell(0).setText("¿COMPITE CON OTRA ENTIDAD?");
                    tableRowSeventeen.getCell(1).setText(compiteentidad);
                    XWPFTableRow tableRowEighteen = table.createRow();
                    tableRowEighteen.getCell(0).setText("COMPROMISO");
                    tableRowEighteen.getCell(1).setText(compromiso);
                    XWPFTableRow tableRowNineteen = table.createRow();
                    tableRowNineteen.getCell(0).setText("MODIFICACION DE IMPORTE");
                    tableRowNineteen.getCell(1).setText(modificacionimporte);
                    XWPFTableRow tableRowTwenty = table.createRow();
                    tableRowTwenty.getCell(0).setText("DESEMBOLSO O FEEDBACK");
                    tableRowTwenty.getCell(1).setText(desembolsofeedback);


                    System.out.println("create_table.docx written successully");

                    //create screenshots
                    XWPFRun run = docx.createParagraph().createRun();
                    FileOutputStream out = new FileOutputStream(dirPath+"F09-"+iniciativa+" - Pruebas Automatizadas "+idcaso+".docx");

                    actor.attemptsTo(LoginActions.usuario(usuario));
                    actor.attemptsTo(LoginActions.password(password));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(LoginActions.entrar());
                    actor.attemptsTo(BandejaCotizacionesFDNActions.nuevacotizacion());
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.tipodocumento("DNI"));
                    actor.attemptsTo(SolicitudNuevoActions.nrodocumento(nrodocumento));
                    actor.attemptsTo(SolicitudNuevoActions.buscarcliente());
                    actor.attemptsTo(SolicitudNuevoActions.macroproducto("PLD"));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.producto("PTMO. LIBRE DISPONIBILIDAD"));
                    actor.attemptsTo(SolicitudNuevoActions.modalidad(modalidad));
                    actor.attemptsTo(SolicitudNuevoActions.tipoingreso("INGRESO INDIVIDUAL"));
                    actor.attemptsTo(SolicitudNuevoActions.relacionlaboral(tiporelacionlaboral));
                    actor.attemptsTo(SolicitudNuevoActions.ingresonetoconsustento(ingresoneto, requieresustento));
                    actor.attemptsTo(SolicitudNuevoActions.importe(divisa));
                    actor.attemptsTo(SolicitudNuevoActions.montooperacion(monto));
                    actor.attemptsTo(SolicitudNuevoActions.garantia("SIN GARANTIA"));
                    actor.attemptsTo(SolicitudNuevoActions.plazo(plazo));
                    actor.attemptsTo(SolicitudNuevoActions.nroplazo(nroplazo));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.opencalendar());
                    actor.attemptsTo(SolicitudNuevoActions.nextmonthcalendar());
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.okcalendar());
                    actor.attemptsTo(SolicitudNuevoActions.calculartasa());
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.seguro(seguro,segurodesc));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.compiteentidad(compiteentidad,entidad,divisac));
                            supportTools.captureEvidence(run, out, dirPath);
                            UploadFiles.uploadfilecompiteentidad(compiteentidad);
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.aceptacompiteentidad(compromiso));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.compromiso(compromiso));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.guardaroperacion());
                    actor.attemptsTo(SolicitudNuevoActions.confirmaroperacion());
                            supportTools.captureEvidence(run, out, dirPath);
                            SolicitudNuevoValidations.confirmaroperacion();
                    actor.attemptsTo(SolicitudNuevoActions.aceptarperacion());
                            supportTools.captureEvidence(run, out, dirPath);

                    Map<String, String> r =SolicitudNuevoGets.idcotizacion();
                    XWPFTable table2 = docx.createTable();
                    table2.removeBorders();
                    table2.setTableAlignment(TableRowAlign.LEFT);
                    table2.setWidth("100%");
                    table2.setStyleID(style.getStyleId());
                    XWPFTableRow tableRowOne2 = table2.getRow(0);
                    tableRowOne2.getCell(0).setText("COMPONENTES");
                    tableRowOne2.addNewTableCell().setText("RESULTADO REAL");
                    tableRowOne2.addNewTableCell().setText("RESULTADO ESPERADO");
                    XWPFTableRow tableRowTwo2 = table2.createRow();
                    tableRowTwo2.getCell(0).setText("TT");
                    tableRowTwo2.getCell(1).setText(r.get("TT"));
                    tableRowTwo2.getCell(2).setText(r.get("TT_ESPERADO"));
                    XWPFTableRow tableRowThree3 = table2.createRow();
                    tableRowThree3.getCell(0).setText("LLE");
                    tableRowThree3.getCell(1).setText(r.get("LLE"));
                    tableRowThree3.getCell(2).setText("");
                    XWPFTableRow tableRowFour4 = table2.createRow();
                    tableRowFour4.getCell(0).setText("CLUSTER");
                    tableRowFour4.getCell(1).setText(r.get("CLUSTER"));
                    tableRowFour4.getCell(2).setText("");
                    XWPFTableRow tableRowFive5 = table2.createRow();
                    tableRowFive5.getCell(0).setText("TASA MINIMA");
                    tableRowFive5.getCell(1).setText(r.get("TASA_MINIMA"));
                    tableRowFive5.getCell(2).setText("");
                    XWPFTableRow tableRowSix6 = table2.createRow();
                    tableRowSix6.getCell(0).setText("TASA SUGERIDA");
                    tableRowSix6.getCell(1).setText(r.get("TASA_SUGERIDA"));
                    tableRowSix6.getCell(1).setText("");

                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.adjuntarsustentoingresosnetos(requieresustento));
                            supportTools.captureEvidence(run, out, dirPath);
                            UploadFiles.uploadfilerequieresustento(requieresustento);
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.aceptasustentoingresosnetos(requieresustento));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.modificacionimporte(modificacionimporte));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.generarfichaPLD(modificacionimporte,r.get("ID_COTIZACION")));
                            supportTools.captureEvidence(run, out, dirPath);
                            GenerarFicha.abrirfichapricing(r.get("ID_COTIZACION"),r.get("NAME"));
                            supportTools.captureEvidence(run, out, dirPath);
                            GenerarFicha.cerrarfichapricing();
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.desembolsofeedback(desembolsofeedback));
                            supportTools.captureEvidence(run, out, dirPath);
                    actor.attemptsTo(SolicitudNuevoActions.aceptardesembolsofeedback(desembolsofeedback));


                    System.out.println("Write to doc file sucessfully...");
                    docx.write(out);
                    out.flush();
                    out.close();
                    docx.close();
                }

            } catch (SQLException e) {
                System.out.println("Error connection to the database");
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}






