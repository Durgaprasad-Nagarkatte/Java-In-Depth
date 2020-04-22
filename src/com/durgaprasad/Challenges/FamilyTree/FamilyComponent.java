package com.durgaprasad.Challenges.FamilyTree;

import java.util.ArrayList;

public abstract class FamilyComponent {
    public void add(FamilyComponent f){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getGender(){
        throw new UnsupportedOperationException();
    }

    public boolean searchChildren(String name){
        throw new UnsupportedOperationException();
    }

    public ArrayList<FamilyComponent> getSons(String name){
        throw new UnsupportedOperationException();
    }

    public ArrayList<FamilyComponent> getDaughters(String name){
        throw new UnsupportedOperationException();
    }

    public ArrayList<FamilyComponent> getChildren(){
        throw new UnsupportedOperationException();
    }


}
