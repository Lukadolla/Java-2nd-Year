package com.company.W2;


public class W2_stringPrint {
    public static void main(String[] args) {

        printString("my my my my");
    }

    static void printString(String str)
    {
        System.out.println(str);

        if(str.contains("my"))
        {
          str =  str.replaceAll("my", "your");
        }
        System.out.print(str);
    }
}
