package pojo;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionClass implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object o,
                                         Exception e) {
        e.printStackTrace();
        System.out.println(e);
        ModelAndView mav = new ModelAndView("error_page")
                .addObject("error_info", "用户删除失败！");

        return mav;
    }
}
