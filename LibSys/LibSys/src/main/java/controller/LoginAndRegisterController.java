package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.LoginAndRegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Controller
public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService userService;

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            return new ModelAndView("user_page");
        }
        return new ModelAndView("login");
    }

    @RequestMapping("/login_p")
    public ModelAndView login_p(@RequestParam("username") String userName,
                                @RequestParam("password") String passWord,
                                HttpServletRequest request) {
        User user = userService.login(userName);
        ModelAndView modelAndView;

        // 获取session，true表示如果没有session则新建一个
        HttpSession session = request.getSession(true);

        if (user != null &&
                userName.equals(user.getUserName())
                && passWord.equals(user.getPassWord())) {

            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", userName);
            session.setAttribute("identity", user.getIdentity());

            if (user.getIdentity().equals("admin")) {
                modelAndView = new ModelAndView("redirect:/book_manage");
            } else {
                modelAndView = new ModelAndView("user_page");
            }
        } else {
            modelAndView = new ModelAndView("error_page");
            modelAndView.addObject("errorInfo",
                    "登录失败，请确保用户名和密码输入正确。");
        }
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping("/register_p")
    public ModelAndView register_p(@RequestParam("username") String userName,
                                   @RequestParam("password") String passWord,
                                   @RequestParam("picture")  MultipartFile picture) {

        System.out.println("进入注册程序");
        String file = picture.getOriginalFilename();
        int index = file.indexOf(".");
        String fileName = userName + file.substring(index);

        try {
            File dir = new File("F:\\Projects\\JavaEE 2021-spring\\LibSys\\LibSys\\LibSys\\src\\main\\webapp\\image\\");

            FileOutputStream os = new FileOutputStream(dir.getPath() + "\\" + fileName);
            InputStream in = picture.getInputStream();
            int b = 0;
            while ((b = in.read()) != -1) {
                os.write(b);
            }
            os.flush();
            in.close();
            os.close();
        } catch (Exception e){
            return null;
        }

        System.out.println("图片处理完成");
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        int result = userService.register(user);

        ModelAndView mav;
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "注册失败，请重新尝试。");
        } else {
            mav = new ModelAndView("login");
        }

        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null)
            session.invalidate();
        return new ModelAndView("login");
    }

    @RequestMapping("/modify_password")
    public ModelAndView modifyPassword(@RequestParam("username") String userName,
                                       @RequestParam("psw") String passWord) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        int result = userService.update(user);

        ModelAndView mav;
        if (result < 1) {
            mav = new ModelAndView("error_page");
            mav.addObject("errorInfo", "修改密码失败，请重新尝试。");
        } else {
            mav = new ModelAndView("user_personal_info");
        }

        return mav;
    }
}
