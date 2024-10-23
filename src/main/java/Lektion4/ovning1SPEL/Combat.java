package Lektion4.ovning1SPEL;

import java.util.*;

public class Combat {
    private Player player;
    private Enemy enemy;
    private Random random = new Random();

    public Combat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startCombat() {
        System.out.println("A wild " + enemy.getName() + " appears!");
        boolean battle = true;

        while (battle) {
            System.out.println("attack, fireball, heal or flee!");
            String battleInput = getUserInput();

            switch (battleInput) {
                case "attack" -> playerAttack();
                case "fireball" -> castFireball();
                case "heal" -> castHeal();
                case "flee" -> battle = attemptFlee();
                default -> System.out.println("Invalid input");
            }


            if (!player.isAlive() || !enemy.isAlive()) {
                battle = false;
            }
        }

        if (!player.isAlive()) {
            System.out.println(player.getName() + " has been defeated!");
        } else if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " has been defeated!");
        }
    }

    private void playerAttack() {
        player.physicalAttack(enemy);
        getEnemyHealth();
        enemyAttack();
    }

    private void castFireball() {
        Spell fireball = new Fireball();
        player.castSpell(fireball, enemy);
        getEnemyHealth();
        enemyAttack();
    }

    private void castHeal() {
        Spell heal = new Heal();
        player.castSelfSpell(heal, player);
    }

    private void enemyAttack() {
        if (enemy.isAlive()) {
            enemy.physicalAttack(player);
            System.out.println(player.getName() + " has " + player.getHealth() + "/" + player.getMaxHealth() + " health remaining.");
        }
    }

    private boolean attemptFlee() {
        int fleeChance = random.nextInt(2);
        if (fleeChance == 0) {
            System.out.println("You ran away!");
            return false;
        } else {
            System.out.println("You failed to flee...");
            enemyAttack();
            return true;
        }
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private void getEnemyHealth(){
        System.out.println(enemy.getName() + " has " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " health remaining.");
    }
}

