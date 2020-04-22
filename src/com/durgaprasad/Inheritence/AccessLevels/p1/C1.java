package com.durgaprasad.Inheritence.AccessLevels.p1;

public class C1 extends A1{
    public static void main(String[] args){
        // Private members are not accessible
        //System.out.println("private member : " + privateMember);
        System.out.println("Default member : " + defaultMember);
        System.out.println("Protected member : " + protectedMember);
        System.out.println("Public member : " + publicMember);
    }
}
