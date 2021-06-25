package pojo;

import java.sql.Timestamp;

public class BorrowInfo {
    private int borrowId;
    private int userId;
    private int bookId;
    private Timestamp borrowDate;
    private Timestamp returnDate;
    private String isOverDue;
    private double overDueFine;

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public double getOverDueFine() {
        return overDueFine;
    }

    public void setOverDueFine(double overDueFine) {
        this.overDueFine = overDueFine;
    }

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "borrowId=" + borrowId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", isOverDue='" + isOverDue + '\'' +
                ", overDueFine=" + overDueFine +
                '}';
    }
}

