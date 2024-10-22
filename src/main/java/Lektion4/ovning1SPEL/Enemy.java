package Lektion4.ovning1SPEL;

public abstract class Enemy {
    private String name;
    private double health;
    private double attackPower;
    private double physicalDefense;
    private double magicalDefense;
    private int level;


    public Enemy(String name, int health, int attackPower, int physicalDefense, int magicalDefense, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.level = level;
    }

    public void physicalAttack(Player player) {
        double damageDealt = attackPower - player.getPhysicalDefense();
        player.takeDamage(damageDealt);
        System.out.println(name + " attacked " + player.getName() + " for " + damageDealt + " physical damage");
    }

    public void magicalAttack(Player player) {
        double damageDealt = attackPower - player.getMagicalDefense();
        player.takeDamage(damageDealt);
        System.out.println(name + " attacked " + player.getName() + " for " + damageDealt + " magical damage");
    }

    public void takeDamage(double damage) {
        health -= damage;
        System.out.println(name + " took " + damage + " damage.");
        if (health <= 0) {
            System.out.println(name + "has been defeated");
        }

    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public double getMagicalDefense() {
        return magicalDefense;
    }

    public int getLevel() {
        return level;
    }

    public abstract void specialAbility();
}
