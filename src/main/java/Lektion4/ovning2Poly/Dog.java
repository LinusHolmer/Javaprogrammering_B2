package Lektion4.ovning2Poly;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("dog sound");
    }
    public void fetch(){
        System.out.println("dog fetch");
    }
}
