package jp.te4a.spring.boot.my_boot_app9;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookBean, UUID> {}
