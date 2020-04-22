package com.durgaprasad.Challenges.FamilyOptmized;

public class MarriedMalePerson extends MalePerson{
    private Couple relation;

    public MarriedMalePerson(String name, Person mother){
        super(name, mother);
    }

    public Couple getRelation(){
        return relation;
    }

    public void setRelation(Couple relation){
        this.relation = relation;
    }
}