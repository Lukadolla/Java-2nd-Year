package com.company.W8;
import java.io.*;
import java.util.Scanner;

public class File_3 {

    public static void main(String[] args) {

        try {
            averageIntegers("C:\\Java Stuff\\01.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            averageIntegers("C:\\Java Stuff\\02.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void averageIntegers(String s) throws IOException
    {
        int min = 100000;
        int max = 0;
        int temp;
        int count = 0;
        double average = 0;

        File f = new File(s);

        if(!(f.exists()))
        {
            throw new FileNotFoundException();
        }

        Scanner in = new Scanner(f);

        while(in.hasNext())
        {
            temp = in.nextInt();
            average += temp;

            if(min > temp)
            {
                min = temp;
            }

            else if(max < temp)
            {
                max = temp;
            }

            count++;
        }

        System.out.println("Min Value: " + min);
        System.out.println("Max Value: " + max);
        System.out.println("Average Value: " + (average/count));
    }
}
