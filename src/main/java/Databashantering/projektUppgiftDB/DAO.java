package Databashantering.projektUppgiftDB;

import Databashantering.person.Person;

import java.sql.SQLException;

public interface DAO {
    public void insertWorkRole(WorkRole workRole) throws SQLException;
    public void updateWorkRole(WorkRole workRole) throws SQLException;
    public void deleteWorkRole(WorkRole workRole) throws SQLException;
    public void selectWorkRole(WorkRole workRole) throws SQLException;
    public void selectAllWorkRole() throws SQLException;
}
