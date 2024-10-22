package Lektion4.ovning1SPEL;

public class ForestTroll extends Enemy {
    public ForestTroll() {
        super("Forest Troll",100,20,0.2,0.2,5,100);
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() +" lets out a horrifying scream!");
    }
}
