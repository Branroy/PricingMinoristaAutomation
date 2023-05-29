package pe.com.bif.techcases.testautomation.bdconnections;

import java.sql.*;

public class connectionSql {
     public static void main(String[] args) {

         // NOTE: in the connection string:
         // - Change bif3pricing20
         // - Change BIFPricing-
         // IntegratedSecury=true
         String cargo ="EJECUTIVO BANCA PERSONAS SENIOR";
         String clientebif="1";
         String segmentacion="2";


         String connectionString =
                 "jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";

         String login =
                 "usr_princing";

         String pass =
                 "43#pr1@8";

         try{
             Connection connection = DriverManager.getConnection(connectionString,login,pass);
             System.out.println("Connection established.");


             Statement mystatement = connection.createStatement();
             ResultSet bd = mystatement.executeQuery(
                     "SELECT * FROM (SELECT TOP 1 REGISTRO,PASSWORD FROM ORG_INTEGRANTE2 WHERE PRESENCIA = 1 AND LOGUEO = 1 AND ESTADO = 1 AND ESTADO_SOL_ACTIVACION = 'ACTIVO' AND DESC_CARGO = '"+cargo+"' ORDER BY NEWID()\n" +
                             ") AS T1, (SELECT TOP(1) l.num_doc_identidad as NRODOCUMENTO, I.INGRESO_NETO AS INGRESOS, D.COD_CUENTA AS NROPAGARE, D.DIVISA AS DIVISA FROM CFG_LLE L INNER JOIN CFG_CLIENTES C ON L.num_doc_identidad = C.NRO_DOCUMENTO \n" +
                             "JOIN CFG_INGRESOS I ON I.NUM_DOC_IDENTIDAD = L.num_doc_identidad\n" +
                             "JOIN CFG_INFOADICIONAL_DESEMBOLSOS D ON D.NRO_DOCUMENTO = L.num_doc_identidad\n" +
                             "WHERE L.tip_doc_identidad = '1' AND L.NUM_DOC_IDENTIDAD != ' ' AND C.RANGO_INGRESO != '0.0' AND C.CLIENTE_BIF = '"+clientebif+"' AND C.SEGMENTACION_RIESGOS = '"+segmentacion+"'\n" +
                             "AND L.cliente_bif = '"+clientebif+"' AND L.Segmentacion ='"+segmentacion+"' AND I.TIP_DOC_IDENTIDAD = '1' ORDER BY NEWID()) AS T2,\n" +
                             "(SELECT TOP(1) OPCION AS TIPORELACIONLABORAL FROM VLR_VARIABLE WHERE VARIABLE = 'TIPO_REL_LABORAL' AND COD_PRODUCTO = '1' ORDER BY NEWID()) as T3");

             while (bd.next()) {
                 String usuario = bd.getString(1);
                 String password = bd.getString(2);
                 String nrodocumento = bd.getString(3);
                 double ingresoneto = bd.getDouble(4);
                 String nropagare = "";
                 String tiporelacionlaboral = bd.getString(5);

                 System.out.println(usuario+" "+password+" "+nrodocumento+" "+ingresoneto+" "+nropagare+""+tiporelacionlaboral);
             }
         }
             catch (SQLException e){
             System.out.println("Error connection to the database");
             e.printStackTrace();
         }



     }
}
