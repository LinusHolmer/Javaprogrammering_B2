package Databashantering.person;

import Databashantering.JDBCUtil;


import java.sql.*;


//execute() general
//executeUpdate() INSERT, UPDATE, DELETE
//executeQuery SELECT

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String insertSQL = """
           INSERT INTO person (first_name, last_name, gender, dob, income)
                VALUES ('Erik', 'Knöös', 'M', '2003-08-25', 100)
                """;

        String deleteSQL = """
                DELETE FROM person WHERE person_id IN (0);
                """;

        String updateSQL = """
                UPDATE person 
                SET person_id = 1 
                WHERE person_id = 3
                """;

        String resetSequenceSQL = """
                ALTER TABLE person ALTER COLUMN person_id RESTART WITH 1
                """;

        String preStatementSQL = """
                INSERT INTO person (first_name, last_name, gender, dob, income)
                VALUES (?,?,?,?,?)
                """;


        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            //int rowsAffected = stmt.executeUpdate(deleteSQL);


            PreparedStatement pstmt = conn.prepareStatement(preStatementSQL);
            pstmt.setString(1, "Johan");
            pstmt.setString(2, "Hammerin");
            pstmt.setString(3, "M");
            pstmt.setString(4, "2004-01-03");
            pstmt.setString(5, "10");
            pstmt.executeUpdate();

            JDBCUtil.commit(conn);

            String name = JDBCUtil.getDatabaseProductName(conn);
            System.out.println("Connected to database: " +name);

           // System.out.println("Rows affected: " + rowsAffected);

            String selectSQL = "select * from person";
            rs = stmt.executeQuery(selectSQL);

            while(rs.next()){
                //getInt() hämtar ett integer-värde
                int personId = rs.getInt("person_id");
                //getString() hämtar ett String-värde
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                //getDate() hämtar ett datum-värde
                java.sql.Date dob = rs.getDate("dob"); // JDBC:s java.sql.Date
                //getDouble() hämtar ett double-värde
                double income = rs.getDouble("income");

                System.out.println("Person ID: " + personId + ", " +
                        "First Name: " + firstName + ", " +
                        "Last Name: " + lastName + ", " +
                        "Gender: " + gender + ", " +
                        "Date of Birth: " + dob + ", " +
                        "Income: " + income);
            }




        } catch (SQLException e) {
            e.printStackTrace();

            JDBCUtil.rollback(conn);
        } finally {
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
            JDBCUtil.closeResultSet(rs);
        }


    }
}
