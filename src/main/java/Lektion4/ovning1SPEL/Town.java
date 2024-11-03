package Lektion4.ovning1SPEL;

import java.util.Scanner;

public class Town {
    private boolean inTown;
    private Scanner scan;

    public Town() {
        scan = new Scanner(System.in);
    }

    public void townShop(Inventory inventory, Item item) {
        boolean shop = true;
        while (shop) {
            System.out.println("Type 'Wooden Sword' to get it for FREE, or 'leave' to exit the shop.");

            String input = scan.nextLine();

            switch (input.toLowerCase()){
                case "wooden sword" -> {
                    inventory.addItem(item);
                    System.out.println("You received wooden sword");
                }
                case "leave" -> {
                    shop = false;
                    System.out.println("You leave the shop.");
                }
                default -> System.out.println("Invalid input");
            }
        }

    }

    public void exploreTown(){
        System.out.println("You explore the town and find interesting sights, but nothing noteworthy happens this time.");
    }

    public void townMenu(Inventory inventory, Item item) {
        boolean inTown = true;
        while(inTown){
            System.out.println("You are in the town. Choose an action:");
            System.out.println("1. Visit the shop.");
            System.out.println("2. Explore the town.");
            System.out.println("3. Leave the town.");

            String input = scan.nextLine();

            switch(input){
                case "1" -> townShop(inventory, item);
                case "2" -> exploreTown();
                case "3" -> {
                    inTown = false;
                    System.out.println("You leave the town and return to your adventure.");
                }
                default -> System.out.println("That is not a valid input.");
            }
        }
    }

}
