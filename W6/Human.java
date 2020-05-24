package com.company.W6;

public interface Human extends Comparable<Human> {

    int getAge();
    String getName();
    int compareTo(Human h);
}
