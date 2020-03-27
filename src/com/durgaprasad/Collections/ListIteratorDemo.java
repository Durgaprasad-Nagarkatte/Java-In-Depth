package com.durgaprasad.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("h");
        list.add("u");

        // Basic operation on a list iterator
        System.out.println("Displaying the elements in a list");
        for(ListIterator<String> iterator =  list.listIterator(); iterator.hasNext();){
            System.out.println("Index : " + iterator.nextIndex() + " and value is : " + iterator.next());
        }

        //Performing complex operations on a list iterator
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext();){

            if (iterator.nextIndex() == 1){
                iterator.add("d");
                iterator.previous();
            }

            if (iterator.next() == "h"){
                iterator.set("g");
            }
            iterator.previous();
            System.out.println("The index of : " + iterator.next() + " is : " + iterator.nextIndex());
        }
        System.out.println(list);
    }
}
