package com.company;

public class Books {

    private int numOfTimesLoaned = 0;
    private String availability = "Available";
    private String number;
    private String title;
    private String author;
    private String genre;
    private String subgenre;
    private String publisher;

    public Books(int numOfTimesLoaned, String availability, String number, String title, String author, String genre, String subgenre, String publisher) {
        this.numOfTimesLoaned = numOfTimesLoaned;
        this.availability = availability;
        this.number = number;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subgenre = subgenre;
        this.publisher = publisher;
    }

    public Books() {
    }

    public int getNumOfTimesLoaned() {
        return numOfTimesLoaned;
    }

    public void setNumOfTimesLoaned(int numOfTimesLoaned) {
        this.numOfTimesLoaned = numOfTimesLoaned;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}