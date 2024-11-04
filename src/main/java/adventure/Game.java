package adventure;

import adventure.model.Burglar;
import adventure.model.Entity;
import adventure.model.Resident;

import java.util.Scanner;


public class Game {
    private boolean running;
    private Scanner scan;
    private Entity newResident;
    private Entity newBurglar;
    private int x;
    private int y;

    public Game(){

        scan = new Scanner(System.in);
        newResident = new Resident();
        newBurglar = new Burglar();
        x = 0;
        y = 0;
    }

    public void start(){
        running = true;
        while(running){
            System.out.println("kommandon: [köket, sovrummet, hallen, kontoret, vardagsrummet]");

            if(!newResident.isConscious()){
                System.out.println("Du förlora...");
                running = false;
            }
            String userInput = getUserInput();
            running = processInput(userInput);

        }
    }


    public String getUserInput(){
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
            default -> System.out.println("Invalid input");
        }
        return true;
    }

    public void goKitchen() {
        if (x == 0 && y == 0) {
            x = 1;
            System.out.println("Du går till köket och kollar på kylen.");
        } else {
            System.out.println("Du kan bara gå till köket från mitten (0,0)!");
        }
    }


    public void goBed(){
        if(x == 0 && y == 0){
            x = -1;
            System.out.println("Du utforskar sovrummet och hittar en säng.");
        } else {
            System.out.println("Du kan bara gå till sovrummet från mitten (0,0)!");
        }
    }

    public void goHall(){
        if(x == 0 && y == 0){
            System.out.println("Du går till hallen och hittar inbrottstjuven!");
            boolean battle = true;

            while(battle && newResident.isConscious() && newBurglar.isConscious()) {
                System.out.println("Kommandon: [attack]");

                String userInput = getUserInput();
                fight(userInput);
            }
        } else {
            System.out.println("Du kan bara gå till hallen från mitten!");
        }
    }


    public void goOffice(){
        if(x == 0 && y == 0){
            if(newBurglar.isConscious()){
                System.out.println("Du vågar inte gå till kontoret när inbrottstjuven fortfarande är här!");
            } else {
                System.out.println("Du går till kontoret och ringer polisen! Spelet är över.");
                running = false;
            }
        } else {
            System.out.println("Du kan bara gå till kontoret från vardagsrummet!");
        }
    }

    public void goLivingRoom(){
        if(x != 0 || y != 0) {
            System.out.println("Du går tillbaka till vardagsrummet.");
            x = 0;
            y = 0;
        } else {
            System.out.println("Du är redan i vardagsrummet!");
        }
    }

    public void fight(String input){
        switch(input) {
            case "attack" -> attack();
            default -> System.out.println("Fel input.");
        }

    }

    public void attack(){
        newResident.attack(newBurglar);
        System.out.println("Du attackerar inbrottstjuven och gör " + newResident.getDamage());
        if(!newBurglar.isConscious()){
            System.out.println("Inbrottstjvuen faller till marken!");
        } else {
            newBurglar.attack(newResident);
            System.out.println("Inbrottstjuven attackerar dig och gör " + newBurglar.getDamage());
        }
    }

}
