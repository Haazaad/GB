import java.util.Random;
import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Available command:");
        System.out.println("1 - Evaluating expression a * (b + (c / d)) for random float numbers");
        System.out.println("2 - Checking whether the sum of 2 numbers is in the range from 10 to 20");
        System.out.println("3 - Number check (positive or negative)");
        System.out.println("4 - Is the number negative?");
        System.out.println("5 - Line output to console");
        System.out.println("6 - Chek leap year");
        System.out.println("7 - Exit");
        label:
        while (true) {
            System.out.print("Input number of command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "7":
                    break label;
                case "1":
                    System.out.println("The result of evaluating the expression  a * (b + (c / d)) for random float numbers is " + calculate());
                    break;
                case "2":
                    System.out.print("Enter the first number: ");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the second number: ");
                    int num2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("The sum of " + num1 + " and " + num2 + " lies in the range from 10 to 20 - " + checkSum(num1, num2));
                    break;
                case "3": {
                    System.out.print("Enter the number: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    isPositive(num);
                    break;
                }
                case "4": {
                    System.out.print("Enter the number: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    System.out.println(isNegative(num));
                    break;
                }
                case "5":
                    System.out.print("Enter the name: ");
                    String name = scanner.nextLine();
                    printString(name);
                    break;
                case "6":
                    System.out.print("Enter the year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    isLeapYear(year);
                    break;
            }
        }
    }

    public float calculate() {
        float a = getRandomFloat();
        float b = getRandomFloat();
        float c = getRandomFloat();
        float d = getRandomFloat();
        return a * (b + c / d);
    }

    public float getRandomFloat() {
        Random rand = new Random();
        return rand.nextFloat() * 200 - 100;
    }

    public boolean checkSum(int num1, int num2) {
        int sum = num1 + num2;
        return (sum >= 10 && sum <= 20);
    }

    public void isPositive(int num) {
        if (num < 0) {
            System.out.println("The number " + num + " is negative.");
        } else {
            System.out.println("The number " + num + " is positive.");
        }
    }

    public boolean isNegative(int num) {
        return num < 0;
    }

    public void printString(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 == 0){
            System.out.println("The year " + year + " is a leap year.");
        } else if ((year % 4 == 0) && (year % 100 !=0 && year % 400 != 0)) {
            System.out.println("The year " + year + " is a leap year.");
        } else {
            System.out.println("The year " + year + " isn't a leap year.");
        }
    }
}
