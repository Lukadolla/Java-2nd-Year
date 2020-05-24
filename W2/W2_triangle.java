package com.company.W2;


public class W2_triangle {
    public static void main(String[] args) {


        printTriangle(3, 'x');
    }

    static void printTriangle(int base, char shape)
    {
        if(base < 2 || base > 10)
        {
            System.out.println("Not valid input");
        }

        else {
            for(int i = 1; i <= base; i++)
            {
                for(int j = 0; j < i; j++)
                {
                    System.out.print(shape + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
