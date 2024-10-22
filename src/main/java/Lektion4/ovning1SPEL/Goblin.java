package Lektion4.ovning1SPEL;

public class Goblin extends Enemy{
    public Goblin() {
        super("Goblin", 50,5,5,0,1 );
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + " coats its blade with posion!");
    }
}
