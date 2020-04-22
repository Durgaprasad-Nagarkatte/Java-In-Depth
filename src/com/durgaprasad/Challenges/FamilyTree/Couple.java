package com.durgaprasad.Challenges.FamilyTree;

import java.util.ArrayList;

public class Couple extends FamilyComponent{
    Person husband;
    Person wife;

    ArrayList<FamilyComponent> familyPeople = new ArrayList<>();

    public Couple(String husbandName, String wifeName,
                  String husbandMotherName, String wifeMotherName){
        this.husband = new Person(husbandName, husbandMotherName, "Male");
        this.wife = new Person(wifeName, wifeMotherName, "Female");
    }

    public Person hasFamily(){
        if(this.husband.getMotherName() == null){
            return wife;
        }else{
            return husband;
        }
    }

    public FamilyComponent getWife(){
        return wife;
    }

    public String getName(){
        return this.hasFamily().getName();
    }

    /* For adding family members */
    public void add(FamilyComponent f){
        familyPeople.add(f);
    }

    /* Getting to know the gender of Family Member */
    public String getGender(){
        Person p = this.hasFamily();
        return p.getGender();
    }

    /* Retrieving Sons */
    public ArrayList<String> getSons(){
        ArrayList<String> sons = new ArrayList<>();
        for(FamilyComponent s : familyPeople){
            if(s.getGender().equals("Male")){
                sons.add(s.getName());
            }
        }
        return sons;
    }

    /* Retrieving Daughters */
    public ArrayList<String> getDaughters(){
        ArrayList<String> daughters = new ArrayList<>();
        for(FamilyComponent s : familyPeople){
            if(s.getGender().equals("Female")){
                daughters.add(s.getName());
            }
        }
        return daughters;
    }

    public boolean searchChildren(String name){
        for(FamilyComponent p : familyPeople) {
            if(p instanceof Couple){
                if((((Couple) p).husband.getName().equals(name)) || (((Couple) p).wife.getName().equals(name))){
                    return true;
                }
            }
            else {
                if (p.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> getChildrenName(){
        ArrayList<String> children = new ArrayList<>();
        for(FamilyComponent c : familyPeople){
            children.add(c.getName());
        }
        return children;
    }

    public ArrayList<FamilyComponent> getChildren(){
        return familyPeople;
    }

}
