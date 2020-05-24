package com.company.W7;
import java.util.Scanner;

public class Input_2 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while(in.hasNext())
        {
            int part_1 = in.nextInt();
            String operator = in.next();
            int part_2 = in.nextInt();

            if (operator.equals("+")) {
                System.out.println(part_1 + part_2);
            }

            else if (operator.equals("-")) {
                System.out.println(part_1 - part_2);
            }

            else if (operator.equals("x")) {
                System.out.println(part_1 * part_2);
            }

            else if (operator.equals("/")) {
                System.out.println(part_1 / part_2 + "." + part_1 % part_2);
            }

            else
            {
                System.out.println("unknown operator");
            }
        }
        in.close();
    }
}

