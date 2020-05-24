package com.company.W7;
import java.util.Scanner;

public class Input_1 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            System.out.println((in.nextInt()) * 2);
        }
        in.close();
    }
}
