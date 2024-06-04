package jp.te4a.spring.boot.my_boot_app13.repository;

import java.util.UUID;
import org.springframework.stereotype.Repository;

import jp.te4a.spring.boot.my_boot_app13.bean.BookBean;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookBean, UUID> {}
