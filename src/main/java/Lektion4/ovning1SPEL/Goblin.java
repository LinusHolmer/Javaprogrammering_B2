package Lektion4.ovning1SPEL;

public class Goblin extends Enemy{
    public Goblin() {
        super("Goblin", 50,10,0.05,0,1 ,50,100);
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + " coats its blade with poison!");
    }
}
