package Lektion3.ovningARRAYLIST;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Watermelon");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(2));
        stringList.set(1,"Grape");
        stringList.remove(0);
        System.out.println(stringList);
    }
}
