package jp.te4a.spring.boot.my_boot_app8;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
    UUID id;
    String title;
    String writer;
    String publisher;
    Integer price;
}
