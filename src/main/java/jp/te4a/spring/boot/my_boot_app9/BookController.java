package jp.te4a.spring.boot.my_boot_app9;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path="books")
public class BookController {
    @Autowired
    BookService bookService;

    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }

    @GetMapping
    String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }
    
    @PostMapping(path="create")
    String create(BookForm form, Model model) {
        bookService.create(form);
        return "redirect:/books";
    }

    @PostMapping(path="edit", params="form")
    String editForm(@RequestParam UUID id, @ModelAttribute("bookForm") BookForm form) {
        var bookForm = bookService.findOne(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }
    
    @PostMapping(path="edit")
    String edit(@RequestParam UUID id, BookForm form) {
        bookService.update(form);
        return "redirect:/books";
    }

    @PostMapping(path="delete")
    String delete(@RequestParam UUID id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping(path="edit", params="goToTop")
    String goToTop() {
        return "redirect:/books";
    }
}
