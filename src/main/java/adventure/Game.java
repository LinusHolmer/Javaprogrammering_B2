package adventure;

import adventure.model.Burglar;
import adventure.model.Resident;

import java.util.Scanner;

public class Game {
    private boolean running;
    private final Scanner scan;
    private final Resident newResident;
    private final Burglar newBurglar;
    private String currentRoom;
    private boolean hasPickedUpPan;

    public Game() {
        scan = new Scanner(System.in);
        newResident = new Resident();
        newBurglar = new Burglar();
        currentRoom = "vardagsrummet";
        running = true;
        hasPickedUpPan = false;
    }

    public void start() {
        while (running) {
            System.out.println("Kommandon: [köket, sovrummet, hallen, kontoret, vardagsrummet, quit]");

            if (!newResident.isConscious()) {
                System.out.println("Du förlorar...");
                running = false;
                break;
            }

            String userInput = getUserInput();
            if (!processInput(userInput)) {
                break;
            }
        }

        scan.close();
        System.out.println("Spelet är slut.");
    }

    public String getUserInput() {
        return scan.nextLine();
    }

    public boolean processInput(String input) {
        switch (input.toLowerCase()) {
            case "köket" -> goKitchen();
            case "sovrummet" -> goBed();
            case "hallen" -> goHall();
            case "kontoret" -> goOffice();
            case "vardagsrummet" -> goLivingRoom();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Fel input.");
        }
        return true;
    }

    public void goKitchen() {
        if ("vardagsrummet".equals(currentRoom)) {
            currentRoom = "köket";
            if (!hasPickedUpPan) {
                System.out.println("Du går in i köket. Du ser en stekpanna som kan vara användbar.");
                System.out.println("Vill du plocka upp stekpannan? [ja/nej]");
                String choice = getUserInput();
                if (choice.equalsIgnoreCase("ja")) {
                    newResident.addDamage(3);
                    hasPickedUpPan = true;
                    System.out.println("Du plockar upp stekpannan.");
                } else {
                    System.out.println("Du väljer att inte plocka upp stekpannan.");
                }
            } else {
                System.out.println("Du går in i köket och kollar i kylen.");
            }
        } else {
            System.out.println("Du kan bara gå till köket från vardagsrummet!");
        }
    }

    public void goBed() {
        if ("vardagsrummet".equals(currentRoom)) {
            currentRoom = "sovrummet";
            System.out.println("Du utforskar sovrummet och hittar en säng.");
        } else {
            System.out.println("Du kan bara gå till sovrummet från vardagsrummet!");
        }
    }

    public void goHall() {
        if ("vardagsrummet".equals(currentRoom)) {
            currentRoom = "hallen";
            System.out.println("Du går till hallen och hittar inbrottstjuven!");
            boolean battle = true;

            while (battle && newResident.isConscious() && newBurglar.isConscious() && running) {
                System.out.println("Kommandon: [attack]");
                String userInput = getUserInput();
                battle = fight(userInput);
            }
        } else {
            System.out.println("Du kan bara gå till hallen från vardagsrummet!");
        }
    }

    public void goOffice() {
        if ("vardagsrummet".equals(currentRoom)) {
            currentRoom = "kontoret";
            if (newBurglar.isConscious()) {
                System.out.println("Du vågar inte gå till kontoret när inbrottstjuven fortfarande är här!");
            } else {
                System.out.println("Du går till kontoret och ser telefonen. Vill du ringa polisen? [ja/nej]");
                String choice = getUserInput();
                if (choice.equalsIgnoreCase("ja")) {
                    System.out.println("Du ringer polisen! Spelet är över.");
                    running = false;
                } else {
                    System.out.println("Du väljer att inte ringa polisen och spelet fortsätter.");
                }
            }
        } else {
            System.out.println("Du kan bara gå till kontoret från vardagsrummet!");
        }
    }

    public void goLivingRoom() {
        if (!"vardagsrummet".equals(currentRoom)) {
            System.out.println("Du går tillbaka till vardagsrummet.");
            currentRoom = "vardagsrummet";
        } else {
            System.out.println("Du är redan i vardagsrummet!");
        }
    }

    public boolean fight(String input) {
        if ("attack".equalsIgnoreCase(input)) {
            attack();
            return newBurglar.isConscious();
        } else {
            System.out.println("Fel input.");
        }
        return true;
    }

    public void attack() {
        newResident.attack(newBurglar);
        System.out.println("Du attackerar inbrottstjuven och gör " + newResident.getDamage() + " skada.");
        if (!newBurglar.isConscious()) {
            System.out.println("Inbrottstjuven faller till marken!");
        } else {
            newBurglar.attack(newResident);
            System.out.println("Inbrottstjuven attackerar dig och gör " + newBurglar.getDamage() + " skada.");
        }
    }
}
