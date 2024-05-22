package jp.te4a.spring.boot.my_boot_app6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "this is a setting message");
        return "index";
    }
    
    @PostMapping("/post")
    public ModelAndView postMethodName(
        @RequestParam("id") String id,
        @RequestParam("title") String title,
        @RequestParam("writer") String writer,
        @RequestParam("publisher") String publisher,
        @RequestParam("price") String price
    ) {
        var mv = new ModelAndView("index");
        var bookBean = new BookBean(
            Integer.valueOf(id), 
            title, 
            writer, 
            publisher, 
            Integer.valueOf(price)
        );

        bookService.save(bookBean);
        var buff = new StringBuffer();
        buff.append("<hr>");
        for (var bean: bookService.findAll()) {
            buff.append("ID: " + bean.getId() + "<br>");
            buff.append("タイトル: " + bean.getTitle() + "<br>");
            buff.append("著者: " + bean.getWriter() + "<br>");
            buff.append("出版社: " + bean.getPublisher() + "<br>");
            buff.append("価格: " + bean.getPrice() + "<br>");
            buff.append("<hr>");
        }

        mv.addObject("msg", buff.toString());
        return mv;
    }
    
}
