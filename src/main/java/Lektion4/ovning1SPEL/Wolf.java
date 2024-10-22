package Lektion4.ovning1SPEL;

public class Wolf extends Enemy{
    public Wolf() {
        super("Wolf",75,15,0.10,0,1,75);
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() +" uses !Sharp bite! and makes you bleed");
    }
}
