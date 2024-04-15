import java.util.Scanner;

public class BasicCalculator{

    public static double addition(double x, double y) {
        
        return x+y;

    }

    public static double subtraction(double x, double y) {

        return x-y;
    } 

    public static double multiplication(double x, double y) {

        return x*y;
    }

    public static double division(double x, double y) {

        return x/y;

    }
    public static void main(String[] args) {
        
        System.out.printf("Please enter two numbers that you want to operate: ");
        Scanner getValues = new Scanner(System.in);
        int number1 = getValues.nextInt();
        int number2 = getValues.nextInt();

        System.out.printf("1 - Add numbers each other\n2 - Subtract number from another\n3 - Multiplicate numbers with each other\n4 - Divide numbers with each other\n\nPlease enter your chooise: ");
        int chooise = getValues.nextInt();

        switch(chooise) {

            case 1: 

                System.out.println(addition(number1, number2));
                break;
            case 2:
                System.out.println(subtraction(number1, number2));
                break;
            case 3:
                System.out.println(multiplication(number1, number2));
                break;
            case 4:
                System.out.println(division(number1, number2));
                break;

            default:
                System.out.println("Please enter valid chooise!");
        }
        
    }
}