package com.company;
import java.util.Formatter;

public class Time {
    public int hours;

    public int minutes;

    public int seconds;

    public static void main(String[] args) {
        Time morning = new Time();
        morning.hours = 13;
        morning.minutes = 15;
        morning.seconds = 14;
        morning.printTime();
    }

    void printTime()
    {
        System.out.print("[");
        if(hours < 10)
        {
            System.out.print("0");
        }
        System.out.print(hours);
        System.out.print(":");
        if(minutes < 10)
        {
            System.out.print("0");
        }
        System.out.print(minutes);
        System.out.print(":");
        if(seconds < 10)
        {
            System.out.print("0");
        }
        System.out.print(seconds);
        System.out.print("]");
    }

}
