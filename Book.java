class Book {
    //these variables are private to avoid manipulation of data and  easy access to the attackers
    private final String title; 
    private final String author;
    private final String isbn;
    private int availableCopies;

    public Book (String title, String author, String isbn, int availableCopies) { // this object is where you store the data of the user has put in the library system file
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }
    public String getTitle () {
        return this.title;
    }
    public String getAuthor () {
        return this.author;
    }
    public String getISBN () {
        return this.isbn;
    }
    public int getAvailableCopies() {
        return this.availableCopies;
    }
    public void borrowedBooks(int newCopies) {
        this.availableCopies = newCopies;
    }
    public void returnedBooks(int oldCopies) {
        this.availableCopies = oldCopies;
    }
}
