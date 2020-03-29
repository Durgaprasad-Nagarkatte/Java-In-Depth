package com.durgaprasad.Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void deQueueTest(){
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Walden");
        deque.add("Harry Potter");
        deque.add("Head First Java");
        deque.add("Hey");
        System.out.println("The size of the queue is : " + deque.size());

        while(deque.size() > 0){
            System.out.println(deque.remove());
        }
    }

    public static void main(String[] args){
        deQueueTest();
    }
}
