package com.durgaprasad.Challenges.FamilyOptmized;

import java.util.HashMap;

public class FamilyTest {
    public static void createCouple(Person p1, Person p2){
        Couple c = new Couple(p1, p2);
        ((MarriedMalePerson)p1).setRelation(c);
        ((MarriedFemalePerson)p2).setRelation(c);
    }

    public static void initializeFamily(Family fam){
        HashMap<String, Person> map = fam.getMap();
        
        Person p1 = new MarriedMalePerson("Chit", map.get("Queen Anga"));
        fam.addChild(p1, "Queen Anga");
        Person p2 = new MarriedFemalePerson("Amba", null);
        map.put(p2.getName(), null);
        createCouple(p1, p2);

        Person p3 = new MalePerson("Ish", map.get("Queen Anga"));
        fam.addChild(p2, "Queen Anga");

        Person p4 = new MarriedMalePerson("Vich", map.get("Queen Anga"));
        fam.addChild(p4, "Queen Anga");
        Person p5 = new MarriedFemalePerson("Lika", null);
        map.put(p5.getName(), null);
        createCouple(p4, p5);

        Person p6 = new MarriedMalePerson("Aras", map.get("Queen Anga"));
        fam.addChild(p6, "Queen Anga");
        Person p7 = new MarriedFemalePerson("Chitra", null);
        map.put(p7.getName(), null);
        createCouple(p6, p7);

        Person p8 = new MarriedFemalePerson("Satya", map.get("Queen Anga"));
        fam.addChild(p7, "Queen Anga");
        Person p9 = new MarriedMalePerson("Aras", null);
        map.put(p9.getName(), null);
        createCouple(p8, p9);
    }

    public static void main(String[] args){
        Family family = new Family();
        initializeFamily(family);
        HashMap<String, Person> map = family.getMap();
        Person m = map.get("Queen Anga");
        System.out.println(((MarriedFemalePerson)m).getChildren());
        System.out.println(map.get("Amba"));

    }

}
