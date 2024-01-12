#include <iostream>
#include <cmath>

class Calculator {
public:
    Calculator() {}

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            std::cerr << "Error: Division by zero\n";
            return NAN; // Not a Number
        }
    }
};

int main() {
    Calculator calculator;

    double num1, num2;
    char operation;

    std::cout << "Enter two numbers: ";
    std::cin >> num1 >> num2;

    std::cout << "Choose an operation (+, -, *, /): ";
    std::cin >> operation;

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
            std::cerr << "Error: Invalid operation\n";
            return 1; // Exit with an error code
    }

    std::cout << "Result: " << result << std::endl;

    return 0; // Exit successfully
}