package com.company;

import java.util.Scanner;

public class W2_amountOfCharacters {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String message = in.nextLine();

        printString(message);
    }

   static void printString(String message)
    {
      System.out.println(message);
      System.out.print("Contains " + message.length() + " characters");
    }
}
