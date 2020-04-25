package com.durgaprasad.AbstractClasses;

public class ConcreteSubClass extends AbstractSubClass {
    @Override
    void test3() {
        System.out.println("Test 3");
    }

    @Override
    void test2() {
        System.out.println("Test 2");
    }

    public static void main(String[] args){
        ConcreteSubClass subClass = new ConcreteSubClass();
        subClass.test1();
        subClass.test2();
        subClass.test3();
    }
}
