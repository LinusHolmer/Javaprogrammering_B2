package Lektion4.ovning1SPEL;


import java.util.*;

public class Game {
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private GameMap gameMap;
    private Player player;
    private Random random;
    private Inventory inventory;
    private Item item;
    private Town town;



    public Game(){
        gameMap = new GameMap();
        player = new Player("",100,1,0,0,50,10,100, 0,100,50);
        random = new Random();
        inventory = new Inventory();
        item = new WoodenSword();
        town = new Town();

    }
    public void start(){
        running = true;
        String playerName = printWelcomeMenu();
        player.setName(playerName);


        while (running){

            System.out.println(player.getName() + " level " + player.getLevel() + " has " +player.getHealth()
                    + "/" +player.getMaxHealth()  + " health and " + player.getMana() + "/" + player.getMaxMana() + " mana.");

            System.out.println(gameMap.getPosition());

            if(gameMap.getX() == 0 && gameMap.getY() == 0){
                town.townMenu(inventory, item);
            }

            encounterEnemy();

            if(!running){
                break;
            }

            String userInput = getUserInput();
            running = processInput(userInput);


        }
    }
    public String printWelcomeMenu(){
        System.out.println("Welcome to Game! Choose your name hero.");
        String playerName = scan.nextLine();
        System.out.println("Welcome " + playerName);
        System.out.println("Commands: north, south, east, west, inventory, town, quit");
        return playerName;
    }
    public String getUserInput(){
        return scan.nextLine();
    }
    public boolean processInput(String input) {
        switch (input.toLowerCase()) {
            case "north" -> gameMap.moveNorth();
            case "south" -> gameMap.moveSouth();
            case "east" -> gameMap.moveEast();
            case "west" -> gameMap.moveWest();
            case "inventory" -> inventory.displayInventory();
            case "town" -> gameMap.moveTown();

            case "quit" -> {
                return false;
            }
            default -> System.out.println("Invalid input");
        }
        return true;
    }

    public void encounterEnemy() {
        if(gameMap.getX() != 0 || gameMap.getY() != 0){

        int encounterChance = random.nextInt(10) + 1;
        if (encounterChance > 7) {
            Enemy enemy = getRandomEnemy();
            Combat combat = new Combat(player, enemy);
            combat.startCombat();

            if (!player.isAlive()) {
                running = false;
            }
        } else {
            System.out.println("It is quiet.");
        }
    }
    }

    public Enemy getRandomEnemy(){
        List<Enemy> enemies = new ArrayList<>();
        enemies.addAll(Collections.nCopies(5, new Goblin()));
        enemies.addAll(Collections.nCopies(2, new Wolf()));
        enemies.add(new ForestTroll());

        return enemies.get(random.nextInt(enemies.size()));
    }



}
