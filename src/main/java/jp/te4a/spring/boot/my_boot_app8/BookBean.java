package jp.te4a.spring.boot.my_boot_app8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookBean {
    Integer id;
    String title;
    String writer;
    String publisher;
    Integer price;
}
