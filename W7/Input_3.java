package com.company.W7;
import java.util.Scanner;

public class Input_3 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double answer;
        String operator;

        double part_1 = in.nextDouble();

        while(in.hasNext())
        {
            operator = in.next();
            double part_2 = in.nextDouble();

            if(operator.equals("+") || operator.equals("-") || operator.equals("x") || operator.equals("/"))
            {
                switch (operator) {
                    case "+":
                        answer = part_1 + part_2;
                        System.out.println(part_1 + part_2);
                        break;
                    case "-":
                        answer = part_1 - part_2;
                        System.out.println(part_1 - part_2);
                        break;
                    case "x":
                        answer = part_1 * part_2;
                        System.out.println(part_1 * part_2);
                        break;
                    default:
                        answer = part_1 / part_2;
                        System.out.println(part_1 / part_2);
                        break;
                }
            }

            else
            {
                System.out.println("unknown operator");
                break;
            }

            part_1 = answer;
        }
        in.close();
    }
}
