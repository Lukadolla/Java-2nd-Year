package com.company;

import java.util.*;

public class Lab_2 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //System.out.print("Input x and y values:");
        //int x = in.nextLine();
        draw(13, 13, 4);
    }

    public static void draw(int x, int y, int z) {

        if (z < 2 || z > 6)
        {
            throw new IllegalArgumentException("That number is too high cuz, pick a number between 2 and 5");
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                if (j % z == 0 && i % z == 0) {
                    System.out.print("+");
                } else {
                    if (i % z == 0) {
                        System.out.print("-");
                    } else if (j % z == 0) {
                        System.out.print("|");
                    } else {

                        if (i % 2 == 0) {
                            if (j % 2 != 0) {
                                System.out.print("x");
                            } else {
                                System.out.print("o");
                            }
                        } else {
                            if (j % 2 == 0) {
                                System.out.print("x");
                            } else {
                                System.out.print("o");
                            }
                        }
                    }
                }

            }
                System.out.println();
        }
    }
}
