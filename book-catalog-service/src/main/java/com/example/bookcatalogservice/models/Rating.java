package com.example.bookcatalogservice.models;

public class Rating {
    private int bookID;
    private String name;
    private int rating;

    public Rating(){}

    public Rating(int bookID, String name, int rating){
        this.bookID = bookID;
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
