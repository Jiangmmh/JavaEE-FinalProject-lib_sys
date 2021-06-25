package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import pojo.BookType;
import pojo.InfoForUserManage;
import pojo.User;
import service.BookService;
import service.BorrowService;
import service.LoginAndRegisterService;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private LoginAndRegisterService userService;

    @RequestMapping("/add_book")
    public ModelAndView addBook(@RequestParam("bookName") String bookName,
                                @RequestParam("author") String author,
                                @RequestParam("quantity") int quantity,
                                @RequestParam("type") String type,
                                HttpServletRequest request) {
        // Sql语句中不能单独的&
        if (author.indexOf('&') != -1) {
            author.replaceFirst("&", "&amp;");
        }

        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setTotalQuantity(quantity);
        book.setRemQuantity(quantity);
        book.setType(type);

        BookType bookType = new BookType();
        bookType.setType(type);
        bookType.setQuantity(bookType.getQuantity() + quantity);
//        System.out.println(bookType.toString());

        ModelAndView mav;

        int r1 = bookService.addBook(book);
        int r2 = bookService.updateBookTypeQuantity(bookType);

        if (r1 < 1 || r2 < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "加入书籍失败！！");
        } else {
            mav = new ModelAndView("redirect:/book_manage");
        }

        return mav;
    }

    @RequestMapping("/add_type")
    public ModelAndView addType(@RequestParam("type") String type) {
        BookType bookType = new BookType();
        bookType.setType(type);
        bookType.setQuantity(0);
        int result = bookService.addBookType(bookType);
        ModelAndView mav;
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "添加图书类型失败！！");
        } else {
            mav = new ModelAndView("redirect:/type_manage");
        }

        return mav;
    }


    @RequestMapping("/book_manage")
    public ModelAndView toBookManage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return new ModelAndView("login");
        }

        ModelAndView mav = new ModelAndView("admin_page");
        List<Book> books = bookService.searchAllBook();
        mav.addObject("books", books);
        return mav;
    }

    @RequestMapping("/type_manage")
    public ModelAndView toTypeManage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("admin_type");
        List<BookType> bookTypes = bookService.getAllType();
        mav.addObject("types", bookTypes);

        return mav;
    }

    @RequestMapping("/user_manage")
    public ModelAndView toUserManage() {
        List<InfoForUserManage> userInfos = borrowService.searchInforForUserManage();
        return new ModelAndView("admin_user_manage").addObject("userInfos", userInfos);
    }


    @RequestMapping("/update_book")
    public ModelAndView updateBook(@RequestParam("bookId") int bookId,
                                   @RequestParam("bookName") String bookName,
                                   @RequestParam("author") String author,
                                   @RequestParam("totalQuantity") int totalQuantity,
                                   @RequestParam("remQuantity") int remQuantity,
                                   @RequestParam("type") String type) {
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setTotalQuantity(totalQuantity);
        book.setRemQuantity(remQuantity);
        book.setType(type);
//        System.out.println(book.toString());
        int result = bookService.updateBook(book);

        ModelAndView mav;
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "更新书籍信息失败！！");
        } else {
            mav = new ModelAndView("redirect:/book_manage");
        }

        return mav;
    }

    @RequestMapping("/update_type")
    public ModelAndView updateType(@RequestParam("typeId") int id,
                                   @RequestParam("type") String type) {
        BookType bookType = new BookType();
        bookType.setId(id);
        bookType.setType(type);
        int result = bookService.updateBookType(bookType);

        ModelAndView mav;
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "更新图书类型失败！！");
        } else {
            mav = new ModelAndView("redirect:/type_manage");
        }

        return mav;
    }

    @RequestMapping("/reset_user_password")
    public ModelAndView alterUser(@RequestParam("userName") String userName) {
        User user = userService.findUserByName(userName);
        user.setPassWord("hnist123");

        ModelAndView mav;
        int result = userService.update(user);
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "密码重置失败！！");
        } else {
            mav = new ModelAndView("redirect:/user_manage");
        }

        return mav;
    }

    @RequestMapping("delete_user")
    public ModelAndView deleteUser(@RequestParam("userName") String userName) throws Exception {
        ModelAndView mav;
        int result = userService.deleteUserByName(userName);
        mav = new ModelAndView("redirect:/user_manage");

        return mav;
    }

    @RequestMapping("/alter_book")
    public ModelAndView alterBook(@RequestParam("bookName") String bookName) {
        Book book = bookService.searchBook(bookName);
        List<BookType> bookTypes = bookService.getAllType();
        ModelAndView mav = new ModelAndView("admin_alter_book");
        mav.addObject("book", book).addObject("types", bookTypes);
        return mav;
    }


    @RequestMapping("/to_add_type")
    public ModelAndView toAddTypePage() {
        return new ModelAndView("admin_add_type");
    }

    @RequestMapping("/to_alter_type")
    public ModelAndView toAlterType(@RequestParam("typeId") int typeId) {
        BookType bookType = bookService.getBookTypeById(typeId);
//        System.out.println(bookType.toString());
        return new ModelAndView("admin_alter_type").addObject("bookType", bookType);
    }

//    @RequestMapping("/to_alter_user")
//    public ModelAndView toAlterUser(){
//        return new ModelAndView("admin_alter_user");
//    }

    @RequestMapping("/add_page")
    public ModelAndView toAddBook() {
        ModelAndView mav = new ModelAndView("admin_add_book");
        List<BookType> bookTypes = bookService.getAllType();
        mav.addObject("types", bookTypes);
        return mav;
    }

    @RequestMapping("/delete_book")
    public ModelAndView deleteBook(@RequestParam("bookName") String bookName) throws Exception{
        int res = bookService.deleteBookByName(bookName);
        ModelAndView mav;
        if (res < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("error_info", "删除用户失败");
        } else {
            mav = new ModelAndView("admin_page");
        }
        return mav;
    }

    @RequestMapping("/delete_type")
    public ModelAndView deleteType(@RequestParam("typeId") int id) throws Exception {
        int res = bookService.deleteTypeById(id);
        ModelAndView mav;
        if (res < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("error_info", "删除图书类型失败");
        } else {
            mav = new ModelAndView("admin_type");
        }
        return mav;
    }

}
