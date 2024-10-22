package Lektion4.ovning1SPEL;

public abstract class Spell {
    private String spellName;
    private String spellDescription;
    private int manaCost;

    public Spell(String spellName, String spellDescription, int manaCost){
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.manaCost = manaCost;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public int getManaCost() {
        return manaCost;
    }

    public abstract void cast(Player player, Enemy enemy);

    public abstract void castSelf(Player player);

}
