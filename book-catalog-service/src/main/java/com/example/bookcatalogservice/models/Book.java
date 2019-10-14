package com.example.bookcatalogservice.models;

public class Book {

    private int bookID;
    private String name;

    public Book(){}

    public Book(int bookID, String name){
        this.bookID = bookID;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
