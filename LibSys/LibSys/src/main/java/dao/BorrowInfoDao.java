package dao;

import pojo.BorrowInfo;
import pojo.InfoForUserManage;

import java.util.List;

public interface BorrowInfoDao {
    int addBorrow(BorrowInfo borrowInfo);
    int updateBorrow(BorrowInfo borrowInfo);
    List<BorrowInfo> searchBorrowByUserId(int userId);
    List<BorrowInfo> searchBorrowByBookName(String bookName);
    List<BorrowInfo> searchAllBorrow();
    List<InfoForUserManage> searchInforForUserManage();
//    int deleteInfo();
}