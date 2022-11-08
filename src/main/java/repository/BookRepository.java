package repository;

import model.Book;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class BookRepository {

    private static final String ADDRESS_FILE = "src/main/resources/Book.csv";

    public List<Book> selectAllBooks () {
        List<Book> books = readBooksFromCSV(ADDRESS_FILE);
//        let's print all the person read from CSV file
        return books;
    }

    public void addBook (Book book) throws FileNotFoundException {
        try(FileWriter writer = new FileWriter(ADDRESS_FILE, true))
        {
            writer.append("\n");
            writer.append(String.valueOf(book.getId()));
            writer.append(",");
            writer.append(book.getName());
            writer.append(",");
            writer.append(book.getAuthor());
            writer.append(",");
            writer.append(String.valueOf(book.getYear()));


            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteBook (Book book){

    }

    private static List<Book> readBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                Book book = createBooks(attributes);
//                   adding book into ArrayList
                books.add(book);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return books;
    }

    private static Book createBooks(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String author = metadata[2];
        int year = Integer.parseInt(metadata[3]);
        // create and return book of this metadata
        return new Book(id ,name, author, year);
    }
}
