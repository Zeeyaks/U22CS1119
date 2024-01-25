import java.util.Scanner;

public class Javacalc1119{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the first number (1-99): ");
            double num1 = getValidNumber(scanner);

            System.out.print("Enter the second number (1-99): ");
            double num2 = getValidNumber(scanner);

            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            double result = calculate(num1, num2, operator);

            if (result != -1) {
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            }

            System.out.print("Do you want to perform another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice != 'y') {
                break;
            }
        }

        scanner.close();
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                double num = scanner.nextDouble();
                if (num >= 1 && num <= 99) {
                    return num;
                } else {
                    System.out.println("Invalid input. Please enter a two-digit number (1-99).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Division by zero is not allowed.");
                    return -1;
                } else {
                    return num1 / num2;
                }
            default:
                System.out.println("Invalid operator. Please use +, -, *, or /.");
                return -1;
        }
    }
}
