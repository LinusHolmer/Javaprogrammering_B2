package Databashantering.projektUppgiftDB;

import Databashantering.JDBCUtil;

import java.sql.*;


public class DAOImpl implements DAO{

    @Override
    public void insertWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        String preStatementSQL = """
                INSERT INTO work_role (title, description, salary, creation_date)
                VALUES (?,?,?,?)
                """;
        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement(preStatementSQL);

            pStmt.setString(1, workRole.getTitle()) ;
            pStmt.setString(2, workRole.getDescription());
            pStmt.setInt(3, workRole.getSalary());
            pStmt.setDate(4, workRole.getCreation_date());

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
    public void updateWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        String updateSQL = """
                
                """;
    }

    @Override
    public void deleteWorkRole(WorkRole workRole) throws SQLException {

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
        String selectSQL = "select * from work_role";

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
