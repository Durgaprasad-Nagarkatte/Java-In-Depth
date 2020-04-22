package com.durgaprasad.Challenges.FamilyTree;

import java.util.ArrayList;

public class Person extends FamilyComponent {
    String name;
    String motherName;
    String gender;

    public Person(String name, String motherName, String gender){
        this.name = name;
        this.motherName = motherName;
        this.gender = gender;
    }

    public String getName(){
        return this.name;
    }

    public String getMotherName(){
        return motherName;
    }

    public String getGender(){
        return gender;
    }

    public boolean searchChildren(String name){
        return false;
    }

    public ArrayList<FamilyComponent> getSons(String name){
        return new ArrayList<>();
    }

    public ArrayList<FamilyComponent> getDaughters(String name){
        return new ArrayList<>();
    }

    public ArrayList<FamilyComponent> getChildren(){
        return new ArrayList<>();
    }

}
