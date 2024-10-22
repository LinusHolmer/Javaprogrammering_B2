package Lektion4.ovning1SPEL;

import java.util.Scanner;

public class Game {
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private GameMap gameMap;
    private Player player;

    public Game(){
        gameMap = new GameMap();
    }
    public void start(){
        running = true;
        String playerName = printWelcomeMenu();


        while (running){
            Player player = new Player(playerName,100,1,0,0,50 , 10);
            System.out.println(player.getName() + " level " + player.getLevel() + " has " +player.getHealth() + "health and " + player.getMana() + " mana.");


            String userInput = getUserInput();
            running = processInput(userInput);
            gameMap.getPosition();
        }
    }
    public String printWelcomeMenu(){
        System.out.println("Welcome to Game! Choose your name hero.");
        String playerName = scan.nextLine();
        System.out.println("Welcome " + playerName);
        System.out.println("Commands: north, south, east, west, town, quit");
        return playerName;
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

    public void encounterEnemy(){
        if(gameMap.getX() > 1)
        Enemy enemy = new Goblin();

        System.out.println("A wild " + enemy.getName() + " appears!");

        enemy.physicalAttack(player);

        player.physicalAttack(enemy);
    }



}
