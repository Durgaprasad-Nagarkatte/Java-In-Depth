package com.durgaprasad.Inheritence.AccessLevels.p2;

import com.durgaprasad.Inheritence.AccessLevels.p1.A1;

public class C2 extends A1 {
    public static void main(String args[]){
        //System.out.println("private member : " + privateMember);
        //System.out.println("Default member : " + defaultMember);

        // Protected members can be accessed by subclasses outside the package of the super class.
        System.out.println("Protected member : " + protectedMember);
        System.out.println("Public member : " + publicMember);
    }
}
