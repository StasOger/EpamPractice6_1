package service;

import model.Book;
import repository.BookRepository;
import repository.UserRepository;
import role.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private UserRepository userRepository = new UserRepository();
    private BookRepository bookRepository = new BookRepository();
    private EmailService emailService = new EmailService();

    public void run(){
        try {
            System.out.println("Enter login");
            Scanner in1 = new Scanner(System.in);
            String login = in1.nextLine();
            System.out.println("Enter password");
            String password = in1.nextLine();
// проверка кто вы админ или юзер
            User user = userRepository.getUser(login,password);
            String role = user.getRole();
            if(role.equals("admin")){
                adminOperation();
            } else if (role.equals("user")) {
                userOperation();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userOperation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        String start = "Hi, User! \n"+
                "- Enter \"1\" for show directory;\n" +
                "- Enter \"2\" for find book;\n" +
                "for end enter \"exit\"\n";
        System.out.println(start);
        while (!choice.equalsIgnoreCase("exit")) {
            System.out.print("Enter command: ");
            choice = reader.readLine();
            switch (choice) {
                case "1":
                    showDirectory();
                    break;
                case "2":
                    findBook();
                    break;
                case "exit":
                    System.out.println("\nOver.");
                    break;
                default:
                    System.out.println("Incorrect. Please repeat one more time.\n");

            }
        }
    }

    private void findBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        String start = "Hi, User! \n"+
                "- Enter \"1\" for find book by name;\n" +
                "- Enter \"2\" for find book by year;\n" +
                "- Enter \"3\" for find book by author;\n" +
                "for end enter \"exit\"\n";
        System.out.println(start);
        while (!choice.equalsIgnoreCase("exit")) {
            System.out.print("Enter command: ");
            choice = reader.readLine();
            switch (choice) {
                case "1":
                    findBookByName();
                    break;
                case "2":
                    findBookByYear();
                    break;
                case "3":
                    findBookByAuthor();
                    break;
                case "exit":
                    System.out.println("\nOver.");
                    break;
                default:
                    System.out.println("Incorrect. Please repeat one more time.\n");

            }
        }
    }

    private void findBookByAuthor() {
        System.out.println("Enter author: ");
        Scanner in1 = new Scanner(System.in);
        String bookAuthor = in1.nextLine();
        List<Book> bookList = bookRepository.selectAllBooks();
        for (Book b: bookList){
            if (bookAuthor.equals(b.getAuthor())){
                System.out.println(b);
            }
        }
    }

    private void findBookByYear() {
        System.out.println("Enter author: ");
        Scanner in1 = new Scanner(System.in);
        int bookYear = in1.nextInt();
        List<Book> bookList = bookRepository.selectAllBooks();
        for (Book b: bookList){
            if (bookYear == b.getYear()){
                System.out.println(b);
            }
        }
    }

    private void findBookByName() {
        System.out.println("Enter name: ");
        Scanner in1 = new Scanner(System.in);
        String bookName = in1.nextLine();
        List<Book> bookList = bookRepository.selectAllBooks();
        for (Book b: bookList){
            if (bookName.equals(b.getName())){
                System.out.println(b);
            }
        }
    }

    public void adminOperation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        String start = "Hi, Admin! \n"+
                "- Enter \"1\" for show directory;\n" +
                "- Enter \"2\" for add new book;\n" +
                "- Enter \"3\" for delete book;\n" +
                "for end enter \"exit\"\n";
        System.out.println(start);
        while (!choice.equalsIgnoreCase("exit")) {
            System.out.print("Enter command: ");
            choice = reader.readLine();
            switch (choice) {
                case "1":
                    showDirectory();
                    break;
                case "2":
                    addBook();
                    break;
                case "3":
                    deleteBook();
                    break;
                case "exit":
                    System.out.println("\nOver.");
                    break;
                default:
                    System.out.println("Incorrect. Please repeat one more time.\n");

            }
        }
    }

    private void deleteBook() {
        List<Book> bookList = bookRepository.selectAllBooks();
        for (Book b: bookList){
            System.out.println(b);
        }

        System.out.println("Enter id of book which you want to delete: ");
        Scanner in1 = new Scanner(System.in);
        int idOfDeletedBook = in1.nextInt();
        for (Book b: bookList){
            if (b.getId() == idOfDeletedBook){
                bookRepository.deleteBook(b);
            }
        }
    }

    private void showDirectory() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        changePage(counter);
        String choice = "";
        String start ="- Enter \"1\" for open previous page;\n" +
                "- Enter \"2\" for open next page;\n" +
                "for end enter \"exit\"\n";
        System.out.println(start);
        while (!choice.equalsIgnoreCase("exit")) {
            System.out.print("Enter command: ");
            choice = reader.readLine();
            switch (choice) {
                case "1":
                    counter--;
                    changePage(counter);
                    break;
                case "2":
                    counter++;
                    changePage(counter);
                    break;
                case "exit":
                    System.out.println("\nOver.");
                    break;
                default:
                    System.out.println("Incorrect. Please repeat one more time.\n");

            }
        }
    }

    private void changePage(int counter) {
        List<Book> bookList = bookRepository.selectAllBooks();
        for (Book b: bookList){
            if (b.getId()>=10*counter && b.getId()<10+10*counter){
                System.out.println(b);
            }
        }
    }

    private void addBook() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter name of new book: ");
        Scanner in1 = new Scanner(System.in);
        String bookNewName = in1.nextLine();

        System.out.println("Enter author of new book: ");
        String bookNewAuthor = in1.nextLine();

        System.out.println("Enter year of new book");
        int yearOfNewBook = in1.nextInt();

        List<Book> bookList = bookRepository.selectAllBooks();
        List<User> userList = userRepository.getAllUsers();

        bookRepository.addBook(new Book(bookList.size()+1, bookNewName, bookNewAuthor, yearOfNewBook));

        String message = ("Book added!"+bookNewName+" "+bookNewAuthor+" "+ yearOfNewBook);
        for (User user: userList){
            String email = user.getEmail();
            emailService.sendEmail(email, message);
        }

        System.out.println("Book added!");
    }


}
