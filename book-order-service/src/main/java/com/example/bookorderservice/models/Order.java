package com.example.bookorderservice.models;

public class Order {

    private int orderID;
    private int userID;
    private int bookID;
    private String bookName;

    public Order(int orderID,int userID, int bookID, String bookName){
        this.orderID = orderID;
        this.userID = userID;
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
