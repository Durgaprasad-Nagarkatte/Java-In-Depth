package com.durgaprasad.Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
     private static void hashSetDemo(){
         Set<String> set = new HashSet<>();
         set.add("a");
         set.add("b");
         set.add("c");
         set.add("a");

         System.out.println("Set : " + set);

         Book book1 = new Book("Durgaprasad", "Journey of my life", 2020);
         Book book2 = new Book("Durgaprasad", "Journey of my life", 2020);

         Set<Book> books = new HashSet<>();
         books.add(book1);
         books.add(book2);

         //To avoid adding duplicate objects into the set
         //there is a need to implement hashCode() and equals() in
         //Book class.
         System.out.println("Set : " + books);
     }

     private static void treeSetDemo(){
         Set<Book> treeSet = new TreeSet<>();

         Book book1 = new Book("Harry Potter", "JK Rowling", 1997);
         Book book2 = new Book("Harry Potter", "JK Rowling", 1997);
         Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
         Book book4 = new Book("Effective Java", "Joshua Bloch", 2002);

         Set<Book> books = new TreeSet<>();
         books.add(book1);
         books.add(book2);
         books.add(book3);
         books.add(book4);

         System.out.println(books);
     }

     public static void main(String[] args){
         hashSetDemo();
         treeSetDemo();
     }
}

class Book{
    private String author;
    private String title;
    private int year;

    Book(String author, String title, int year){
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }


    //Rather than implementing these objects by ourselves better to use
    //already implemented methods provided by IDE's.
    /*
    public int hashCode(){
        return this.title.hashCode();
    }

    public boolean equals(Object o){
        return ((year == ((Book)o).getYear()) && (author == ((Book) o).getAuthor()));
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return author.equals(book.author) &&
                title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }
}
