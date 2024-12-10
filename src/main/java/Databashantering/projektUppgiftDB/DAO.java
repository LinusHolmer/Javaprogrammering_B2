package Databashantering.projektUppgiftDB;

import Databashantering.person.Person;

import java.sql.SQLException;

public interface DAO {
    public void insertWorkRole(WorkRole workRole) throws SQLException;
    public void updateWorkRole(WorkRole workRole) throws SQLException;
    public void deleteWorkRole(int input) throws SQLException;
    public void selectWorkRole(WorkRole workRole, int input) throws SQLException;
    public void selectAllWorkRole(WorkRole workRole) throws SQLException;
}
