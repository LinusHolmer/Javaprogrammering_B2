package Lektion3.ovningARRAYLIST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Watermelon");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(2));
        stringList.set(1,"Grape");
        stringList.remove(0);
        System.out.println(stringList);



        List untypedList = new ArrayList();
        untypedList.add("Hello");
        untypedList.add(42);

        String text = (String) untypedList.get(0);

        int number = (int) untypedList.get(1);

        System.out.println(untypedList);
        System.out.println(text + number);



        List<String> stringList = new ArrayList<>();
        stringList.add("hej");
        stringList.add("jag");
        stringList.add("är");
        stringList.add("cool");

        for(String text : stringList){
            System.out.println(text);



        List<String> tasks = new LinkedList<>();
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");

        System.out.println(tasks);

        tasks.remove(0);

        System.out.println(tasks);
         */

        Course newCourse = new Course("Math");
        newCourse.addStudent(new Student("Linus","0"));
        newCourse.addStudent(new Student("Johan","1"));
        newCourse.printStudent("0");
        newCourse.printStudents();
        }


    }

