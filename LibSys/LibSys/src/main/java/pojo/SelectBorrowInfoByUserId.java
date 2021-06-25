package pojo;

import java.sql.Timestamp;

public class SelectBorrowInfoByUserId {
    private String bookName;
    private String author;
    private String type;
    private Timestamp borrowDate;
    private Timestamp returnDate;
    private String isOverDue;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public String getIsOverDue() {
        return isOverDue;
    }

    public void setIsOverDue(String isOverDue) {
        this.isOverDue = isOverDue;
    }

    @Override
    public String toString() {
        return "SelectBorrowInfoByUserId{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", isOverDue='" + isOverDue + '\'' +
                '}';
    }
}
