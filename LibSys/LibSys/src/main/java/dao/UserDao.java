package dao;

import pojo.BorrowInfo;
import pojo.SelectBorrowInfoByUserId;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User findUserByName(String name);
    int addUser(User user);
    int updateUser(User user);
    List<SelectBorrowInfoByUserId> selectBorrowInfoByUserId(int userId);
    int deleteUserByName(String userName) throws Exception;
}
