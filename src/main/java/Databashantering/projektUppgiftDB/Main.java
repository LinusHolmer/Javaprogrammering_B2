package Databashantering.projektUppgiftDB;

import java.sql.Date;
import java.sql.SQLException;

//ALTER TABLE work_role ALTER COLUMN role_id RESTART WITH 1;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAOImpl dao = new DAOImpl();

        try {
            WorkRole newRole = new WorkRole("Developer", "Writes code", 55000, Date.valueOf("2024-12-14"));
            dao.insertWorkRole(newRole);

            dao.selectAllWorkRole();

            dao.selectWorkRole(newRole);

            newRole.setTitle("Senior Developer");
            dao.updateWorkRole(newRole);

            dao.selectWorkRole(newRole);

            dao.deleteWorkRole(newRole);

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
