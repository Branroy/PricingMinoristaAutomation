package pe.com.bif.techcases.testautomation.bdconnections;

import java.sql.*;

public class connectionSql {
     public static void main(String[] args) {

         // NOTE: in the connection string:
         // - Change bif3pricing20
         // - Change BIFPricing-
         // IntegratedSecury=true

         String connectionString =
                 "jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";

         String login =
                 "usr_princing";

         String password =
                 "43#pr1@8";


         String cargo = "GERENTE DE OFICINA";
         try{
             Connection connection = DriverManager.getConnection(connectionString,login,password);
             System.out.println("Connection established.");

             Statement mystatement = connection.createStatement();

             ResultSet miresult = mystatement.executeQuery(
                     "SELECT TOP 1 REGISTRO,PASSWORD FROM ORG_INTEGRANTE2 " +
                             "WHERE PRESENCIA = 1 AND LOGUEO = 1 AND ESTADO = 1 AND ESTADO_SOL_ACTIVACION = 'ACTIVO' " +
                             "AND DESC_CARGO = '"+cargo+"' ORDER BY NEWID()");

             while (miresult.next()){
                 System.out.println(miresult.getString(1)+" "+miresult.getString(2));

             }

         } catch (SQLException e){
             System.out.println("Error connection to the database");
             e.printStackTrace();
         }



     }
}
