package pe.com.bif.techcases.testautomation.bdconnections;

import java.sql.ResultSet;

public class PruebaConexion {
    public static void main(String[] args) {
        SQLManager manager = new SQLManager("bif3pricing20", "BIFPricing", "usr_princing", "43#pr1@8");
        /*manager.executeUpdate("create database if not exists base");
        manager.executeUpdate("use base");
        manager.executeUpdate("create table if not exists msg (id int primary key auto_increment, nombre varchar(45))");*/
        //crear n tablas...
        //Queries
        String sql = "SELECT TOP(1) num_doc_identidad FROM CFG_LLE L INNER JOIN CFG_CLIENTES C ON L.num_doc_identidad = C.NRO_DOCUMENTO WHERE\n" +
                "L.tip_doc_identidad = '1' AND L.NUM_DOC_IDENTIDAD != ' ' AND C.RANGO_INGRESO != '0.0' AND C.CLIENTE_BIF = '0' AND C.SEGMENTACION_RIESGOS = '4'\n" +
                "AND L.cliente_bif = '0' AND L.Segmentacion ='4'\n" +
                "ORDER BY NEWID();";
        ResultSet rs = manager.executeQuery(sql);
    }

}

