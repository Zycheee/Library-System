import java.util.*;
class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<Book>(); // This is where you store the data of the user has put and will be stored to the book class
    private ArrayList<Integer> originalCopies = new ArrayList<Integer>(); // This stores the original copies of a book which will be used later in returning books
    Scanner scan = new Scanner (System.in);

    public void createBook() {
        System.out.print("\nTitle: ");
        String title = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("International Standard Book Number (Must contain 13 digits): ");
        String isbn = scan.nextLine();
        if (isbn.length() != 13) // checks if the isbn is not equal to 13 digits
            System.out.println("\nISBN must contain 13 digits. Please try again");
        else {
            System.out.print("Available Copies: ");
            if (scan.hasNextInt()) {
                int availableCopies = scan.nextInt();   
                    for (Book book : books) {
                        if (book.getISBN().equals(isbn)) { // checks if the isbn of the old book has the same isbn with a new book to avoid duplication
                            System.out.println("\nBook already exists. Please try again");
                            return;
                        }
                    }
                books.add(new Book(title, author, isbn, availableCopies)); // the data will be stored into the book class based on the array list
                originalCopies.add(availableCopies); // this data waill be stored to the original copies of a book that was created by the user
                System.out.println("\nThe book has been created!");
                scan.nextLine();
                }
        else 
            System.out.println("\nAvailable copies must be only in a Numerical Form. Please try again.");
        }
    }

    public void borrowBook(){
        System.out.print("\nEnter the ISBN of the book to borrow: ");
        String bookISBN = scan.nextLine();
        for (Book book : books) {
            if (bookISBN.equals(book.getISBN())) { // checks if the isbn matches the user input isbn
                if (book.getAvailableCopies() > 0) { // checks if the available copies of the book is greater than 0
                    book.borrowedBooks(book.getAvailableCopies() - 1); // decrement the book's available copies
                    System.out.println("\nBook borrowed successfully");
                    System.out.println("\n\t\tTHE BOOK HAS BEEN UPDATED\n-----------------------------------------------------");
                    System.out.println("\nTitle: " + book.getTitle() +"\nAuthor: "+ book.getAuthor() + "\nInternational Standard Book Number (ISBN): " + book.getISBN() + "\nAvailable Copies: " + book.getAvailableCopies());
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
            for (Integer origCopies : originalCopies)
            if (bookName.equals(book.getISBN())) { // checks if the isbn matches the user input isbn
                if (book.getAvailableCopies() < origCopies) { // checks if the book exceeds than its original copies of the book
                    book.returnedBooks(book.getAvailableCopies() + 1); // increment the book's available copies
                    System.out.println("\nBook has been returned successfully");
                    System.out.println("\n\t\tTHE BOOK HAS BEEN UPDATED\n-----------------------------------------------------");
                    System.out.println("\nTitle: " + book.getTitle() +"\nAuthor: "+ book.getAuthor() + "\nInternational Standard Book Number (ISBN): " + book.getISBN() + "\nAvailable Copies: " + book.getAvailableCopies());
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
        System.out.print("-----------------------------------------------------\n\t\t[1] SHOW ALL OF THE BOOKS\n\t\t[2] CHOOSE A BOOK\nINPUT: ");
        if (scan.hasNextInt()) { // checks if the user input is an integer or in numerical form. 
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.print("\n\t\tDETAILS OF THE BOOK\n----------------------------------------------------\n");
            switch (choice) {
                case 1: // this statement will execute if the user wants to show all books
                    for (Book book : books) { 
                        System.out.println("\nTitle: " + book.getTitle() +"\nAuthor: "+ book.getAuthor() + "\nInternational Standard Book Number (ISBN): " + book.getISBN() + "\nAvailable Copies: " + book.getAvailableCopies());
                    }
                    break;
                case 2: // this statement will execute if the user wants to know a specific book
                    System.out.print("\nEnter the ISBN of the book: ");
                    String bookISBN = scan.nextLine();
                    for (Book book : books) {
                        if (bookISBN.equals(book.getISBN())) { //checks if the user isbn input has the same isbn of a book
                            System.out.println("\nTitle: " + book.getTitle() +"\nAuthor: "+ book.getAuthor() + "\nInternational Standard Book Number (ISBN): " + book.getISBN() + "\nAvailable Copies: " + book.getAvailableCopies());
                            return;
                        }
                    }
                    System.out.println("\nThe book doesn't exist. Plesase try again");
                     break;
                default: System.out.println("\nThere was an error. Please try again.");
                }   
            
        } 
        else {
            System.out.println("\nThe book doesn't exist. Plesase try again");
            scan.nextLine();
        }   
    }
}
