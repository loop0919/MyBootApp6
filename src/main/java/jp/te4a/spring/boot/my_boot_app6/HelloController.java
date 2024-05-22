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

    @GetMapping("books/list")
    public String index(Model model) {
        model.addAttribute("msg", "this is a setting message");
        return "books/list";
    }
    
    @PostMapping("books/list")
    public ModelAndView postMethodName(
        @RequestParam("id") String id,
        @RequestParam("title") String title,
        @RequestParam("writer") String writer,
        @RequestParam("publisher") String publisher,
        @RequestParam("price") String price
    ) {
        var mv = new ModelAndView("books/list");
        var bookBean = new BookBean(
            Integer.valueOf(id), 
            title, 
            writer, 
            publisher, 
            Integer.valueOf(price)
        );

        bookService.save(bookBean);
        
        mv.addObject("books", bookService.findAll());
        return mv;
    }
    
}
