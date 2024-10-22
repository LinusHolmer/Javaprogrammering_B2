package Lektion4.ovning1SPEL;

public class Heal extends Spell{
    private int heal;

    public Heal(){
        super("Heal","A simple healing spell",25);
        this.heal = 25;
    }

    @Override
    public void cast(Player player, Enemy enemy) {

    }

    @Override
    public void castSelf(Player player) {
        player.reduceMana(getManaCost());
        player.healPlayer(heal);
        System.out.println("You healed yourself for " + heal +" health.");
    }
}
