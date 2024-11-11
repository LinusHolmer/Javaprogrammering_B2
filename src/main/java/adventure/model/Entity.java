package adventure.model;

public abstract class Entity {
    private String role;
    private int health;
    private int damage;

    public Entity(String role, int health, int damage){
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public void attack(Entity toAttack){
        toAttack.takeDamage(damage);
    }

    public void takeDamage(int damage){
        health = Math.max(0, health - damage);
    }

    public boolean isConscious(){
        return health > 0;
    }

    public void addDamage(int damage){
        this.damage += damage;
    }

    // Getters
    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
    //Setters
    public void setRole(String role) {
        this.role = role;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
