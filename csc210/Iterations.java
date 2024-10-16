package csc210;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Iterations {
    public static void main(String[] args) {
        Scanner kb = null;
        try {
            kb = new Scanner(System.in);
            System.out.println("Enter number of iterations: ");
            int x = kb.nextInt();
            // -- for loop
            int i;
            float j;
            for (i = 0, j = 0.5F; (i < x) && (j < x); i++, j = j + 0.1F) {
                System.out.println(i + 1);  // Output current iteration number
                System.out.println("next loop iteration");
            }
            System.out.println("for loop is complete.");

            while (j < 10) {
                System.out.println(j);
                System.out.println("in loop");
                j = 0.5F;
            }

            j = 11.0F;
            do { 
                System.out.println(j);
                j += 0.5;
            } while (j < 10);

            System.out.println("do while loop");
            System.out.println("while loop usig for");
            j = 1.0F;
            for(;j < 10;) {
                System.out.println(j);
                j += 0.5;
            }
            

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println("General exception");
        } finally {
            if (kb != null) {
                kb.close();
            }
        }
    }
}



