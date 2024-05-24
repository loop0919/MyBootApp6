package jp.te4a.spring.boot.my_boot_app8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final ConcurrentMap<UUID, BookBean> bookMap = new ConcurrentHashMap<>();

    public UUID getBookId() {
        return UUID.randomUUID();
    }

    public BookBean create(BookBean bookBean) {
        return bookMap.put(bookBean.getId(), bookBean);
    }

    public BookBean update(BookBean updateBookBean) {
        var bookBean = bookMap.get(updateBookBean.getId());
        BeanUtils.copyProperties(updateBookBean, bookBean);
        return bookBean;
    }

    public void delete(UUID bookId) {
        bookMap.remove(bookId);
    }

    public List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public BookBean findOne(UUID id) {
        return bookMap.get(id);
    }
}
