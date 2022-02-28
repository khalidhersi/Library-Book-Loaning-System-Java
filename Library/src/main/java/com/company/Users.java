package com.company;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private String name;
    private  String password;
    private List<Books> borrowedBooks = new ArrayList<>();

    public Users(String name, String password, List<Books> borrowedBooks) {
        this.name = name;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void getListOfLoaned() {
        for (Books books : borrowedBooks) {
            System.out.println("Number: " + books.getNumber());
            System.out.println("Title: " + books.getTitle());
            System.out.println("Author: " + books.getAuthor());
            System.out.println("Genre: " + books.getGenre());
            System.out.println("Subgenre: " + books.getSubgenre());
            System.out.println("Publisher: " + books.getPublisher());
            System.out.println("");
        }
    }
}
