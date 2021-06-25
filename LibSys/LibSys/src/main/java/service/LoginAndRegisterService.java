package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.sql.SQLException;

@Service
public class LoginAndRegisterService {
    @Autowired
    private UserDao userDao;

    public User login(String name) {
        return userDao.findUserByName(name);
    }

    public int register(User user) {
        return userDao.addUser(user);
    }

    public int update(User user) {
        return userDao.updateUser(user);
    }

    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    public int getIdByName(String userName) {
        return findUserByName(userName).getId();
    }

    public int deleteUserByName(String userName) throws Exception {
        return userDao.deleteUserByName(userName);
    }
}
