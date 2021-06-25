package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.sql.SQLException;
import java.util.List;

//@Repository
public interface BookDao {
    Book searchBook(String bkName); // 通过书名得到一本书
    List<Book> searchAllBook();
    List<Book> searchBookByName(String bookName);
    List<Book> searchBookByAuthor(String author);
    List<Book> searchBookByType(String type);
    int getBookIdByName(String bkName);
    int updateBook(Book book);
    int addBook(Book book);
    int deleteBook(String bookName) throws Exception;
}