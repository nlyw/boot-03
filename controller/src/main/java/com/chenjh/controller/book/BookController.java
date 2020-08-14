package com.chenjh.controller.book;

import com.chenjh.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("book/hello")
    ModelAndView hello() {
        bookService.select();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        String[] s = {"张三", "血刀老祖", "二狗子", "赵六", "李四"};
        mv.addObject("name", "张三");
        mv.addObject("nameArr", s);
        return mv;
    }

}
