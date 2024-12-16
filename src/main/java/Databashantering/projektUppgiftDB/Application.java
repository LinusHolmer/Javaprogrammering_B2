package Databashantering.projektUppgiftDB;

import Databashantering.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static Scanner scan = new Scanner(System.in);
    private static DAOImpl dao = new DAOImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nVälj ett alternativ:");
            System.out.println("1. Skapa ny arbetsroll");
            System.out.println("2. Ta bort en arbetsroll");
            System.out.println("3. Visa alla arbetsroller");
            System.out.println("4. Visa en arbetsroll");
            System.out.println("5. Uppdatera en arbetsroll");
            System.out.println("6. Logga in och se din arbetsroll");
            System.out.println("7. Avsluta");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    insertWorkRole();
                    break;
                case 2:
                    deleteWorkRole();
                    break;
                case 3:
                    selectAllWorkRole();
                    break;
                case 4:
                    selectWorkRole();
                    break;
                case 5:
                    updateWorkRole();
                    break;
                case 6:
                    loginAndShowRole();
                    break;
                case 7:
                    System.out.println("Avslutar applikationen...");
                    return;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    private static void insertWorkRole() {
        System.out.println("Ange titel:");
        String title = scan.nextLine();
        System.out.println("Ange beskrivning:");
        String description = scan.nextLine();
        System.out.println("Ange lön:");
        int salary = scan.nextInt();
        scan.nextLine();
        System.out.println("Ange skapelsedatum (yyyy-mm-dd):");
        String dateStr = scan.nextLine();
        Date creationDate = Date.valueOf(dateStr);

        WorkRole workRole = new WorkRole(title, description, salary, creationDate);
        try {
            dao.insertWorkRole(workRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteWorkRole() {
        System.out.println("Ange arbetsroll-ID att ta bort:");
        int roleId = scan.nextInt();
        scan.nextLine();
        WorkRole workRole = new WorkRole();
        workRole.setRoleId(roleId);
        try {
            dao.deleteWorkRole(workRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAllWorkRole() {
        try {
            dao.selectAllWorkRole();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectWorkRole() {
        System.out.println("Ange arbetsroll-ID att visa:");
        int roleId = scan.nextInt();
        scan.nextLine();
        WorkRole workRole = new WorkRole();
        workRole.setRoleId(roleId);
        try {
            dao.selectWorkRole(workRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateWorkRole() {
        System.out.println("Ange arbetsroll-ID att uppdatera:");
        int roleId = scan.nextInt();
        scan.nextLine();
        System.out.println("Ange ny titel:");
        String title = scan.nextLine();
        System.out.println("Ange ny beskrivning:");
        String description = scan.nextLine();
        System.out.println("Ange ny lön:");
        int salary = scan.nextInt();
        scan.nextLine();
        System.out.println("Ange nytt skapelsedatum (yyyy-mm-dd):");
        String dateStr = scan.nextLine();
        Date creationDate = Date.valueOf(dateStr);

        WorkRole workRole = new WorkRole(roleId, title, description, salary, creationDate);
        try {
            dao.updateWorkRole(workRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loginAndShowRole() {
        System.out.println("Ange email:");
        String email = scan.nextLine();
        System.out.println("Ange lösenord:");
        String password = scan.nextLine();
        Connection conn = null;

        try {
            conn = JDBCUtil.getConnection();

            String sql = """
                SELECT e.name, e.email, r.title, r.description, r.salary
                FROM employee e
                JOIN work_role r ON e.role_id = r.role_id
                WHERE e.email = ? AND e.password = ?
            """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String roleTitle = rs.getString("title");
                String roleDescription = rs.getString("description");
                int roleSalary = rs.getInt("salary");
                System.out.println("Välkommen " + name + "!");
                System.out.println("Din arbetsroll: " + roleTitle);
                System.out.println("Beskrivning: " + roleDescription);
                System.out.println("Lön: " + roleSalary);
            } else {
                System.out.println("Ogiltig email eller lösenord.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
