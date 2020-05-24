package com.company.W6;
import java.util.*;

public class Employee extends Person {

    private String employer;
    private int salary;

    public Employee(String n, int a, String e, int s) throws IllegalArgumentException
    {
        super(n, a);
        employer = e;
        salary = s;

        if(s < 0 || e.equals("") || e.equals(" "))
        {
            throw new IllegalArgumentException("Invalid input");
        }
    }      //Constructor

    public int getSalary()
    {
        return salary;
    } //Accessors

    private String getEmployer()
    {
        return employer;
    }   //Accessors

    public String toString()
    {
        String str = super.toString();
        str += "[" + getEmployer() + ", " + getSalary() + "]";
        return str;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Person)
        {
            return super.equals(o);
        }

        else if(o instanceof Employee)
        {
            return this.getEmployer() == ((Employee) o).getEmployer() && this.getSalary() == ((Employee) o).getSalary();
        }

        return false;
    }

    public int compareTo(Human h)
    {
        if(super.compareTo(h) == 0)
        {
            if(this.getSalary() > ((Employee)h).getSalary())
            {
                return 1;
            }

            if(this.getSalary() == ((Employee)h).getSalary())
            {
                return 0;
            }

            if(this.getSalary() < ((Employee)h).getSalary())
            {
                return -1;
            }
        }
        else
        {
            return super.compareTo(h);
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
