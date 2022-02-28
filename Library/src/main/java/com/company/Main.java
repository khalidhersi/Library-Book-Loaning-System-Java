package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to View All Books in our Library (Enter yes or no)");
        Boolean responseBool = false;
        String response1 = input.nextLine().toLowerCase();
        if (response1.equals("yes")) {
            responseBool = true;
            System.out.println();;
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Thanks for visiting our Library");
        }

        if (responseBool == true) {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                    "D:\\Coding\\developments\\coursework\\Library-Java-Project\\Library\\src\\main\\java\\books_data.json"));

            for (Object o : jsonArray) {
                JSONObject books = (JSONObject) o;

                long BookId = (long) books.get("Number");

                String Title = (String) books.get("Title");
                System.out.println("Book " + BookId + ": " + Title);
                
                System.out.println();

            }

            System.out.println("Do You want to view Book Data (Enter yes or no)");

            String response2 = input.nextLine().toLowerCase();



            if (response2.equals("yes")) {
                responseBool = true;
                System.out.println();
            }
            else{
                System.out.println("Thanks for visiting our Library");
            }

            if (responseBool == true) {
            for (Object o : jsonArray) {
                JSONObject books = (JSONObject) o;
                long BookId = (long) books.get("Number");

                  String Title = (String) books.get("Title");
                  System.out.println("Book " + BookId + ": " + Title);

                  String Author = (String) books.get("Author");
                  System.out.println("Author: " + Author);

                  String Genre = (String) books.get("Genre");
                  System.out.println("Genre: " + Genre);

                  String SubGenre = (String) books.get("SubGenre");
                  System.out.println("SubGenre: " + SubGenre);

                  String Publisher = (String) books.get("Publisher");
                  System.out.println("Publisher: " + Publisher);

                  System.out.println();  

            }
            }

        }
    }
}
