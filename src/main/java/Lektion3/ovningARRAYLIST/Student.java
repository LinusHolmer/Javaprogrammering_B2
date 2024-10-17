package Lektion3.ovningARRAYLIST;

public class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }
    // Getter-Methods
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
