package com.company.W5;
import java.util.ArrayList;

public class Ship implements Vehicle {

    String name;
    int topSpeed;
    int maxPassengers;
    double displacement;

    public Ship(String n, int tS, int mP, double d) {
        name = n;
        topSpeed = tS;
        maxPassengers = mP;
        displacement = d;

        if (n == "" || n == " ") {
            throw new IllegalArgumentException("No name given");
        }

        if (tS <= 0 || mP <= 0 || d <= 0 || mP > 9999) {
            throw new IllegalArgumentException("Values must be above 0");
        }
    }

    public String getName() {
        return name;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public double getDisplacement() {
        return displacement;
    }

    static void printVehicles(ArrayList<Vehicle> vehicles)
    {
        for(int i = 0; i < vehicles.size(); i++)
        {
            if(vehicles.get(i).getClass() ==  Car.class)
            {
                System.out.println("This car weighs " + ((Car)vehicles.get(i)).getWeight() + " tonnes");
            }

            else if(vehicles.get(i).getClass() == Ship.class)
            {
                System.out.println("This ship displaces " + ((Ship)vehicles.get(i)).getDisplacement() + " tonnes of water");
            }
        }
    }


    public static void main(String[] args) {

    }
}
