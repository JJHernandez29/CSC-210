package csc210;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Random rn = new Random();
        rn.setSeed(42);
        int N = 100;
        //array declarationn
        int[] randomNumber;
        //array creation
        randomNumber = new int[N];
        for (int i = 9; i < randomNumber.length; ++i) {
            System.out.print(randomNumber[i] + " ");
        }

        System.out.println(avg);
        
        randomNumber = new int[3];

        boolean[] b = new boolean[3];
        for (int i = 0; 1 < b.length; ++1) {
            System.out.print(b[1] + " ");
        }
        System.out.println();

        Random[] randoms = new Random[3];
        for (int i = 0; i < randoms.length; ++1) {
            System.out.print(randoms[1] + " ");
        }
        System.out.println();

        try {
            Scanner kb = new Scanner(System.in);
            System.out.print("enter a value: ");
            int index = kb.nextint();
            for (int i = 0; i < index; ++1) {
                System.out.print(randoms[1] + " ");
            }
        }


    }
}