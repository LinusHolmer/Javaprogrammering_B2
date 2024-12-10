package Databashantering.projektUppgiftDB;

import Databashantering.JDBCUtil;
import java.sql.*;

public class DAOImpl implements DAO{

    @Override
    public void insertWorkRole(WorkRole workRole) throws SQLException {
        if(workRole == null) throw new IllegalArgumentException("Work role cannot be null");

        Connection conn = null;
        PreparedStatement pStmt = null;

        String preStatementSQL = """
                INSERT INTO work_role (title, description, salary, creation_date)
                VALUES (?,?,?,?)
                """;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);

            pStmt = conn.prepareStatement(preStatementSQL);
            pStmt.setString(1, workRole.getTitle());
            pStmt.setString(2, workRole.getDescription());
            pStmt.setInt(3, workRole.getSalary());
            pStmt.setDate(4, workRole.getCreationDate());

            pStmt.executeUpdate();
            conn.commit();

            System.out.println("Work role inserted successfully");
        } catch(SQLException e) {
            if (conn != null) conn.rollback();
            throw e;

        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void updateWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        // SQL to update a record in the work_role table
        String updateSQL = """
            UPDATE work_role
            SET title = ?,
                description = ?,
                salary = ?,
                creation_date = ?
            WHERE role_id = ?
            """;

        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement(updateSQL);


            pStmt.setString(1, workRole.getTitle());
            pStmt.setString(2, workRole.getDescription());
            pStmt.setDouble(3, workRole.getSalary());
            pStmt.setDate(4, workRole.getCreationDate()); // Assuming getCreationDate returns java.sql.Date
            pStmt.setInt(5, workRole.getRoleId());

            int rowsAffected = pStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully updated work role with ID: " + workRole.getRoleId());
            } else {
                System.out.println("No work role found with ID: " + workRole.getRoleId());
            }

        } finally {
            // Close resources
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void deleteWorkRole(int input) throws SQLException {
        if (input <= 0) throw new IllegalArgumentException("Role ID must be a positive integer");

        Connection conn = null;
        PreparedStatement pStmt = null;

        String preStatementSQL = """
                DELETE FROM work_role
                WHERE role_id = ?
                """;

        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement(preStatementSQL);
            pStmt.setInt(1, input);

            int rowsAffected = pStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully deleted work role with ID: " + input);
            } else {
                System.out.println("No work role found with ID: " + input);
            }


        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }

    }

    @Override
    public void selectWorkRole(WorkRole workRole, int input) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        String preStatementSQL = """
                SELECT * FROM work_role
                WHERE role_id = ?
                """;
        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement(preStatementSQL);

            pStmt.setInt(1, input);

            rs = pStmt.executeQuery();

            if(rs.next()){
                int role_id = rs.getInt("role_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int salary = rs.getInt("salary");
                java.sql.Date creation_date = rs.getDate("creation_date"); // JDBC:s java.sql.Date

                System.out.println("Role ID: " + role_id + ", " +
                        "Title: " + title + ", " +
                        "Description: " + description + ", " +
                        "Salary: " + salary + ", " +
                        "Creation date: " + creation_date);
            } else {
                System.out.println("No role found with this id " +input);
            }

        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
            JDBCUtil.closeResultSet(rs);
        }

    }

    @Override
    public void selectAllWorkRole(WorkRole workRole) throws SQLException{
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String selectSQL = "SELECT * FROM work_role";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSQL);

            while(rs.next()){
                int role_id = rs.getInt("role_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int salary = rs.getInt("salary");
                java.sql.Date creation_date = rs.getDate("creation_date"); // JDBC:s java.sql.Date

                System.out.println("Role ID: " + role_id + ", " +
                        "Title: " + title + ", " +
                        "Description: " + description + ", " +
                        "Salary: " + salary + ", " +
                        "Creation date: " + creation_date);
            }

        } finally {
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
            JDBCUtil.closeResultSet(rs);
        }

    }
}
