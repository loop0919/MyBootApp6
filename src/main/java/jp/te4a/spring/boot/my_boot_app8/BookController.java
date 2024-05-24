package jp.te4a.spring.boot.my_boot_app8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("books/list")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("books", bookService.findAll());
        return mv;
    }
    
    @PostMapping("books/list")
    public ModelAndView postBookData(
        @RequestParam("id") String id,
        @RequestParam("title") String title,
        @RequestParam("writer") String writer,
        @RequestParam("publisher") String publisher,
        @RequestParam("price") String price,
        ModelAndView mv
    ) {
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
