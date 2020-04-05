package com.durgaprasad.Books;

import java.util.Comparator;

public class Book implements Comparable {
    private String title;
    private String author;
    private Integer pubDate;

    public Book(String title, String author, int pubDate) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPubDate() {
        return pubDate;
    }

    public void setPubDate(int pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", year=" + pubDate + "]";
    }

    public int compareTo(Object book) {
        return getTitle().compareTo(((Book)book).getTitle()); // utilizing String’s compareTo
    }
}
