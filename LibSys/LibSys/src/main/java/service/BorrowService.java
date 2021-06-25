package service;

import dao.BookDao;
import dao.BorrowInfoDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowInfoDao borrowInfoDao;

    @Autowired
    private UserDao userDao;

    public int addBorrow(BorrowInfo borrowInfo) {
        return borrowInfoDao.addBorrow(borrowInfo);
    }

    public List<BorrowInfo> searchByBookName(String name) {
        return borrowInfoDao.searchBorrowByBookName(name);
    }

    public List<BorrowInfo> searchBorrowByUserId(int userId) {
        return borrowInfoDao.searchBorrowByUserId(userId);
    }

    public List<BorrowInfo> searchAllBorrow() {
        return borrowInfoDao.searchAllBorrow();
    }

    public int updateBorrow(BorrowInfo borrowInfo) {
        return borrowInfoDao.updateBorrow(borrowInfo);
    }

    public List<SelectBorrowInfoByUserId> borrowInfoByUserId(int userId) {
        return userDao.selectBorrowInfoByUserId(userId);
    }

    public List<InfoForUserManage> searchInforForUserManage() {
        return borrowInfoDao.searchInforForUserManage();
    }

}
