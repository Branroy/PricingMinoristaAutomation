package pe.com.bif.techcases.testautomation.bdconnections;

import java.sql.*;

public class SQLManager {
    private String host;
    private String database;
    private String user;
    private String password;

    public SQLManager(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
    } //"jdbc:sqlserver://bif3pricing20;Database=BIFPricing;TrustServerCertificate=true";
    private Connection createConnection() {
        Connection connection;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://" + host + ";Database=" + database + ";TrustServerCertificate=true", user,
                    password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Could not connect to SQL server! because: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
        }
        return null;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void executeUpdate(String update) {
        Connection connection = createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
}
