import java.util.*;
public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<Book>(); // This is where you store the data of the user has put and will be stored to the book class
    Scanner scan = new Scanner (System.in);
    int availableCopies;
    boolean hasBorrowed = false;
    
    public void createBook() {
        System.out.print("Title: ");
        String title = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("International Standard Book Number (ISBN): ");
        String isbn = scan.nextLine();
        System.out.print("Available Copies: ");
        if (scan.hasNextInt()) {
            availableCopies = scan.nextInt();            
                for (Book book : books) {
                    if (book.getISBN().equals(isbn)) { // checks if the isbn of the old book has the same isbn with a new book to avoid duplication
                        System.out.println("\nBook already exists");
                        return;
                    }
                }
                books.add(new Book(title, author, isbn, availableCopies)); // the data will be stored into the book class based on the array list
                System.out.println("\nThe book has been created!");
        }
        else 
            System.out.println("\nAvailable copies must be only in a Numerical Form. Please try again.");
        scan.nextLine();

                
    }

    public void borrowBook(){
        System.out.print("\nEnter the ISBN of the book to borrow: ");
        String bookISBN = scan.nextLine();
        for (Book book : books) {
            if (bookISBN.equals(book.getISBN())) { // checks if the isbn matches the user input isbn
                if (book.getAvailableCopies() > 0) { // checks if the available copies of the book is greater than 0
                    book.borrowedBooks(book.getAvailableCopies() - 1); // decrement the book's available copies
                    System.out.println("\nBook borrowed successfully");
                    hasBorrowed = true; // turns into true if the book is borrowed
                    return;
                } 
                else {
                    System.out.println("\nThe book is currently out of stock.");
                    return;
                }
            } 
        }
        System.out.println("\nThe book doesn't exist. Please try again");

    }
    
    public void returnBook() {
        System.out.print("\nEnter the ISBN of the book to return: ");
        String bookName = scan.nextLine();
        for (Book book : books) {
            if (bookName.equals(book.getISBN())) { // checks if the isbn matches the user input isbn
                if (hasBorrowed != false) { // checks if the book has been borrowed or not 
                    book.returnedBooks(book.getAvailableCopies() + 1); // increment the book's available copies
                    System.out.println("\nBook has been returned successfully");
                    hasBorrowed = false; // turns into false after returng the borroweed book
                    return;
                }
                else {
                    System.out.println("\nThe book exceeded than its original copies.");
                    return;
                }
            }
        }
        System.out.println("\nThe book doesn't exist. Please try again");   
    }

    public void infoDisplay () { // displays the details of the books
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("International Standard Book Number (ISBN): " + book.getISBN());
            System.out.println("Available Copies: " + book.getAvailableCopies());
            System.out.println();
        }    
    }
}
