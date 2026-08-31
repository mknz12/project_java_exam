package system_library_management;

import java.util.Scanner;

public class Main5 {

    private static Scanner scanner = new Scanner(System.in);

    private static Library4 library = new Library4();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            showMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    bookManagement();
                    break;

                case 2:
                    memberManagement();
                    break;

                case 3:
                    transactionManagement();
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using the library system.");
                    break;

                default:
                    System.out.println("Invalid menu choice. Please try again.");
            }
        }

        scanner.close();
    }

    // MAIN MENU

    private static void showMainMenu() {

        System.out.println("\n========================================");

        System.out.println("       LIBRARY MANAGEMENT SYSTEM");

        System.out.println("========================================");

        System.out.println("1. Book Management");

        System.out.println("2. Member Management");

        System.out.println("3. Book Transaction Management");

        System.out.println("4. Exit");
    }

    // BOOK MANAGEMENT

    private static void bookManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== BOOK MANAGEMENT ==========");

            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. View all books");
            System.out.println("4. Search book by title, author, or book ID");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    removeBook();
                    break;

                case 3:
                    library.viewAllBooks();
                    break;

                case 4:
                    searchBook();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }

    private static void addBook() {

        String id = readString("Enter Book ID: ");

        String title = readString("Enter Book Title: ");

        String author = readString("Enter Author: ");

        Book1 book =new Book1(id, title, author);

        library.addBook(book);
    }

    private static void removeBook() {

        String id = readString("Enter Book ID to remove: ");

        library.removeBook(id);
    }

    private static void searchBook() {

        String keyword = readString("Enter title, author, or book ID: ");

        library.searchBook(keyword);
    }

    // MEMBER MANAGEMENT

    private static void memberManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== MEMBER MANAGEMENT ==========");

            System.out.println("1. Add a new member");
            System.out.println("2. Remove a member");
            System.out.println("3. View all members");
            System.out.println("4. Search member by ID or name");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addMember();
                    break;

                case 2:
                    removeMember();
                    break;

                case 3:
                    library.viewAllMembers();
                    break;

                case 4:
                    searchMember();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }

    private static void addMember() {

        String id = readString("Enter Member ID: ");

        String name = readString("Enter Member Name: ");

        Member2 member =new Member2(id, name);

        library.addMember(member);
    }

    private static void removeMember() {

        String id = readString("Enter Member ID to remove: ");

        library.removeMember(id);
    }

    private static void searchMember() {

        String keyword = readString("Enter Member ID or name: ");

        library.searchMember(keyword);
    }

    // TRANSACTION MANAGEMENT

    private static void transactionManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== BOOK TRANSACTION MANAGEMENT ==========");

            System.out.println("1. Issue a book to a member");

            System.out.println("2. Return a book");

            System.out.println("3. Check whether a book is available");

            System.out.println("4. View issue and return records");

            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    issueBook();
                    break;

                case 2:
                    returnBook();
                    break;

                case 3:
                    checkAvailability();
                    break;

                case 4:
                    library.viewTransactions();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }

    private static void issueBook() {

        String memberId = readString("Enter Member ID: ");

        String bookId = readString("Enter Book ID: ");

        library.issueBook(memberId, bookId);
    }

    private static void returnBook() {

        String memberId = readString("Enter Member ID: ");

        String bookId = readString("Enter Book ID: ");

        library.returnBook(memberId, bookId);
    }

    private static void checkAvailability() {

        String bookId = readString("Enter Book ID: ");

        library.checkAvailability(bookId);
    }

    // INPUT VALIDATION

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}
