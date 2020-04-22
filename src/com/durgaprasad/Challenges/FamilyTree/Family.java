package com.durgaprasad.Challenges.FamilyTree;

import java.util.*;

public class Family {
    FamilyComponent root;
    HashSet<String> familyNames;

    public Family(FamilyComponent fam){
        this.root = fam;
        this.familyNames = new HashSet<>();
    }

    public void addNamesToFamily(String[] names){
        for(String name : names){
            familyNames.add(name);
        }
    }

    public void printFamilyNames(){
        for(String name : familyNames){
            System.out.println(name);
        }
    }

    public boolean searchNameInFamily(String name){
        if(this.familyNames.contains(name)){
            return true;
        }
        return false;
    }

    /*
    public boolean searchNameInFamily(String name){
        Queue<FamilyComponent> q = new LinkedList<>();
        q.add(this.root);

        if(((Couple)this.root).husband.getName().equals(name) || (((Couple)this.root).wife.getName().equals(name))){
            return true;
        }

        while(!q.isEmpty()){
            FamilyComponent f = q.poll();
            for(FamilyComponent c : f.getChildren()){
                if (c instanceof Couple){
                    if(((Couple) c).husband.getName().equals(name) || ((Couple) c).wife.getName().equals(name)){
                        return true;
                    }
                    q.add(c);
                }
                else if(c instanceof Person){
                    if(c.getName().equals(name)){return true;}
                }
            }
        }
        return false;
    }*/

    public FamilyComponent searchTree(String name){
        Queue<FamilyComponent> people = new LinkedList<>();
        people.add(this.root);

        while(!people.isEmpty()){
            FamilyComponent f = people.poll();
            if(f instanceof Couple){
                if(((Couple) f).husband.getName().equals(name) || ((Couple) f).wife.getName().equals(name)){
                    return f;
                }
            }else if(f instanceof Person){
                if(f.getName().equals(name)){
                    return f;
                }
            }
            for(FamilyComponent c : f.getChildren()){
                people.add(c);
            }
        }
        return null;
    }

    private Relation getPaternalAndMaternalRelation(String name, String parentGender, String relationGender){
        ArrayList<String> relations = new ArrayList<>();

        boolean found = searchNameInFamily(name);
        if(!found){
            return new Relation(false, relations);
        }

        Queue<FamilyComponent> people = new LinkedList<>();
        people.add(this.root);

        while(!people.isEmpty()){
            FamilyComponent f = people.poll();
            if(f instanceof Couple){
                for(FamilyComponent child : f.getChildren()){
                    if(child instanceof Couple && child.searchChildren(name)){
                        for(FamilyComponent sib: f.getChildren()){
                            if(child.getGender().equals(parentGender) && sib.getGender().equals(relationGender) && !(sib.equals(child))){
                                relations.add(sib.getName());
                            }
                        }
                        return new Relation(true, relations);
                    }
                    else{
                        if(child instanceof Couple){
                            people.add(child);
                        }
                    }
                }
            }
        }
        return new Relation(true, relations);
    }

    public Relation getPaternalUncle(String name){
        Relation parentalUncle;
        parentalUncle = getPaternalAndMaternalRelation(name, "Male", "Male");
        return parentalUncle;
    }

    public Relation getMaternalUncle(String name){
        Relation maternalUncle;
        maternalUncle = getPaternalAndMaternalRelation(name, "Female", "Male");
        return maternalUncle;
    }

    public Relation getPaternalAunt(String name) {
        Relation paternalAunt;
        paternalAunt = getPaternalAndMaternalRelation(name, "Male", "Female");
        return paternalAunt;
    }

    public Relation getMaternalAunt(String name) {
        Relation maternalAunt;
        maternalAunt = getPaternalAndMaternalRelation(name, "Female", "Female");
        return maternalAunt;
    }


