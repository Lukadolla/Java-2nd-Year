package com.company;

public class W1_Divisible {
    public static void main(String[] args) {
        int i, check = 0;

        for(i = 1; i <= 500; i++)
        {
            if(i%3 == 0 || i%5 == 0)
            {
                check = 1;
            }

            if(check == 1)
            {
                System.out.print(i + " ");
            }

            check = 0;
        }
    }
}
