package Lektion4.ovning1SPEL;

public class Fireball extends Spell{
    private int damage;

    public Fireball() {
        super("Fireball","A big ball of fire",50);
        this.damage = 50;
    }

    @Override
    public void cast(Player player, Enemy enemy) {
        player.reduceMana(getManaCost());

        enemy.takeDamage(damage);

        System.out.println("You cast "+ getSpellName() + " for " + damage + " damage");

    }

    @Override
    public void castSelf(Player player) {
        System.out.println("You want to use the fireball on yourself?");
    }
}
