package com.durgaprasad.Challenges.FamilyTree;

import java.util.ArrayList;

public class Relation {
    private boolean found;
    private ArrayList<String> relations;

    public Relation(boolean found, ArrayList<String> relations){
        this.found = found;
        this.relations = relations;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public ArrayList<String> getRelations() {
        return relations;
    }

    public void setRelations(ArrayList<String> relations) {
        this.relations = relations;
    }
}
