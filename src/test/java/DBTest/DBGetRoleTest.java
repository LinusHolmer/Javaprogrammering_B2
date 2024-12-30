package DBTest;

import Databashantering.JDBCUtil;
import Databashantering.projektUppgiftDB.DAOImpl;
import Databashantering.projektUppgiftDB.WorkRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DBGetRoleTest {
    private DAOImpl dao;
    private WorkRole testWorkRole;

    @BeforeEach
    public void setUp() {
        dao = new DAOImpl();
        testWorkRole = new WorkRole("Developer", "Writes code", 55000, Date.valueOf("2024-12-14"));
    }

    @Test
    public void testInsertWorkRoleAndFetchById() throws SQLException {
        dao.insertWorkRole(testWorkRole);

        WorkRole fetchedRole = null;
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM work_role WHERE role_id = " + testWorkRole.getRoleId());

            if (rs.next()) {
                fetchedRole = new WorkRole(
                        rs.getInt("role_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("salary"),
                        rs.getDate("creation_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occurred while fetching work role.", e);
        } finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
        assertNotNull(fetchedRole, "work role should be fetched from the database");
        assertEquals(testWorkRole.getRoleId(), fetchedRole.getRoleId(), "role IDs should match");
        assertEquals(testWorkRole.getTitle(), fetchedRole.getTitle(), "titles should match");
        assertEquals(testWorkRole.getDescription(), fetchedRole.getDescription(), "descriptions should match");
        assertEquals(testWorkRole.getSalary(), fetchedRole.getSalary(), "salaries should match");
        assertEquals(testWorkRole.getCreationDate(), fetchedRole.getCreationDate(), "creation dates should match");
    }

    @AfterEach
    public void cleanUp() {
        Connection conn = null;
        Statement stmt = null;
        dao = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS work_role");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }

    }

}
