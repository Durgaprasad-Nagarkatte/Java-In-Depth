package com.durgaprasad.Challenges.FamilyOptmized;

public class FemalePerson extends Person {
    private String name;
    private Person mother;

    public FemalePerson(String name, Person mother){
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
