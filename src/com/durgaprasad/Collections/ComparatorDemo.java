package com.durgaprasad.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Emp{
    String name;
    int age;

    Emp(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class ComparatorDemo implements Comparator<Emp> {

    @Override
    public int compare(Emp o1, Emp o2) {
        if(o1.age == o2.age){
            return 0;
        }
        else if(o1.age > o2.age){
            return 1;
        }
        else {
            return -1;
        }
    }
}
