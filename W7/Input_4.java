package com.company.W7;
import com.company.W6.Employee;

import java.util.*;

public class Input_4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String temp;
        String name = "";
        int age = 0;
        String employer = "";
        int salary = 0;
        Boolean validInput;

        while(in.hasNext())
        {
            validInput = false;     //name
            while (!validInput)
            {
                if (!(in.hasNextInt()))
                {
                    name = in.next();
                    validInput = true;
                }
                else {
                    System.out.println("received int expecting String");
                    temp = in.next();
                }
            }

            validInput = false;     //age
            while (!validInput)
            {
                if (in.hasNextInt())
                {
                    age = in.nextInt();
                    validInput = true;
                }
                else {
                    System.out.println("received String expecting int");
                    temp = in.next();
                    //System.out.println(temp);
                }
            }

            validInput = false;         //employer
            while (!validInput)
            {
                if (!(in.hasNextInt()))
                {
                    employer = in.next();
                    validInput = true;
                }
                else {
                    System.out.println("received int expecting String");
                    temp = in.next();
                }
            }

            validInput = false;         //salary
            while (!validInput)
            {
                if (in.hasNextInt())
                {
                    salary = in.nextInt();
                    validInput = true;
                }
                else {
                    System.out.println("received String expecting int");
                    temp = in.next();
                }
            }

            Employee e = new Employee(name, age, employer, salary);
            System.out.println(e);
        }
        in.close();
    }
}
