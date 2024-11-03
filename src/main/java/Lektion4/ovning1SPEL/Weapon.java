package Lektion4.ovning1SPEL;

public class Weapon extends Item implements Equippable {
    private int damage;
    private boolean isEquipped;

    public Weapon(String name, int value, int damage, boolean isEquipped) {
        super(name, value);
        this.damage = damage;
        this.isEquipped = false;
    }

    @Override
    public void equip(Player player) {
        if (!isEquipped) {
            System.out.println("You equip " + getName());
            player.setAttackPower(player.getAttackPower() + damage);
            isEquipped = true;
        } else {
            System.out.println("You already equip " + getName());
        }

    }

    @Override
    public void unequip(Player player) {
        if(isEquipped){
            System.out.println("You unequip " + getName());
            player.setAttackPower(player.getAttackPower() - damage);
            isEquipped = false;
        } else {
            System.out.println("You are already equipped");
        }

    }
    public boolean isEquipped() {
        return isEquipped;
    }
}
