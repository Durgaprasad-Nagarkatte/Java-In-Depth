package com.durgaprasad.Challenges.FamilyOptmized;

public class MalePerson extends Person {
    private String name;
    private Person mother;

    public MalePerson(String name, Person mother){
        this.name = name;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }
}
