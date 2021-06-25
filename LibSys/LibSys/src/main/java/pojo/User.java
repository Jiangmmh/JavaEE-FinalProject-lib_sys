package pojo;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String passWord;
    private String identity;

    private List<BorrowInfo> borrowInfos;

    public int getId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getIdentity() {
        return identity;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
