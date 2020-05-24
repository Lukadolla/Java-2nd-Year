package com.company.W6;
import java.util.*;

public class Manager extends Employee {

    ArrayList<Employee> team = new ArrayList<Employee>();

    public Manager(String n, int a, String e, int s) throws IllegalArgumentException
    {
        super(n, a, e, s);
    } //Constructor

    public ArrayList<Employee> getTeam()
    {
        return team;
    }

    public void addEmployee(Employee e)
    {
       getTeam().add(e);
    }

    public int getSalary()
    {
        if(getTeam().size() > 0)
        {
            int newSalary;
            int totalTeamSalary = 0;

            for(int i = 0; i < getTeam().size(); i++)
            {
                totalTeamSalary += getTeam().get(i).getSalary();
            }

            totalTeamSalary /= getTeam().size();

            newSalary = totalTeamSalary + super.getSalary();
            return newSalary;
        }

        return super.getSalary();
    }

    public int compareTo(Human h)
    {
        if(h instanceof Employee)
        {
            return super.compareTo(h);
        }

        if(super.compareTo(h) == 0)
        {
            if(this.getTeam().size() > ((Manager) h).getTeam().size())
            {
                return 1;
            }

            if(this.getTeam().size() == ((Manager) h).getTeam().size())
            {
                return 0;
            }

            if(this.getTeam().size() < ((Manager) h).getTeam().size())
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

    public String toString()
    {
        String str = super.toString();
        str += "[Team: " + getTeam().size() + "]";
        return str;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Person)
        {
            return super.equals(o);
        }

        else if(o instanceof Manager)
        {
            return this.getTeam() == ((Manager) o).getTeam();
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
