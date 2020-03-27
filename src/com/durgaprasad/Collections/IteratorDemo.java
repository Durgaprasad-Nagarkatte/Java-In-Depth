package com.durgaprasad.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Understanding using iterators with ArrayList
 * Using hasNext(), next() and remove() methods to implement an iterator.
 * CAUTION : To call next() method before calling remove method()
 */

public class IteratorDemo {

    public static void iteratorDemo(List<Integer> list){
        // Task is to remove element 9 from the list while iterating.
        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()){
            int element = iterator.next();
            System.out.println("The element is : " + element);

            if(element == 9){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(7);
        list1.add(9);

        iteratorDemo(list1);
        System.out.println(list1);
    }
}
