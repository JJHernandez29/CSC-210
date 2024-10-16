package csc210;

import java.util.Scanner;

public class quadraticequation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter coefficient a: ");
            double a = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter coefficient b: ");
            double b = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter coefficient c: ");
            double c = Double.parseDouble(scanner.nextLine());
  
            solveQuadraticEquation(a, b, c);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input value. Please enter numeric values.");
        } finally {
            scanner.close(); 
        }
    }

    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("The equation has infinite solutions.");
        } else if (a == 0 && b == 0) {
            System.out.println("The equation has no solutions.");
        } else if (a == 0) {
            double linearRoot = -c / b;
            System.out.println("This is a linear equation with one root: " + linearRoot);
        } else {
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) { 
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two real roots: " + root1 + " and " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("The equation has one real root: " + root);
            } else {
                // Two complex roots
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                System.out.println("The equation has two complex roots: " + realPart + " + " + imaginaryPart + "i and " + realPart + " - " + imaginaryPart + "i");
            }
        }
    }
}
