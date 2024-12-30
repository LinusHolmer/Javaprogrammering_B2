package Databashantering.person;
import java.sql.Date;
import java.util.Objects;

public class Person {
    private Integer personId;
    private String firstName;
    private String lastName;
    private String gender;
    private double income;
    private java.sql.Date dob;

    Person (Integer personId, String firstName, String lastName, String gender, double income, java.sql.Date dob){
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.income = income;
        this.dob = dob;
    }

    Person (String firstName, String lastName, String gender, double income, java.sql.Date dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.income = income;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(income, person.income) == 0 && Objects.equals(personId, person.personId) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(gender, person.gender) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstName, lastName, gender, income, dob);
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
