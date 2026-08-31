package system_library_management;

import java.util.ArrayList;

public class Member2 {

    private String memberId;
    private String name;
    private ArrayList<Book1> borrowedBooks;

    public Member2(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book1> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book1 book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book1 book) {
        borrowedBooks.remove(book);
    }

    public boolean hasBook(Book1 book) {
        return borrowedBooks.contains(book);
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + " | Name: " + name;
    }
}
