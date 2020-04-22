package com.durgaprasad.Challenges.FamilyOptmized;

import java.util.ArrayList;

public class MarriedFemalePerson extends FemalePerson{
    private Couple relation;

    public MarriedFemalePerson(String name, Person mother){
        super(name, mother);
    }

    public Couple getRelation(){
        return relation;
    }

    public void setRelation(Couple relation){
        this.relation = relation;
    }

    public void addChild(Person p){
        relation.addChild(p);
    }

    public ArrayList<Person> getChildren(){
        return relation.getChildren();
    }

}
