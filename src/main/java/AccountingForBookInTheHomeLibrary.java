//import model.Book;
//import role.User;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class AccountingForBookInTheHomeLibrary {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////  книги, авторы, пароли, логины
//        List<Book> bookList = new ArrayList<>();
//        List<String> autors1 = new ArrayList<>();
//        autors1.add("Tolstoy"); autors1.add("Pushkin");
//        bookList.add(new Book(1, "voina i mir", autors1, 1984));
//
//        List<String> autors2 = new ArrayList<>();
//        autors2.add("vova"); autors2.add("dima");
//        bookList.add(new Book(2, "fight club", autors2, 1984));
//
//        List<String> autors3 = new ArrayList<>();
//        autors3.add("Tolstoy"); autors3.add("vanya");
//        bookList.add(new Book(3, "1864", autors3, 1984));
//
//        List<String> autors4 = new ArrayList<>();
//        autors4.add("dima"); autors4.add("stas");
//        bookList.add(new Book(4, "garry potter", autors4, 1984));
//
//        List<String> autors5 = new ArrayList<>();
//        autors5.add("sveta"); autors5.add("vova");
//        bookList.add(new Book(5, "forrest gump", autors5, 1984));
//
//        List<User> users = new ArrayList<>();
//        Admin adminData = new Admin("admin", "admin");
//        List<User> userList = new ArrayList<>();
//        userList.add(new User(1, "ss", "1234"));
//        userList.add(new User(2, "vv", "1234"));
//
//        String choice = "";
//        String start = "Hi!\n"+
//                "- Enter \"1\" to come in;\n" +
//                "for end enter \"exit\"\n";
//        System.out.println(start);
//        while (!choice.equalsIgnoreCase("exit")) {
//            System.out.print("Enter command: ");
//            choice = reader.readLine();
//            switch (choice) {
//                case "1":
//                    toComeIn(userList, adminData, bookList);
//                    break;
//                case "exit":
//                    System.out.println("\nOver.");
//                    break;
//                default:
//                    System.out.println("Incorrect. Please repeat one more time.\n");
//
//            }
//        }
//    }
//
//    private static void toComeIn(List<User> userList, Admin adminData, List<Book> bookList) throws IOException {
//        System.out.println("Enter login");
//        Scanner in1 = new Scanner(System.in);
//        String login = in1.nextLine();
//        System.out.println("Enter password");
//        String password = in1.nextLine();
//// проверка кто вы админ или юзер
//        for (User u : userList){
//            if (login.equals(adminData.getLogin()) && password.equals(adminData.getPassword())){
//                adminOperation(bookList);
//            }   else if (login.equals(u.getLogin()) && password.equals(u.getPassword())){
//                userOperation(bookList, login);
//            }
//        }
//    }
//
//    private static void userOperation(List<Book> bookList, String login) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String choice = "";
//        String start = "Hi! " + login + "\n"+
//                "- Enter \"1\" for show directory;\n" +
//                "for end enter \"exit\"\n";
//        System.out.println(start);
//        while (!choice.equalsIgnoreCase("exit")) {
//            System.out.print("Enter command: ");
//            choice = reader.readLine();
//            switch (choice) {
//                case "1":
//                    showDirectory(bookList);
//                    break;
//                case "exit":
//                    System.out.println("\nOver.");
//                    break;
//                default:
//                    System.out.println("Incorrect. Please repeat one more time.\n");
//
//            }
//        }
//    }
//
//    private static void adminOperation(List<Book> bookList) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String choice = "";
//        String start = "Hi, Admin! \n"+
//                "- Enter \"1\" for show directory;\n" +
//                "- Enter \"2\" for add new book;\n" +
//                "- Enter \"3\" for delete book;\n" +
//                "for end enter \"exit\"\n";
//        System.out.println(start);
//        while (!choice.equalsIgnoreCase("exit")) {
//            System.out.print("Enter command: ");
//            choice = reader.readLine();
//            switch (choice) {
//                case "1":
//                    showDirectory(bookList);
//                    break;
//                case "2":
//                    addBook(bookList);
//                    break;
//                case "3":
//                    deleteBook(bookList);
//                    break;
//                case "exit":
//                    System.out.println("\nOver.");
//                    break;
//                default:
//                    System.out.println("Incorrect. Please repeat one more time.\n");
//
//            }
//        }
//    }
//
//    private static void addBook(List<Book> bookList) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Enter name of new book: ");
//        Scanner in1 = new Scanner(System.in);
//        String bookNewName = in1.nextLine();
//
//        String choice = "";
//        List<String> autorsNew = new ArrayList<>();
//        while (!choice.equalsIgnoreCase("2")) {
//            System.out.print("Add autor or continue:\n" +
//                    "- Enter \"1\" for add autor;\n" +
//                    "- Enter \"2\" for continue;\n");
//            choice = reader.readLine();
//            switch (choice) {
//                case "1":
//                    System.out.println("Enter name of autor: ");
//                    String autorNewName = in1.nextLine();
//                    autorsNew.add(autorNewName);
//                    break;
//                case "2":
//                    System.out.println("\nOver.");
//                    break;
//                default:
//                    System.out.println("Incorrect. Please repeat one more time.\n");
//
//            }
//        }
//        System.out.println("Enter year of new book");
//        int yearOfNewBook = in1.nextInt();
//
//        bookList.add(new Book(bookList.size()+1, bookNewName, autorsNew, yearOfNewBook));
//        System.out.println("Book added!");
//
//        for (Book b : bookList) {
//            System.out.println(b);
//        }
//    }
//
//    private static void showDirectory(List<Book> bookList) {
//        for (Book b : bookList) {
//            System.out.println(b);
//        }
//
//        System.out.println("Enter name of book: ");
//        Scanner in1 = new Scanner(System.in);
//        String bookName = in1.nextLine();
//
//        for (Book b : bookList) {
//            if (b.getName().equals(bookName)){
//                System.out.println(b);
//            }
//        }
//    }
//
//    private static void deleteBook(List<Book> bookList) {
//        for (Book b : bookList) {
//            System.out.println(b);
//        }
//
//        System.out.println("Enter id of book which you want to delete: ");
//        Scanner in1 = new Scanner(System.in);
//        int idOfDeletedBook = in1.nextInt();
//
//        for (Book b : bookList) {
//            if (b.getId() == (idOfDeletedBook+1)){
//                bookList.remove(idOfDeletedBook);
//            }
//        }
//
//        System.out.println("Book deleted!");
//
//        for (Book b : bookList) {
//            System.out.println(b);
//        }
//    }
//
//    private static List<Book> readBookFromTXT(String fileName) {
//        List<Book> books = new ArrayList<>();
//        Path pathToFile = Paths.get(fileName);
//        // create an instance of BufferedReader
//        // using try with resource, Java 7 feature to close resources
//        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
//            // read the first line from the text file
//            String line = br.readLine();
//            // loop until all lines are read
//            while (line != null) {
//                // use string.split to load a string array with the values from
//                // each line of
//                // the file, using a comma as the delimiter
//                String[] attributes = line.split(",");
//                Book book = createJewels(attributes);
////                   adding book into ArrayList
//                books.add(book);
//                // read next line before looping
//                // if end of file reached, line would be null
//                line = br.readLine();
//            }
//        }
//        catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return books;
//    }
//
//    private static Book createJewels(String[] metadata) {
//        int id = Integer.parseInt(metadata[0]);
//        String name = metadata[1];
//        List<String> authors = Collections.singletonList(metadata[2]);
//        int year = Integer.parseInt(metadata[3]);
//
//        // create and return book of this metadata
//        return new Book(id, name, authors, year);
//    }
//}