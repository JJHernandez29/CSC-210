package csc210;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner kb = null;
        try {
            kb = new Scanner(System.in);
            int x;
            do { 
                 System.out.print("input an integer between 1 and 10; ");
                x = kb.nextInt();
            } while ((x < 1) || (x > 10));
            if ((x < 1) || (x > 10)) {
                throw new IllegalArgumetException("value not between 1 and 10");
            }
           
            
        } catch (InputMismatchException e) {
            System.out.println("not an integer");
        }
    }
}
