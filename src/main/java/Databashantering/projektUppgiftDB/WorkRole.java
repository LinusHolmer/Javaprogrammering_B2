package Databashantering.projektUppgiftDB;

import java.sql.Date;
import java.util.Objects;

public class WorkRole {
    private Integer role_id;
    private String title;
    private String description;
    private int salary;
    private java.sql.Date creation_date;

    WorkRole(Integer role_id, String title, String description, int salary, java.sql.Date creation_date){
        this.role_id = role_id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }
    WorkRole(String title, String description, int salary, java.sql.Date creation_date){
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkRole workRole = (WorkRole) o;
        return salary == workRole.salary && Objects.equals(role_id, workRole.role_id) && Objects.equals(title, workRole.title) && Objects.equals(description, workRole.description) && Objects.equals(creation_date, workRole.creation_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, title, description, salary, creation_date);
    }

    public Integer getRoleId() {
        return role_id;
    }

    public void setRoleId(Integer role_id) {
        this.role_id = role_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(Date creation_date) {
        this.creation_date = creation_date;
    }
}
