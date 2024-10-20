package Lektion4.ovning1SPEL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean running = true;

        while (running){
            System.out.println("go north\ngo south\ngo east\ngo west\nquit");
            String userInput = scan.nextLine();

            switch(userInput){
                case "go north" -> System.out.println("Going north");
                case "go south" -> System.out.println("Going south");
                case "go east" -> System.out.println("Going east");
                case "go west" -> System.out.println("Going west");
                case "quit" -> running = false;
                default -> System.out.println("Invalid input");
            }


        }

    }
}
