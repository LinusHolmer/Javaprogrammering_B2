package Lektion3.ovningARRAYLIST;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName){
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void printStudent(String studentId){
        for(Student student : students){
        if (student.getStudentId().equals(studentId)) {
            System.out.println(student);
            break;
        }
        }
    }
    public void printStudents(){
        for (Student student : students){
            System.out.println(student);
        }
    }
}
