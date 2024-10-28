package Lektion4.ovning1SPEL;

public abstract class Enemy {
    private String name;
    private double health;
    private double attackPower;
    private double physicalDefense;
    private double magicalDefense;
    private int level;
    private double maxHealth;
    private double experience;


    public Enemy(String name, double health, double attackPower, double physicalDefense, double magicalDefense, int level, double maxHealth, double experience) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.level = level;
        this.maxHealth = maxHealth;
        this.experience = experience;
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
        return !(health <= 0);
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

    public double getExperience() { return experience; }

    public void setName(String name) { this.name = name; }

    public void setHealth(double health) { this.health = health; }

    public void setAttackPower(double attackPower) { this.attackPower = attackPower; }

    public void setPhysicalDefense(double physicalDefense) { this.physicalDefense = physicalDefense; }

    public void setMagicalDefense(double magicalDefense) { this.magicalDefense = magicalDefense; }

    public void setLevel(int level) { this.level = level; }

    public void setMaxHealth(double maxHealth) { this.maxHealth = maxHealth; }

    public void setExperience(double experience) { this.experience = experience; }

    public abstract void specialAbility();
}
