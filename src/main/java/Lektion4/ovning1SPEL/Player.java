package Lektion4.ovning1SPEL;

public class Player {
    private String name;
    private double health;
    private double level;
    private double physicalDefense;
    private double magicalDefense;
    private double mana;
    private double attackPower;

    public Player(String name, double health, int level, double physicalDefense, double magicalDefense, int mana, int attackPower) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.mana = mana;
        this.attackPower = attackPower;

    }

    public void takeDamage(double damage ){
        health -= damage;
        System.out.println(name + " took " + damage + " damage.");
        if(health <= 0){
            System.out.println("You have been defeated.");

        }
    }

    public void physicalAttack(Enemy enemy) {
        double damageDealt = attackPower - enemy.getPhysicalDefense();
        enemy.takeDamage(damageDealt);
        System.out.println(name + " attacked " + enemy.getName() + " for " + damageDealt + " physical damage");
    }

    public void magicalAttack(Enemy enemy) {
        double damageDealt = attackPower - enemy.getMagicalDefense();
        enemy.takeDamage(damageDealt);
        System.out.println(name + " attacked " + enemy.getName() + " for " + damageDealt + " magical damage");
    }


    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getLevel() {
        return level;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public double getMagicalDefense() {
        return magicalDefense;
    }

    public double getMana() {
        return mana;
    }

}
