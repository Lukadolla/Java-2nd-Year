package com.company.W8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeCalculator {

    public static void main(String[] args) {

    }

    public static void readFile(String s) throws IOException
    {
        int student_number;
        double CA1;
        double CA2;
        double Exam;

        String data = "";

        File f = new File(s);  //s is file directory

        if(!(f.exists()))
        {
            throw new FileNotFoundException();
        }

        Scanner in = new Scanner(f);


        while(in.hasNextLine())
        {
            data = in.nextLine();

            StringTokenizer stk = new StringTokenizer(data, ",");
            String integers = stk.nextToken();

            student_number = Integer.parseInt(integers);

            integers = stk.nextToken();
            CA1 = Double.parseDouble(integers);

            integers = stk.nextToken();
            CA2 = Double.parseDouble(integers);

            integers = stk.nextToken();
            Exam = Double.parseDouble(integers);

            System.out.print(student_number + " ");
            System.out.println((CA1 * 0.2) + (CA2 * 0.3) + (Exam * 0.5));
        }

        in.close();
    }
}
