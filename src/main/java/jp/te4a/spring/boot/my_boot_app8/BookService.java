package jp.te4a.spring.boot.my_boot_app8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        bookForm.setId(bookRepository.getBookId());
        var bookBean = new BookBean();

        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.create(bookBean);

        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        var bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.update(bookBean);
        return bookForm;
    }

    public void delete(UUID id) {
        bookRepository.delete(id);
    }

    public List<BookForm> findAll() {
        List<BookBean> beanList = bookRepository.findAll();
        List<BookForm> formList = new ArrayList<>();
        
        for (var bookBean: beanList) {
            var bookForm = new BookForm();
            BeanUtils.copyProperties(bookBean, bookForm);
            formList.add(bookForm);
        }

        return formList;
    }

    public BookForm findOne(UUID id) {
        var bookBean = bookRepository.findOne(id);
        var bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        return bookForm;
    }
}
