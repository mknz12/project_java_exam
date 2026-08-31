package system_library_management;

import java.util.ArrayList;

public class Library4 {

    private ArrayList<Book1> books;
    private ArrayList<Member2> members;
    private ArrayList<Transaction3> transactions;

    public Library4() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // BOOK MANAGEMENT

    public void addBook(Book1 book) {

        if (findBook(book.getBookId()) != null) {
            System.out.println("Error: Book ID already exists.");
            return;
        }

        books.add(book);

        System.out.println("Book added successfully.");
    }

    public void removeBook(String bookId) {

        Book1 book = findBook(bookId);

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Error: Cannot remove a book that is currently issued.");
            return;
        }

        books.remove(book);

        System.out.println("Book removed successfully.");
    }

    public void viewAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        System.out.println("\n========== ALL BOOKS ==========");

        for (Book1 book : books) {
            System.out.println(book);
        }
    }

    public Book1 findBook(String bookId) {

        for (Book1 book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }

        return null;
    }

    public void searchBook(String keyword) {

        boolean found = false;

        for (Book1 book : books) {

            if (book.getBookId().equalsIgnoreCase(keyword) || book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found.");
        }
    }

    // MEMBER MANAGEMENT

    public void addMember(Member2 member) {

        if (findMember(member.getMemberId()) != null) {

            System.out.println("Error: Member ID already exists.");

            return;
        }

        members.add(member);

        System.out.println("Member added successfully.");
    }

    public void removeMember(String memberId) {

        Member2 member = findMember(memberId);

        if (member == null) {

            System.out.println("Error: Member not found.");

            return;
        }

        if (!member.getBorrowedBooks().isEmpty()) {

            System.out.println("Error: Cannot remove a member who has borrowed books.");

            return;
        }

        members.remove(member);

        System.out.println("Member removed successfully.");
    }

    public void viewAllMembers() {

        if (members.isEmpty()) {

            System.out.println( "No members found.");

            return;
        }

        System.out.println("\n========== ALL MEMBERS ==========");

        for (Member2 member : members) {
            System.out.println(member);
        }
    }

    public Member2 findMember(String memberId) {

        for (Member2 member : members) {

            if (member.getMemberId().equalsIgnoreCase(memberId)) {

                return member;
            }
        }

        return null;
    }

    public void searchMember(String keyword) {

        boolean found = false;

        for (Member2 member : members) {

            if (member.getMemberId().equalsIgnoreCase(keyword)|| member.getName().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(member);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No member found.");
        }
    }

    // TRANSACTION MANAGEMENT

    public void issueBook(String memberId, String bookId) {

        Member2 member = findMember(memberId);
        Book1 book = findBook(bookId);

        // Validation 1
        if (member == null) {

            System.out.println("Error: Member not found.");

            return;
        }

        // Validation 2
        if (book == null) {

            System.out.println("Error: Book not found.");

            return;
        }

        // Validation 3
        // Prevent issuing an unavailable book
        if (!book.isAvailable()) {

            System.out.println("Error: Book is not available.");

            return;
        }

        // Validation 4
        // Prevent the same member from getting
        // the same book twice
        if (member.hasBook(book)) {

            System.out.println("Error: Member already has this book.");

            return;
        }

        // Issue the book
        member.borrowBook(book);

        book.setAvailable(false);

        // Record the transaction
        Transaction3 transaction =new Transaction3(member, book, Transaction3.TransactionType.ISSUE);

        transactions.add(transaction);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(String memberId, String bookId) {

        Member2 member = findMember(memberId);
        Book1 book = findBook(bookId);

        if (member == null) {

            System.out.println("Error: Member not found.");

            return;
        }

        if (book == null) {

            System.out.println("Error: Book not found.");

            return;
        }

        // Check whether this member has the book
        if (!member.hasBook(book)) {

            System.out.println("Error: This member does not have this book.");

            return;
        }

        // Return the book
        member.returnBook(book);

        book.setAvailable(true);

        // Record the transaction
        Transaction3 transaction = new Transaction3(member, book, Transaction3.TransactionType.RETURN);

        transactions.add(transaction);

        System.out.println("Book returned successfully.");
    }

    public void checkAvailability(String bookId) {

        Book1 book = findBook(bookId);

        if (book == null) {

            System.out.println("Error: Book not found.");

            return;
        }

        if (book.isAvailable()) {

            System.out.println("The book is available.");

        } else {

            System.out.println("The book is not available.");
        }
    }

    // ISSUE AND RETURN RECORDS

    public void viewTransactions() {

        if (transactions.isEmpty()) {

            System.out.println("No transaction records found.");

            return;
        }

        System.out.println("\n========== ISSUE AND RETURN RECORDS ==========");

        for (Transaction3 transaction : transactions) {

            System.out.println(transaction);
        }
    }
}
