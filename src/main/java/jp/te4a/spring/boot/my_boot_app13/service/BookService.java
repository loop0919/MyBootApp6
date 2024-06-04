package jp.te4a.spring.boot.my_boot_app13.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.my_boot_app13.bean.BookBean;
import jp.te4a.spring.boot.my_boot_app13.form.BookForm;
import jp.te4a.spring.boot.my_boot_app13.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookForm create(BookForm bookForm) {
        var bookBean = new BookBean();

        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);

        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        var bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }

    public List<BookForm> findAll() {
        var formList = bookRepository.findAll()
                .stream()
                .map(bean -> {
                    var form = new BookForm();
                    BeanUtils.copyProperties(bean, form);
                    return form;
                })
                .collect(Collectors.toList());

        return formList;
    }

    public BookForm findOne(UUID id) {
        var bookBean = bookRepository.findById(id).orElse(new BookBean());
        var bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        return bookForm;
    }
}
