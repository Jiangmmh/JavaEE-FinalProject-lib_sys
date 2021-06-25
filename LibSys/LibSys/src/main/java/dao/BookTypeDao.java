package dao;

import pojo.BookType;

import java.sql.SQLException;
import java.util.List;

public interface BookTypeDao {
    List<BookType> getAllBookTypes();
    int getTypeCount();
    int updateBookType(BookType bookType);
    int updateBookTypeQuantity(BookType bookType);
    int addBookType(BookType type);
    BookType getBookTypeById(int id);
    int deleteBookType(int id) throws Exception;
}
