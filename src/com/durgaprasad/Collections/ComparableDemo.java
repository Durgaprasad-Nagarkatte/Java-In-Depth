package com.durgaprasad.Collections;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args){
        // Creating user instance
        User user1 = new User("Durgaprasad", "qwerty");
        User user2 = new User("Akshatha", "qwerty");

        // Creating a list of users
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        Collections.sort(list);
        for (User u : list){
            System.out.println("The name of the user : " + u.getUsername());
        }

        String str1 = "Durgaprasad";
        String str2 = "Akshatha";

        List<String> list2 = new ArrayList<>();
        list2.add(str1);
        list2.add(str2);

        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

    }
}
