package com.company.W5;

import java.util.ArrayList;

public interface Vehicle {

    String getName();

    int getTopSpeed();

    int getMaxPassengers();

    static String fastestVehicle(ArrayList<Vehicle> vehicles)
    {
        int count = 0, max, i;
        max = vehicles.get(0).getTopSpeed();

        for(i = 0; i < vehicles.size(); i++)
        {
          if(vehicles.get(i).getTopSpeed() > max)
          {
              max = vehicles.get(i).getTopSpeed();
              count = i;
          }
        }

        return vehicles.get(count).getName();
    }


}
