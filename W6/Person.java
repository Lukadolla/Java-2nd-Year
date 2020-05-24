package com.company.W6;
import java.util.*;

public class Person implements Human {

    private int age;
    private String name;

    public Person(String n, int a) throws IllegalArgumentException
    {
        age = a;
        name = n;

        if(a < 0 || n == "" || n == " ")
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }  //Constructor

    public int getAge()
    {
        return age;
    }  //Accessor

    public String getName()
    {
        return name;
    }  //Accessor

    public String toString()
    {
        String str = "";
        str = this.getClass() + "";
        str = str.replace("class com.company.W6.", "");
        str += ":[" + this.getName() + ", " + this.getAge() + "]";
        return str;
    }

    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }

        else if(!(o instanceof Human))
        {
            return false;
        }

        Human h = (Human) o;
        return getAge() == h.getAge() && getName() == h.getName();

    }

    public int compareTo(Human h) {
        if(this.getAge() > h.getAge())
        {
            return 1;
        }

        if(this.getAge() == h.getAge())
        {
            return 0;
        }

        if(this.getAge() < h.getAge())
        {
            return -1;
        }

        else
        {
            return 0;
        }
    }

    public static void main(String[] args) {


    }
}
