package Lektion4.ovning1SPEL;

import java.util.Scanner;

public class Game {
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private GameMap gameMap;

    public Game(){
        gameMap = new GameMap();
    }
    public void start(){
        running = true;
        printWelcomeMenu();

        while (running){
            String userInput = getUserInput();
            running = processInput(userInput);
            gameMap.getPosition();
        }
    }
    public void printWelcomeMenu(){
        System.out.println("Welcome to Game! You can move in directions or quit.");
        System.out.println("Commands: north, south, east, west, town, quit");
    }
    public String getUserInput(){
        return scan.nextLine();
    }
    public boolean processInput(String input) {
        switch (input) {
            case "north" -> gameMap.moveNorth();
            case "south" -> gameMap.moveSouth();
            case "east" -> gameMap.moveEast();
            case "west" -> gameMap.moveWest();
            case "town" -> gameMap.moveTown();

            case "quit" -> {
                return false;
            }
            default -> System.out.println("Invalid input");
        }
        return true;
    }
}
