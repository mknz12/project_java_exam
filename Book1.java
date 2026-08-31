package system_library_management;

public class Book1 {

    private String bookId;
    private String title;
    private String author;
    private boolean available;

    public Book1(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {

        String status;

        if (available) {
            status = "Available";
        } else {
            status = "Not Available";
        }

        return "Book ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Status: " + status;
    }
}
