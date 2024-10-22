package Lektion4.ovning1SPEL;

public abstract class Enemy {
    private String name;
    private double health;
    private double attackPower;
    private double physicalDefense;
    private double magicalDefense;
    private int level;
    private double maxHealth;


    public Enemy(String name, double health, double attackPower, double physicalDefense, double magicalDefense, int level, double maxHealth) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.level = level;
        this.maxHealth = maxHealth;
    }

    public void physicalAttack(Player player) {
        double damageDealt = attackPower * (1 - player.getPhysicalDefense());
        player.takeDamage(damageDealt);
        System.out.println(name + " attacked " + player.getName() + " for " + damageDealt + " physical damage");
    }

    public void takeDamage(double damage) {
        health -= damage;

    }

    public boolean isAlive(){
        if(health <= 0){
            return false;
        } else {
            return true;
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

    public double getMaxHealth(){ return maxHealth; }


    public abstract void specialAbility();
}
