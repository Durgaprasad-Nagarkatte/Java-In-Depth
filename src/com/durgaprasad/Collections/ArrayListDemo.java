package com.durgaprasad.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    public static void arrayListDemo(){
        // Creating an ArrayList to store integers.
        Collection<Integer> list1 = new ArrayList<>();

        //Adding elements to ArrayList
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2);
        list1.add(null);

        System.out.println("The elements of list1 are : " + list1);

        // Removing the single instance of the specified element from ArrayList
        list1.remove(2);
        System.out.println("The elements of list1 are : " + list1);

        list1.remove(null);
        System.out.println("The elements of list1 are : " + list1);

        // TO Learn more about method signature binding.
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(2);
        list2.add(null);
        System.out.println("The elements of list2 are : " + list2);

        // Adding elements to a particular index
        list2.add(0, 10);
        System.out.println("The elements of list2 are : " + list2);

        // Setting values
        list2.set(5, 7);
        System.out.println("The elements of list2 are : " + list2);

        // Removing values at index
        list2.remove(5);
        System.out.println("The elements of list2 are : " + list2);

        //Bulk Operations
        Collection<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(3);

        System.out.println("The elements of list1 are : " + list1);
        System.out.println("The elements of list3 are : " + list3);

        // Removing all elements in list3 present in list1
        list1.removeAll(list3);
        System.out.println("The elements of list1 are : " + list1);

        list3.add(1);
        System.out.println("The elements of list3 are : " + list3);

        //Retains all the elements present in list3 in list1 and removes others
        list1.retainAll(list3);
        System.out.println("The elements of list1 are : " + list1);

        //Search methods
        System.out.println("The elements of list2 are : " + list2);
        System.out.println("list2.contains(1) : " + list2.contains(1));
        System.out.println("list2.contains(9) : " + list2.contains(9));
        System.out.println("list2.indexOf(1) : " + list2.indexOf(1));
        System.out.println("list2.indexOf(9) : " + list2.indexOf(9));

        //Range methods
        List sublist2 = list2.subList(0, 2);
        System.out.println("The sublist of list2 is : " + sublist2);

        //Both the list and sublist is changed
        sublist2.set(0, 6);
        System.out.println("The sublist of list2 is : " + sublist2);
        System.out.println("The elements of list2 are : " + list2);

        sublist2.add(0, 7);
        System.out.println("The sublist of list2 is : " + sublist2);
        System.out.println("The elements of list2 are : " + list2);

        list2.set(0, 8);
        System.out.println("The sublist of list2 is : " + sublist2);
        System.out.println("The elements of list2 are : " + list2);

        //Changing the list2 and then accessing the sublist raises the error.

        for(int element : list2){
            System.out.println("element : " + element);

            // Concurrent modificaton exception is raised.
            if (element == 2){
                list2.remove(Integer.valueOf(2));
            }
        }
    }

    public static void main(String[] args){
        arrayListDemo();
    }
}
