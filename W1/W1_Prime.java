package com.company;

public class W1_Prime {
    public static void main(String[] args) {
        int count, check, prime_num = 1;

       for(count = 1; count < 1000; count++)
       {
           for(check= 2; check < count; check++)
           {
               if(count%check == 0)
               {
                   prime_num = 1;
               }
           }

           if(prime_num == 0) {
               System.out.print(count + " ");
           }
           prime_num = 0;
       }
    }
}
