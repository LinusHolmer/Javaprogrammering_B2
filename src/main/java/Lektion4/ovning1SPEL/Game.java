package Lektion4.ovning1SPEL;

import java.util.Scanner;

public class Game {
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private static final String WEST = "west";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String TOWN_CENTER = "town center";
    private static final String START = "start";
    private static String currentLocation = START;

    public void start(){
        running = true;
        printWelcomeMenu();
        townCentre();
        while (running){
            String userInput = getUserInput();
            running = processInput(userInput);
        }

    }

    public void printWelcomeMenu(){
        System.out.println("Welcome to Game, type direction to go in");
        System.out.println("go north\ngo south\ngo east\ngo west\ngo town\nquit");
    }
    public String getUserInput(){
        return scan.nextLine();
    }
    public boolean processInput(String input) {
        switch (input) {
            case "go north" -> north();
            case "go south" -> south();
            case "go east" -> east();
            case "go west" -> west();
            case "go town" -> townCentre();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Invalid input");
        }
        return true;
    }

    public void townCentre(){
        if(!currentLocation.equals(TOWN_CENTER)){
            System.out.println("You are in the middle of town, whats next?");
            currentLocation = TOWN_CENTER;
        } else{
            System.out.println("You cant go there");
        }

    }
    public void north(){
        if(currentLocation.equals(TOWN_CENTER)){
            currentLocation = NORTH;
            System.out.println("You go north");
        } else {
            System.out.println("You cant go here");
        }
    }
    public void south(){
        if(currentLocation.equals(TOWN_CENTER)){
            currentLocation = SOUTH;
            System.out.println("You go south");
        } else {
            System.out.println("You cant go here");
        }
    }
    public void east(){
        if(currentLocation.equals(TOWN_CENTER)){
            currentLocation = EAST;
            System.out.println("You go east");
        } else {
            System.out.println("You cant go here");
        }
    }
    public void west(){
        if(currentLocation.equals(TOWN_CENTER)){
            currentLocation = WEST;
            System.out.println("You go west");
        } else {
            System.out.println("You cant go here");
        }
    }
}
