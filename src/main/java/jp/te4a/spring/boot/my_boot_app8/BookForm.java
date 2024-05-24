package jp.te4a.spring.boot.my_boot_app8;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {
    private UUID id;
    private String title;
    private String writer;
    private String publisher;
    private Integer price;
}
