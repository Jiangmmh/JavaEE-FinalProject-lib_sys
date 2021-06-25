package pojo;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private int totalQuantity;
    private int remQuantity;
    private String type;

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getRemQuantity() {
        return remQuantity;
    }

    public String getType() {
        return type;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setRemQuantity(int remQuantity) {
        this.remQuantity = remQuantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", remQuantity=" + remQuantity +
                ", type='" + type + '\'' +
                '}';
    }
}
