package Databashantering.person;

import Databashantering.JDBCUtil;

import java.sql.*;

public class PersonDAOImpl implements PersonDAO{
    @Override
    public void insertPerson(Person person) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        String preStatementSQL = """
                INSERT INTO per (first_name, last_name, gender, income, dob)
                VALUES (?,?,?,?,?)
                """;
        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement(preStatementSQL);

            pStmt.setString(1, person.getFirstName());
            pStmt.setString(2, person.getLastName());
            pStmt.setString(3, person.getGender());
            pStmt.setDouble(4, person.getIncome());
         //   pStmt.setDate(5, java.sql.Date.valueOf());

            pStmt.executeUpdate();
            JDBCUtil.commit(conn);

        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.rollback(conn);
        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }



    @Override
    public void updatePerson(Person person) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        String updateSQL = """
              
                """;

    }

    @Override
    public void deletePerson(Person person) throws SQLException {


    }

    @Override
    public void selectPerson(Person person) throws SQLException {

    }
}
