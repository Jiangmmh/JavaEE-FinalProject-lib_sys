package pojo;

public class InfoForUserManage {
    private String userName;
    private String borrowQuantity;
    private double fine;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBorrowQuantity() {
        return borrowQuantity;
    }

    public void setBorrowQuantity(String borrowQuantity) {
        this.borrowQuantity = borrowQuantity;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "InfoForUserManage{" +
                "userName='" + userName + '\'' +
                ", borrowQuantity='" + borrowQuantity + '\'' +
//                ", overDueQuantity='" + overDueQuantity + '\'' +
                ", fine=" + fine +
                '}';
    }
}
