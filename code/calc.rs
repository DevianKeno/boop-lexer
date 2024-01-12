use std::io;

struct Calculator;

impl Calculator {
    fn add(&self, a: f64, b: f64) -> f64 {
        a + b
    }

    fn subtract(&self, a: f64, b: f64) -> f64 {
        a - b
    }

    fn multiply(&self, a: f64, b: f64) -> f64 {
        a * b
    }

    fn divide(&self, a: f64, b: f64) -> f64 {
        if b != 0.0 {
            a / b
        } else {
            eprintln!("Error: Division by zero");
            f64::NAN // Not a Number
        }
    }
}

fn main() {
    let calculator = Calculator;

    let mut input = String::new();

    println!("Enter two numbers:");

    io::stdin().read_line(&mut input).expect("Failed to read line");
    let num1: f64 = input.trim().parse().expect("Invalid input");
    input.clear();

    io::stdin().read_line(&mut input).expect("Failed to read line");
    let num2: f64 = input.trim().parse().expect("Invalid input");

    println!("Choose an operation (+, -, *, /):");
    input.clear();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let operation = input.trim().chars().next().expect("Invalid input");

    let result = match operation {
        '+' => calculator.add(num1, num2),
        '-' => calculator.subtract(num1, num2),
        '*' => calculator.multiply(num1, num2),
        '/' => calculator.divide(num1, num2),
        _ => {
            eprintln!("Error: Invalid operation");
            return; // Exit without error code
        }
    };

    println!("Result: {}", result);
}
