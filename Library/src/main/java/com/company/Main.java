package com.company;

import com.company.Admins;
import com.company.Books;
import com.company.Users;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public Main () {}
    public static void main(String[] args) throws FileNotFoundException {

        // book_data.csv file location
        String path = "D:\\Coding\\developments\\coursework\\Library-Java-Project\\Library\\src\\main\\java\\books_data.csv";

        // BufferReader to read the file
        Reader reader = new BufferedReader(new FileReader(path));

        // CsvToBeanBuilder building blueprint for csv data
        CsvToBean<Books> csvReader = new CsvToBeanBuilder<Books>(reader)
                .withType(Books.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        // book object is parsed into an empty list
        List<Books> bookList = csvReader.parse();

        // empty lists for users and admins
        List<Users> listOfUsers  = new ArrayList<>();
        List<Admins> listOfAdmins  = new ArrayList<>();

        Users user1 = new Users("Khalid Hersi", "Password123", new ArrayList<>());
        listOfUsers.add(user1);

        Admins admin1 = new Admins("Rick Sanchez", "hey.morty123");
        listOfAdmins.add(admin1);

        // create instance of a scanner class to read each line
        boolean system = true;
        Scanner sc = new Scanner(System.in);

        //while loop to keep the system running
        while(system) {
            System.out.println("Welcome! 1) Are you a current user (type: user) 2) Are you an admin (type: admin) 3) Are you a new user (type: new):");
            String type = sc.nextLine();

            boolean exit = true;

            if(type.equalsIgnoreCase("new")) {
                System.out.println("");
                System.out.println("Register account:");
                System.out.println("");
                System.out.println("Please enter your full name (case-sensitive):");
                String name = sc.nextLine();
                System.out.println("");
                System.out.println("Please enter your password (case-sensitive):");
                String pass = sc.nextLine();
                System.out.println("");
                listOfUsers.add(new Users(name, pass, new ArrayList<>()));
                System.out.println("Congratulations! You've registered a new account. You'll now be redirected to the login page.");
                System.out.println("");
                exit = false;
            }
            if(type.equalsIgnoreCase("user")) {
                System.out.println("");
                System.out.println("Please enter your full name (case-sensitive):");
                String name = sc.nextLine();
                System.out.println("");
                System.out.println("Please enter your password (case-sensitive):");
                String pass = sc.nextLine();

                do {
                    for (Users user: listOfUsers) {
                        if(user.getName().equals(name) && user.getPassword().equals(pass)) {

                            List<Users> currentUser = listOfUsers.stream()
                                    .filter(u -> u.getName().equals(name) && u.getPassword().equals(pass))
                                    .collect(Collectors.toList());

                            System.out.println("");
                            System.out.println("Please select one of the following 1) View list of available books (type: booklist) 2) View your currently loaned books (type: loaned) 3) Borrow a new book (type: borrow) 4) Return a book (type: return 5) exit system (type: exit)");
                            String selection = sc.nextLine();

                            if(selection.equalsIgnoreCase("booklist")) {
                                for (Books book : bookList) {
                                    if(book.getAvailability().equals("Available")) {
                                        System.out.println("Number: " + book.getNumber());
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("Genre: " + book.getGenre());
                                        System.out.println("Subgenre: " + book.getSubgenre());
                                        System.out.println("Publisher: " + book.getPublisher());
                                        System.out.println("");
                                    }
                                }
                            } else if(selection.equalsIgnoreCase("loaned")) {
                                System.out.println("");
                                currentUser.get(0).getListOfLoaned();
                            } else if(selection.equalsIgnoreCase("borrow")) {
                                System.out.println("");
                                System.out.println("Please type the full title of the book you'd like to borrow from the book list (case-sensitive):");
                                String title = sc.nextLine();
                                for (Books book : bookList) {
                                    if(book.getTitle().contains(title) && book.getAvailability().equals("Available")) {
                                        currentUser.get(0).getBorrowedBooks().add(book);
                                        book.setAvailability("Loaned");
                                        int count = book.getNumOfTimesLoaned();
                                        book.setNumOfTimesLoaned(count = count + 1);
                                        System.out.println("");
                                        System.out.println("You have borrowed the following book:");
                                        System.out.println("");
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("Genre: " + book.getGenre());
                                        System.out.println("Subgenre: " + book.getSubgenre());
                                        System.out.println("Publisher: " + book.getPublisher());
                                        System.out.println("");
                                    }
                                }

                            } else if(selection.equalsIgnoreCase("return")) {
                                System.out.println("");
                                System.out.println("Please type the full title of the book you'd like to return (case-sensitive):");
                                String returnBook = sc.nextLine();
                                List<Books> borrowedBooks = currentUser.get(0).getBorrowedBooks();
                                for (Iterator<Books> itr = borrowedBooks.listIterator();
                                     itr.hasNext();) {
                                    Books book = itr.next();
                                    if(book.getTitle().contains(returnBook)) {
                                        itr.remove();
                                        System.out.println("You have returned the following book:");
                                        System.out.println("");
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("Genre: " + book.getGenre());
                                        System.out.println("Subgenre: " + book.getSubgenre());
                                        System.out.println("Publisher: " + book.getPublisher());
                                        System.out.println("");
                                    }
                                }
                                for (Books book : bookList) {
                                    if(book.getTitle().contains(returnBook)) {
                                        book.setAvailability("Available");
                                    }
                                }
                            } else if(selection.equalsIgnoreCase("exit")) {
                                exit = false;
                                System.out.println("");
                            }
                        }
                    }
                } while (exit);
            } else if (type.equalsIgnoreCase("admin")) {
                System.out.println("");
                System.out.println("Please enter your full name (case-sensitive):");
                String name = sc.nextLine();
                System.out.println("");
                System.out.println("Please enter your password (case-sensitive):");
                String pass = sc.nextLine();

                do {
                    for (Admins admin: listOfAdmins) {
                        if(admin.getName().equals(name) && admin.getPassword().equals(pass)) {

                            System.out.println("");
                            System.out.println("Please select one of the following 1) view available books (type: booklist) 2) view loaned out books (type: loaned) 3) exit system (type: exit):");
                            String selection = sc.nextLine();

                            if(selection.equalsIgnoreCase("booklist")) {
                                for (Books book : bookList) {
                                    if(book.getAvailability().equals("Available")) {
                                        System.out.println("Number: " + book.getNumber());
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("Genre: " + book.getGenre());
                                        System.out.println("Subgenre: " + book.getSubgenre());
                                        System.out.println("Publisher: " + book.getPublisher());
                                        System.out.println("");
                                        System.out.println("Availability: " + book.getAvailability());
                                        System.out.println("Total times loaned out: " + book.getNumOfTimesLoaned());
                                        System.out.println("");
                                    }
                                }
                            } else if(selection.equalsIgnoreCase("loaned")) {
                                for (Books book : bookList) {
                                    if(book.getAvailability().equals("Loaned")) {
                                        System.out.println("Number: " + book.getNumber());
                                        System.out.println("Title: " + book.getTitle());
                                        System.out.println("Author: " + book.getAuthor());
                                        System.out.println("Genre: " + book.getGenre());
                                        System.out.println("Subgenre: " + book.getSubgenre());
                                        System.out.println("Publisher: " + book.getPublisher());
                                        System.out.println("");
                                        System.out.println("Availability: " + book.getAvailability());
                                        System.out.println("Total times loaned out: " + book.getNumOfTimesLoaned());
                                        System.out.println("");
                                    }
                                }
                            } else if(selection.equalsIgnoreCase("exit")) {
                                exit = false;
                                System.out.println("");
                            }
                        }
                    }
                } while(exit);
            }
        }
    }
}
