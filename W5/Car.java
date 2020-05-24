package com.company.W5;

public class Car implements Vehicle {

    String name;
    int topSpeed;
    int maxPassengers;
    double weight;

    public Car(String n, int tS, int mP, double w)
    {
        name = n;
        topSpeed = tS;
        maxPassengers = mP;
        weight = w;

        if(n == "")
        {
            throw new IllegalArgumentException("No name given");
        }

        if(tS <= 0 || mP <= 0 || w <= 0)
        {
            throw new IllegalArgumentException("Values must be above 0");
        }
    }

    public String getName()
    {
        return name;
    }

    public int getTopSpeed()
    {
        return topSpeed;
    }

    public int getMaxPassengers()
    {
        return maxPassengers;
    }

    public double getWeight()
    {
        return weight;
    }



    public static void main(String[] args) {

    }
}
