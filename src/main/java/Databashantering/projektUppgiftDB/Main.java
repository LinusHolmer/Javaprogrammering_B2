package Databashantering.projektUppgiftDB;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAOImpl daoimpl = new DAOImpl();
        WorkRole workRole = new WorkRole();
        //WorkRole workRole1 = new WorkRole("pengarkillenn", "har pengar", 10, new Date(System.currentTimeMillis()));
        daoimpl.deleteWorkRole(1);
    }
}
