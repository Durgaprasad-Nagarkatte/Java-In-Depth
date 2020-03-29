package com.durgaprasad.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Emp emp1 = new Emp("Durgaprasad", 25);
        Emp emp2 = new Emp("Mangala", 21);
        Emp emp3 = new Emp("Akshatha", 29);

        List<Emp> list= new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Collections.sort(list, new ComparatorDemo());

        for(int i = 0; i < list.size(); i++){
            System.out.println("The emp name is : " + list.get(i).name + " and age is : " + list.get(i).age);
        }
    }
}

