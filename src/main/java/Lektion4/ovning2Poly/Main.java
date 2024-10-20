package Lektion4.ovning2Poly;

public class Main {
    public static void main(String[] args) {
        /*
        Vehicle newCar = new Car();
        Vehicle newBicycle = new Bicycle();

        newCar.move();
        newBicycle.move();
        */

        Animal newDog = new Dog();
        Animal newCat = new Cat();

        newDog.makeSound();
        newCat.makeSound();
        //newDog.fetch(); går inte
        Dog newDog2 = new Dog();
        newDog2.fetch(); // funkar
    }
}
