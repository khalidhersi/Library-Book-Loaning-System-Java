package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
//        System.out.println("Enter username");
//        String userName = myObj.nextLine();


//        String myJson = new Scanner(new File("../books_data.json")).useDelimiter("\\Z").next();
//        JSONArray myJsonArray = new JSONArray(myJson);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                "D:\\Coding\\developments\\coursework\\Library-Java-Project\\Library\\src\\main\\java\\books_data.json"));
//        System.out.println(jsonArray);

        for (Object o : jsonArray) {
            JSONObject books = (JSONObject) o;

            int Number = (int) books.get("Number");
            System.out.println("Id: " + Number);

            String Title = (String) books.get("Title");
            System.out.println("Title: " + Title);

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
