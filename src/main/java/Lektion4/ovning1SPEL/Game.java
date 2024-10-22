package Lektion4.ovning1SPEL;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Game {
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private GameMap gameMap;
    private Player player;
    private Random random;



    public Game(){

        gameMap = new GameMap();
        player = new Player("",100,1,0,0,50,10,100);
        random = new Random();

    }
    public void start(){
        running = true;
        String playerName = printWelcomeMenu();


        while (running){
            player.setName(playerName);
            System.out.println(player.getName() + " level " + player.getLevel() + " has " +player.getHealth() + " health and " + player.getMana() + " mana.");
            System.out.println(gameMap.getPosition());
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
        if(gameMap.getX() != 0 || gameMap.getY() != 0) {
            List<Enemy> enemies = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                enemies.add(new Goblin());
            }

            for (int i = 0; i < 2; i++) {
                enemies.add(new Wolf());
            }

            enemies.add(new ForestTroll());


            Enemy enemy = enemies.get(random.nextInt(enemies.size()));

            System.out.println("A wild " + enemy.getName() + " appears!");
            System.out.println("attack, spells or flee!");

            boolean battle = true;
            while(battle){
                String battleInput = getUserInput();
                switch (battleInput) {
                    case "attack" -> {
                        player.physicalAttack(enemy);
                        battle = isBattle(enemy);

                    }

                    case "spells" -> {
                        Spell fireball = new Fireball();
                        player.castSpell(fireball,enemy);
                        battle = isBattle(enemy);


                    }

                    case "flee" -> {
                        int fleeChance = random.nextInt(1,3) ;
                        if(fleeChance == 1){
                            System.out.println("You ran away!");
                            battle = false;
                        } else {
                            System.out.println("You failed to flee...");
                            battle = isBattle(enemy);
                        }

                    }
                    default -> System.out.println("Invalid input");
                }

            }
                }

            }

    private boolean isBattle(Enemy enemy) {
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " health");

        if(!enemy.isAlive()){
            System.out.println(enemy.getName() +" has been defeated." );
            return false;
        }

        enemy.physicalAttack(player);
        System.out.println(player.getName() + " has " + player.getHealth() + "/" + player.getMaxHealth() +" health");

        if(!player.isAlive()){
            System.out.println(player.getName() +" has been defeated." );
            running = false;
            return false;
        }
        return true;
    }


}
