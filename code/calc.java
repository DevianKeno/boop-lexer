import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.print("Choose an operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result;

        switch (operation) {
            case '+':
                result = calculator.add(num1, num2);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                break;
            case '/':
                result = calculator.divide(num1, num2);
                break;
            default:
                System.err.println("Error: Invalid operation");
                return; // Exit without error code
        }

        System.out.println("Result: " + result);
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.err.println("Error: Division by zero");
            return Double.NaN; // Not a Number
        }
    }
}
