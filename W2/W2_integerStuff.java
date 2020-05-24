package com.company;

import java.util.Scanner;
import java.lang.Math;

public class W2_integerStuff {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter 2 integers: ");
        Integer x = in.nextInt();
        Integer y = in.nextInt();

        integerFun(x, y);
    }

    static void integerFun(int x, int y)
    {
        System.out.println("Sum: " + (x + y));
        System.out.println("Product: " + (x * y));
        System.out.println("Concatenation: " + x + y);
        System.out.println("Power: " + Math.pow(x,y));
    }

}
