package Databashantering.person;

import java.sql.SQLException;

public interface PersonDAO {
    public void insertPerson(Person person) throws SQLException;
    public void updatePerson(Person person) throws SQLException;
    public void deletePerson(Person person) throws SQLException;
    public void selectPerson(Person person) throws SQLException;
}
