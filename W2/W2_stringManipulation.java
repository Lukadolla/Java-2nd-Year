package com.company;

public class W2_stringManipulation {

    public static void main(String[] args) {

        String str = reverseChangeCase("hello");
        System.out.print(str);
    }

    static String reverseChangeCase(String str)
    {
        String str2 = "";
        for(int i = str.length() - 1; i >= 0; i--)
        {
            str2 += str.charAt(i);
        }

        str2 = str2.toUpperCase();

        return str2;
    }
}
