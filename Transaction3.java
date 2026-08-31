package system_library_management;

public class Transaction3 {

    public enum TransactionType {
        ISSUE,
        RETURN
    }

    private Member2 member;
    private Book1 book;
    private TransactionType type;

    public Transaction3(Member2 member, Book1 book, TransactionType type) {

        this.member = member;
        this.book = book;
        this.type = type;
    }

    public Member2 getMember() {
        return member;
    }

    public Book1 getBook() {
        return book;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {

        return "Member: " + member.getName() + " | Book: " + book.getTitle()+ " | Transaction: " + type;
    }
}
