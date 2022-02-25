package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to View All Books in our Library");
        Boolean responseBool = false;
        String response1 = input.nextLine().toLowerCase();
        if (response1.equals("yes")) {
            responseBool = true;
            input.close();
        } else {
            input.close();
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

//                String Author = (String) books.get("Author");
//                System.out.println("Author: " + Author);
//
//                String Genre = (String) books.get("Genre");
//                System.out.println("Genre: " + Genre);
//
//                String SubGenre = (String) books.get("SubGenre");
//                System.out.println("SubGenre: " + SubGenre);
//
//                String Publisher = (String) books.get("Publisher");
//                System.out.println("Publisher: " + Publisher);
                System.out.println();

            }

            Scanner input2 = new Scanner(System.in);

            System.out.println("Do You wan to View a specific Book");

            String response2 = input2.nextLine().toLowerCase();



            if (response2.equals("yes")) {
                responseBool = true;
                input.close();
            }

            if (responseBool == true) {
            System.out.println("Please Enter a Book Name or ID");
            for (Object o : jsonArray) {
                JSONObject books = (JSONObject) o;
                long BookId = (long) books.get("Number");

                String Title = (String) books.get("Title");

                if ((response2.equals(Title)) || (response2.equals(BookId))) {
                    System.out.println("hey");
                    input2.close();
                } else {
                    input2.close();
                    System.out.println("Please Enter a Valid Book Name or ID");
                }
            }
            }

        }
    }
}
