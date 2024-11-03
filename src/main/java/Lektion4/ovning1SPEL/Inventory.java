package Lektion4.ovning1SPEL;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public void displayInventory() {
        items.forEach(item -> System.out.println(item.getDescription()));
    }
}
