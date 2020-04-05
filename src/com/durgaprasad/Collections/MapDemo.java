package com.durgaprasad.Collections;

import java.util.*;

public class MapDemo {
    public static void hashMapDemo(){

        //Creating an instance of Map
        Map<String, Integer> family = new HashMap<>();
        family.put("Durgaprasad", 25);
        family.put("Akshatha", 21);
        family.put("Mangala", 55);
        family.put("Ekanath", 63);
        family.put("Vaibhav", null);

        //Printing out the entire map
        System.out.println(family);
        family.put("Vaibhav", 26);

        System.out.println("Akshatha there : " + family.containsKey("Akshatha"));
        System.out.println("Durgaprasad age : " + family.get("Durgaprasad"));

        //Iterating using Key Set
        Set<String> names = family.keySet();
        for(String name : names){
            System.out.println("The name is " + name + " and age of the member is " + family.get(name));
        }

        //Iterating using Entry Set
        Set<Map.Entry<String, Integer>> fam = family.entrySet();
        for(Map.Entry<String, Integer> person : fam){
            System.out.println("The name is : " + person.getKey() + " and the age is " + person.getValue());
        }

        //Creating a complex Map
        Map<String, Map<String, Object>> userProfile = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();

        profile.put("age", 25);
        profile.put("dept", "CS");
        profile.put("city", "New York");
        userProfile.put("John", profile);

        profile.put("age", 29);
        profile.put("dept", "CS");
        profile.put("city", "New York");
        userProfile.put("Raju", profile);

        System.out.println(userProfile);

        Map<String, Object> prof = userProfile.get("John");
        Integer age = (Integer)prof.get("age");
        System.out.println(age);
    }

    private static void immutableKeyDemo(){
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Map<List<Integer>, Integer> map = new HashMap<>();
        map.put(list, 1);

        //Adding 2 to the list, changes the value of the list computed \
        //by the hash function
        list.add(2);
        System.out.println(map.get(list));
    }


    public static void main(String[] args){
        hashMapDemo();
        immutableKeyDemo();
    }
}
