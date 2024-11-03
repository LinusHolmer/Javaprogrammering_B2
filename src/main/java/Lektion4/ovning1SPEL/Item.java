package Lektion4.ovning1SPEL;

public abstract class Item {
    protected String name;
    protected int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    public String getDescription() {
        return name + " worth " + value + " gold";
    }
}
