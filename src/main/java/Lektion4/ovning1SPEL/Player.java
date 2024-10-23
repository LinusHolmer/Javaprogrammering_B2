package Lektion4.ovning1SPEL;

public class Player {
    private String name;
    private double health;
    private double level;
    private double physicalDefense;
    private double magicalDefense;
    private double mana;
    private double attackPower;
    private double maxHealth;

    public Player(String name, double health, int level, double physicalDefense, double magicalDefense, int mana, int attackPower, double maxHealth) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.mana = mana;
        this.attackPower = attackPower;
        this.maxHealth = maxHealth;

    }

    public void takeDamage(double damage ){
        health -= damage;
    }

    public void healPlayer(double amount){
        health += amount;
    }

    public void reduceMana(double amount){
        mana -= amount;
    }

    public void castSpell(Spell spell, Enemy enemy){
        if(mana >= spell.getManaCost()){
            spell.cast(this, enemy);
        } else {
            System.out.println("You do not have enough mana.");
        }
    }

    public void castSelfSpell(Spell spell,Player player ){
        if(mana >= spell.getManaCost()){
            spell.castSelf(this);
        } else {
            System.out.println("You do not have enough mana.");
        }
    }

    public void physicalAttack(Enemy enemy) {
        double damageDealt = attackPower * (1 - enemy.getPhysicalDefense());
        enemy.takeDamage(damageDealt);
        System.out.println(name + " attacked " + enemy.getName() + " for " + damageDealt + " physical damage");
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

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setName(String name) { this.name = name; }

    public void setHealth(double health) { this.health = health; }

    public void setLevel(double level) { this.level = level; }

    public void setPhysicalDefense(double physicalDefense) { this.physicalDefense = physicalDefense; }

    public void setMagicalDefense(double magicalDefense) { this.magicalDefense = magicalDefense; }

    public void setMana(double mana) { this.mana = mana; }

    public void setAttackPower(double attackPower) { this.attackPower = attackPower; }
}
