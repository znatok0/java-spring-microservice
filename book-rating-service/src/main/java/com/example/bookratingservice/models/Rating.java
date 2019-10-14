package com.example.bookratingservice.models;

public class Rating {
    private int bookID;
    private String name;
    private int rating;
    private int userID;

    public Rating(int bookID, String name, int rating, int userID){
        this.bookID = bookID;
        this.name = name;
        this.rating = rating;
        this.userID = userID;
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

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
