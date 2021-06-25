package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pojo.Book;
import pojo.BorrowInfo;
import pojo.SelectBorrowInfoByUserId;
import pojo.User;
import service.BookService;
import service.BorrowService;
import service.LoginAndRegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private LoginAndRegisterService userService;

    // 用于数据查询
    @RequestMapping("/bk_search")
    public ModelAndView book_search(@RequestParam("type") String type,
                                    @RequestParam("content") String content,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return new ModelAndView("login");
        }

        ModelAndView mav;
        if (session.getAttribute("userName").equals("admin")) {
            mav = new ModelAndView("admin_search_result");
        } else {
            mav = new ModelAndView("user_search_result");
        }

        session.setAttribute("type", type);
        session.setAttribute("content", content);

        if (type.equals("byName")) {
//            System.out.println("Search Book By Name");
//            System.out.println("book Name: " + content);
//            if (content == "\n" )
//                System.out.println("content is n");
//            if (content == "")
//                System.out.println("content is empty");
            List<Book> books = bookService.searchByName(content);
            mav.addObject("books", books);
        }
        else if (type.equals("byAuthor")) {
            List<Book> books = bookService.searchByAuthor(content);
            mav.addObject("books", books);
        }
        else if (type.equals("byType")) {
            List<Book> books = bookService.searchByType(content);
            mav.addObject("books", books);
        }

        return mav;
    }

    // 用于书籍借阅
    @RequestMapping("/borrow")
    public ModelAndView borrow(@RequestParam("bookName") String bookName,
                               HttpServletRequest request) {
        HttpSession session = request.getSession();
        Book book = bookService.searchBook(bookName);
        ModelAndView modelAndView;

        if (book == null || book.getRemQuantity() < 1) {    // 没有该书籍或在馆数位0
            modelAndView = new ModelAndView("error_page");
            modelAndView.addObject("errorInfo", "该书籍无法借阅。");
        } else {        // 否则借阅成功
            Calendar calendar = Calendar.getInstance();     // 生成借阅日期和归还日期
            Timestamp borrowDate = new Timestamp(calendar.getTime().getTime());
            calendar.add(Calendar.DATE, 30);
            Timestamp returnDate = new Timestamp(calendar.getTime().getTime());

            BorrowInfo borrowInfo = new BorrowInfo();
            borrowInfo.setUserId(userService.getIdByName(session.getAttribute("userName").toString()));
            borrowInfo.setBookId(bookService.getBookIdByName(bookName));
            borrowInfo.setBorrowDate(borrowDate);
            borrowInfo.setReturnDate(returnDate);

            book.setRemQuantity(book.getRemQuantity() - 1); // 更新书籍信息
            bookService.updateBook(book);

            borrowService.addBorrow(borrowInfo);    // 添加借阅记录

            String path = "redirect:/bk_search";
            modelAndView = new ModelAndView(path).
                    addObject("content", session.getAttribute("content")).
                    addObject("type", session.getAttribute("type"));
        }
        return modelAndView;
    }

    @RequestMapping("/user_page")
    public ModelAndView toUserPage() {
        return new ModelAndView("user_page");
    }

    @RequestMapping("/borrow_info")
    public ModelAndView toBorrowPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = session.getAttribute("userName").toString();
        int userId = userService.getIdByName(userName);

        List<SelectBorrowInfoByUserId> borrowInfos = borrowService.borrowInfoByUserId(userId);

        return new ModelAndView("user_borrow_info").addObject("borrowInfos", borrowInfos);
    }

    @RequestMapping("/personal_info")
    public ModelAndView toPersonalPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.findUserByName(session.getAttribute("userName").toString());

        return new ModelAndView("user_personal_info")
                .addObject("userName", user.getUserName())
                .addObject("passWord", user.getPassWord());
    }
}
