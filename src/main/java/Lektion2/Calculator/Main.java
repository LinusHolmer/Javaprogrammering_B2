package Lektion2.Calculator;


public class Main {
    public static void main(String[] args) {

        int number = Calculator.Multiply(5, 3);
        int mult = Calculator.addTen(3);

        double areaAVCIRKEL = Circle.area(200);
        Config.printConfig();
        System.out.println(TempratureConverter.toCelsius(100));
        System.out.println(TempratureConverter.toFahrenheit(100));
        }
    }