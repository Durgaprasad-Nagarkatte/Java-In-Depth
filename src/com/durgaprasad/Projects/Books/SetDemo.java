package com.durgaprasad.Projects.Books;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static Set<Book> treeSetDemo(Comparator comparator){
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books;
        if (comparator != null){
            books = new TreeSet<>(comparator);
        }
        else{
            books = new TreeSet<>();
        }

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for(Book book: books){
            System.out.println(book);
        }

        return books;
    }

    public static void main(String[] args){
        treeSetDemo(new PubDateAscComparator());
        treeSetDemo(new PubDateDescComparator());
        treeSetDemo(null);
    }
}
