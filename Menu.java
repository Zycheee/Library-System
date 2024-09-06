import java.util.*;
public class Menu {
    public static void main(String[] args) {
        LibrarySystem bookDetails = new LibrarySystem();
        Scanner scan = new Scanner(System.in);
        int options;
        boolean condition = true;
        do {
            System.out.println("\n\t\tWELCOME TO THE LIBRARY\n------------------------------------------------------");
            System.out.print("\t\t[1] CREATE A BOOK\n\t\t[2] BORROW A BOOK\n\t\t[3] RETURN A BOOK\n\t\t[4] DETAILS OF THE BOOK\n\t\t[5] EXIT\nINPUT: ");
            if (scan.hasNextInt()) {
                options = scan.nextInt();
                if (options < 6) {
                    switch (options) {
                        case 1: 
                            bookDetails.createBook(); 
                            break;
                        case 2:
                            bookDetails.borrowBook();
                            break;
                        case 3:
                            bookDetails.returnBook();
                            break;
                        case 4:
                            System.out.println("\nDETAILS OF THE BOOK\n----------------------\n");
                            bookDetails.infoDisplay();
                            break;
                        case 5:
                            System.out.println("\nShutting Down...\n");
                            condition = false;
                            break;
                        default: System.out.println("\nThere was an error, Please try again.\n");
                    }
                }
                else 
                    System.out.println("\nThere was an error. Please try again.\n");
            }
            else {
                System.out.println("\nThere was an error. Please try again.\n");
                scan.nextLine();
            }
        } while(condition == true); 
    }
}
