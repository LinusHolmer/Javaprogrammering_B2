package Lektion2.Calculator;

public class TempratureConverter {
    public static double toCelsius(double fahrenheit){
        return (fahrenheit -32) * 5 / 9;
    }
    public static double toFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }
}
