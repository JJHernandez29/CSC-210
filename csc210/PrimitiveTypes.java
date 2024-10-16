package csc210.csc210;

import java.util.Scanner;

public class PrimitiveTypes {

    // -- runtime entry point
    Select :

        System.out.print("Enter an integer: ");
        int x = kb.nextInt();
    
        System.out.println("x + 10 = " + (x + 10));

        byte b;
        System.out.println("Enter a byte: ");
        b = kb.nextByte();

        System.out.println("b + 10 = " + (b + 10));

        b = (byte)(b + 10);
        System.out.println(b);

        System.out.println(10 / 100);
        System.out.println(110 % 100);
        System.out.println(110 / 100.0);

    }
}