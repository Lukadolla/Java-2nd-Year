package com.company;

public class W1_Even {
    public static void main(String[] args) {
        int i;

        for(i = 0; i < 100; i++)
        {
            if(i%2 != 0)
            {
                i++;
            }

            System.out.print(i + " ");
        }


    }
}
