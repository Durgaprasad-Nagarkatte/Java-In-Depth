package com.durgaprasad.Challenges.FamilyOptmized;

import java.util.HashMap;

public class Family {
    private HashMap<String, Person> map;

    public Family(){
        this.map = new HashMap<>();
        Person p1 = new MarriedMalePerson("King Shan", null);
        Person p2 = new MarriedFemalePerson("Queen Anga", null);
        map.put("King Shan", p1);
        map.put("Queen Anga", p2);
        Couple c = new Couple(p1, p2);
        ((MarriedMalePerson)p1).setRelation(c);
        ((MarriedFemalePerson)p2).setRelation(c);
    }

    public HashMap<String, Person> getMap(){
        return map;
    }

    public boolean addChild(Person p, String motherName){
        if(!map.containsKey(motherName)){
            return false;
        }
        Person mother = map.get(motherName);
        if(mother instanceof MarriedFemalePerson){
            ((MarriedFemalePerson) mother).addChild(p);
            map.put(p.getName(), mother);
            return true;
        }
        return false;
    }
}
