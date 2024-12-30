package Databashantering.projektUppgiftDB;

import java.util.Objects;

public class Employee {
    private Integer employeeId;
    private String name;
    private String email;
    private String password;
    private Integer roleId;

    public Employee(Integer employeeId, String name, String email, String password, Integer roleId) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Employee(String name, String email, String password, Integer roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && Objects.equals(roleId, employee.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, email, password, roleId);
    }
}
