package Databashantering.ovning1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Driver hsqlDriver = new org.hsqldb.jdbcDriver();
        DriverManager.registerDriver(hsqlDriver);

        String url = "jdbc:hsqldb:hsql://localhost/jdbclab";

        Connection conn = DriverManager.getConnection(url, "sa", "");
        System.out.println("Anslutning lyckades");

        /*
        conn.setAutoCommit(false);
        // Execute SQL statements
        conn.commit();
        System.out.println("Ändringarna har sparats.");



        try {
            // Execute SQL statements
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transaktionen återställd.");
        }
        conn.close();
        */
    }
}
