package com.durgaprasad.Challenges.FamilyOptmized;

import java.util.ArrayList;

public class Couple {
    private Person husband;
    private Person wife;
    private ArrayList<Person> children;

    public Couple(Person husband, Person wife){
        this.husband = husband;
        this.wife = wife;
        this.children = new ArrayList<>();
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void addChild(Person child){
        children.add(child);
    }
}