    public Relation getSisterInLaw(String name) {
        ArrayList<String> sisterInLaws = new ArrayList<>();
        ArrayList<FamilyComponent> siblings;
        FamilyComponent mother;

        if(!searchNameInFamily(name)){
            return new Relation(false, sisterInLaws);
        }

        FamilyComponent curr = searchTree(name);

        if(curr instanceof Couple){
            if(((Couple) curr).husband.getName().equals(name)){
                if(((Couple) curr).wife.getMotherName() != null){
                    mother = getMother(((Couple) curr).wife.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s.getGender().equals("Female") && !(s.equals(curr))){
                            sisterInLaws.add(s.getName());
                        }
                    }
                }else{
                    mother = getMother(((Couple) curr).husband.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s instanceof Couple){
                            if(s.getGender().equals("Male") && !(s.equals(curr))){
                                sisterInLaws.add(((Couple) s).wife.getName());
                            }
                        }
                    }
                }
            }
            else if(((Couple) curr).wife.getName().equals(name)){
                if(((Couple) curr).husband.getMotherName() != null){
                    mother = getMother(((Couple) curr).husband.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s.getGender().equals("Female") && !(s.equals(curr))){
                            sisterInLaws.add(s.getName());
                        }
                    }
                }else{
                    mother = getMother(((Couple) curr).wife.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s instanceof Couple){
                            if(s.getGender().equals("Male") && !(s.equals(curr))){
                                sisterInLaws.add(((Couple) s).wife.getName());
                            }
                        }
                    }
                }

            }

        }
        else{
            mother = getMother(((Person) curr).getMotherName());
            siblings = mother.getChildren();
            for(FamilyComponent s : siblings){
                if(s instanceof Couple){
                    if(s.getGender().equals("Male")){
                        sisterInLaws.add(((Couple) s).wife.getName());
                    }
                }
            }

        }
        return new Relation(true, sisterInLaws);
    }

    public Relation getBrotherInLaw(String name){
        ArrayList<String> brotherInLaws = new ArrayList<>();
        ArrayList<FamilyComponent> siblings;
        FamilyComponent mother;

        if(!searchNameInFamily(name)){
            return new Relation(false, brotherInLaws);
        }

        FamilyComponent curr = searchTree(name);
        if(curr instanceof Couple){
            if(((Couple) curr).husband.getName().equals(name)){
                if(((Couple) curr).wife.getMotherName() != null){
                    mother = getMother(((Couple) curr).wife.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s.getGender().equals("Male") && !(s.equals(curr))){
                            brotherInLaws.add(s.getName());
                        }
                    }
                }else{
                    mother = getMother(((Couple) curr).husband.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s instanceof Couple){
                            if(s.getGender().equals("Female") && !(s.equals(curr))){
                                brotherInLaws.add(((Couple) s).husband.getName());
                            }
                        }
                    }
                }
            }
            else if(((Couple) curr).wife.getName().equals(name)){
                if(((Couple) curr).husband.getMotherName() != null){
                    mother = getMother(((Couple) curr).husband.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s.getGender().equals("Male") && !(s.equals(curr))){
                            brotherInLaws.add(s.getName());
                        }
                    }
                }else{
                    mother = getMother(((Couple) curr).wife.getMotherName());
                    siblings = mother.getChildren();
                    for(FamilyComponent s : siblings){
                        if(s instanceof Couple){
                            if(s.getGender().equals("Female") && !(s.equals(curr))){
                                brotherInLaws.add(((Couple) s).husband.getName());
                            }
                        }
                    }
                }

            }

        }
        else{
            mother = getMother(((Person) curr).getMotherName());
            siblings = mother.getChildren();
            for(FamilyComponent s : siblings){
                if(s instanceof Couple){
                    if(s.getGender().equals("Female")){
                        brotherInLaws.add(((Couple) s).husband.getName());
                    }
                }
            }

        }
        return new Relation(true, brotherInLaws);
    }

    public Relation getSiblings(String name){
        ArrayList<String> siblings = new ArrayList<>();
        if(!searchNameInFamily(name)){
            return new Relation(false, siblings);
        }
        Queue<FamilyComponent> people = new LinkedList<>();
        people.add(this.root);

        while(people.size() != 0){
            FamilyComponent f = people.poll();
            if(f.searchChildren(name)) {
                siblings = ((Couple)f).getChildrenName();
                siblings.remove(name);
                return new Relation(true, siblings);
            }else{
                if(f.getChildren() != null){
                    for(FamilyComponent p : f.getChildren()){
                        people.add(p);
                    }
                }
            }
        }
        return new Relation(true, siblings);
    }

    public FamilyComponent getMother(String name) {
        Queue<FamilyComponent> people = new LinkedList<>();
        people.add(this.root);

        while (people.size() != 0) {
            FamilyComponent f = people.poll();
            if ((f instanceof Couple)) {
                if (((Couple) f).wife.getName().equals(name)) {
                    return f;
                }
            }
            for(FamilyComponent c : f.getChildren()){
                people.add(c);
            }
        }
        return null;
    }


    public String addNode(String motherName, String name, String gender){
        if(!searchNameInFamily(motherName)){
            return "NOT FOUND";
        }
        FamilyComponent f = getMother(motherName);
            if(f != null) {
                if ((f instanceof Couple) && (((Couple) f).getWife().getName().equals(motherName))){
                    Person p = new Person(name, motherName, gender);
                    f.add(p);
                    familyNames.add(name);
                    return "SUCCESS";
                }
            }
        return "ADDITION_FAILED";
    }

    public Relation getSons(String name){
        ArrayList<String> sons = new ArrayList<>();
        if(!searchNameInFamily(name)){return new Relation(false, sons);}
        else{
            FamilyComponent f = searchTree(name);
            if(f != null){
                if(f instanceof Couple){
                    sons = ((Couple) f).getSons();
                    return new Relation(true, sons);
                }
            }
        }
        return new Relation(true, sons);
    }

    public Relation getDaughters(String name){
        ArrayList<String> daughters = new ArrayList<>();
        if(!searchNameInFamily(name)){return new Relation(false, daughters);}
        else{
            FamilyComponent f = searchTree(name);
            if(f != null){
                if(f instanceof Couple){
                    daughters = ((Couple) f).getDaughters();
                    return new Relation(true, daughters);
                }
            }
        }
        return new Relation(true, daughters);
    }
}
