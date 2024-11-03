package Lektion4.ovning1SPEL;

public class GameMap {
    private int x,y;

    public GameMap(){
        x = 0;
        y = 0;
    }

    public void moveNorth(){
        y++;
        System.out.println("You moved north");
    }
    public void moveSouth(){
        y--;
        System.out.println("You move south");
    }
    public void moveEast(){
        x++;
        System.out.println("You move east");
    }
    public void moveWest(){
        x--;
        System.out.println("You move west");
    }
    public String getPosition(){
        return "Player is at (" + x + " , " + y +")";
    }

    public void moveTown(){
        if (x == 0 && y == 0) {
            System.out.println("You are already there");
        } else {
            x = 0;
            y = 0;
            System.out.println("You move back to town");
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
