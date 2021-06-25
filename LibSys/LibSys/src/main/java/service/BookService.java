package service;

import dao.BookDao;
import dao.BookTypeDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import pojo.BookType;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookTypeDao bookTypeDao;

    public Book searchBook(String name) {
        return bookDao.searchBook(name);
    }

    public List<Book> searchByName(String name) {
        return bookDao.searchBookByName(name);
    }

    public List<Book> searchByType(String type) {
        return bookDao.searchBookByType(type);
    }

    public List<Book> searchByAuthor(String author) {
        return bookDao.searchBookByAuthor(author);
    }

    public int updateBook(Book book){
        return bookDao.updateBook(book);
    }

    public int getBookIdByName(String name) {
        return searchBook(name).getBookId();
    }

    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    public List<Book> searchAllBook() {
        return bookDao.searchAllBook();
    }

    public List<BookType> getAllType() {
        return bookTypeDao.getAllBookTypes();
    }

    public int addBookType(BookType bookType) {
        return bookTypeDao.addBookType(bookType);
    }

    public int updateBookType(BookType bookType) {
        return bookTypeDao.updateBookType(bookType);
    }

    public int updateBookTypeQuantity(BookType bookType) {
        return bookTypeDao.updateBookTypeQuantity(bookType);
    }

    public BookType getBookTypeById(int id) {
        return bookTypeDao.getBookTypeById(id);
    }

    public int deleteBookByName(String bookName) throws Exception {
        return bookDao.deleteBook(bookName);
    }

    public int deleteTypeById(int id) throws Exception{
        return bookTypeDao.deleteBookType(id);
    }
}
