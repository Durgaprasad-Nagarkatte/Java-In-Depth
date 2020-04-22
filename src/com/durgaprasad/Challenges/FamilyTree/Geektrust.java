package com.durgaprasad.Challenges.FamilyTree;
import java.io.*;
import java.util.ArrayList;

public class Geektrust {
    public static void initializaFamily(FamilyComponent fam1, Family fam){
        FamilyComponent fam2 = new Couple("Chit", "Amba", "Queen Anga", null);
        FamilyComponent fam3 = new Person("Ish", "Quuen Anga", "Male");
        FamilyComponent fam4 = new Couple("Vich", "Lika", "Queen Anga", null);
        FamilyComponent fam5 = new Couple("Aras", "Chitra", "Queen Anga", null);
        FamilyComponent fam6 = new Couple("Vyan", "Satya", null, "Satya");

        fam1.add(fam2);
        fam1.add(fam3);
        fam1.add(fam4);
        fam1.add(fam5);
        fam1.add(fam6);

        fam.addNamesToFamily(new String[]{"Chit", "Amba", "Ish", "Vich", "Lika", "Aras", "Chitra", "Vyan", "Satya"});

        FamilyComponent fam7 = new Couple("Jaya", "Dritha",null , "Amba");
        FamilyComponent fam8 = new Person("Tritha", "Amba", "Female");
        FamilyComponent fam9 = new Person("Vritha", "Amba", "Male");

        fam2.add(fam7);
        fam2.add(fam8);
        fam2.add(fam9);

        fam.addNamesToFamily(new String[]{"Jaya", "Dritha", "Tritha", "Vritha"});

        FamilyComponent fam10 = new Person("Vila", "Lika", "Female");
        FamilyComponent fam11 = new Person("Chika", "Lika", "Female");
        fam4.add(fam10);
        fam4.add(fam11);

        fam.addNamesToFamily(new String[]{"Vila", "Chika"});

        FamilyComponent fam12 = new Couple("Arit", "Jnki",null , "Chitra");
        FamilyComponent fam13 = new Person("Ahit", "Chitra", "Male");

        fam5.add(fam12);
        fam5.add(fam13);

        FamilyComponent fam14 = new Couple("Asva", "Satvy","Satya" , null);
        FamilyComponent fam15 = new Couple("Vyas", "Krpi","Satya" , null);
        FamilyComponent fam16 = new Person("Atya", "Satya", "Female");

        fam6.add(fam14);
        fam6.add(fam15);
        fam6.add(fam16);

        fam.addNamesToFamily(new String[]{"Arit", "Jnki", "Ahit", "Asva", "Satvy", "Vyas", "Krpi", "Atya"});

        FamilyComponent fam17 = new Person("Yodhan", "Jaya", "Male");
        fam7.add(fam17);

        FamilyComponent fam18 = new Person("Laki", "Jnki", "Male");
        FamilyComponent fam19 = new Person("Lavnya", "Jnki", "Female");
        fam12.add(fam18);
        fam12.add(fam19);

        FamilyComponent fam20 = new Person("Vasa", "Satvy", "Male");
        fam14.add(fam20);

        fam.addNamesToFamily(new String[]{"Yodhan", "Laki", "Lavnya", "Vasa"});

        FamilyComponent fam21 = new Person("Kriya", "Krpi", "Male");
        FamilyComponent fam22 = new Person("Krithi", "Krpi", "Female");
        fam15.add(fam21);
        fam15.add(fam22);

        fam.addNamesToFamily(new String[]{"Kriya", "Krithi"});
    }

    public static void print(Relation relation){
        if(!relation.isFound()){
            System.out.println("PERSON_NOT_FOUND");
        }else{
            ArrayList<String> rel = relation.getRelations();
            if(rel.size() == 0){
                System.out.println("NONE");
            }else{
                for(String f : rel) {
                    System.out.print(f + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printRelations(String name, String rel, Family fam){
        Relation relation;
        switch (rel) {
            case "Paternal-Uncle":
                relation = fam.getPaternalUncle(name);
                print(relation);
                break;
            case "Maternal-Uncle":
                relation = fam.getMaternalUncle(name);
                print(relation);
                break;
            case "Paternal-Aunt":
                relation = fam.getPaternalAunt(name);
                print(relation);
                break;
            case "Maternal-Aunt":
                relation = fam.getMaternalAunt(name);
                print(relation);
                break;
            case "Sister-In-Law":
                relation = fam.getSisterInLaw(name);
                print(relation);
                break;
            case "Brother-In-Law":
                relation = fam.getBrotherInLaw(name);
                print(relation);
                break;
            case "Son":
                relation = fam.getSons(name);
                print(relation);
                break;
            case "Daughter":
                relation = fam.getDaughters(name);
                print(relation);
                break;
            case "Siblings":
                relation = fam.getSiblings(name);
                print(relation);
                break;
        }
    }

    public static void add(String name, String child_name, String gender, Family fam1){
        String success = fam1.addNode(name, child_name, gender);
        if(success.equals("SUCCESS")){
            System.out.println("CHILD_ADDITION_SUCCEEDED");
        }
        else if(success.equals("NOT FOUND")){
            System.out.println("PERSON_NOT_FOUND");
        }
        else{
            System.out.println("CHILD_ADDITION_FAILED");
        }
    }

    public static void main(String[] args) throws IOException {
        FamilyComponent fam1 = new Couple("King Shan", "Queen Anga", null, null);
        Family family = new Family(fam1);
        family.addNamesToFamily(new String[]{"King Shan", "Queen Anga"});
        initializaFamily(fam1, family);

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] parameters = line.split(" ");

                if(parameters[0].equals("ADD_CHILD")){
                    add(parameters[1], parameters[2], parameters[3], family);
                }
                else if (parameters[0].equals("GET_RELATIONSHIP")){
                    printRelations(parameters[1].trim(), parameters[2].trim(), family);
                }
                line = br.readLine();
            }
            //String everything = sb.toString();
        } finally {
            br.close();
        }


        /*
        printRelations("Atya", "Siblings", family);
        printRelations("Vich", "Brother-In-Law", family);
        printRelations("Pjali", "Son", family);

        add("Pjali", "Srutak",  "Male", family);
        add("Asva", "Vani",  "Female", family);
        add("Chitra",  "Aria",  "Female", family);
        printRelations("Aria", "Siblings", family);*/

    }
}
