package jp.te4a.spring.boot.my_boot_app11;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {
    private UUID id;
    
    @NotNull
    @Size(min=3)
    private String title;
    
    @Size(min=3, max=20)
    private String writer;

    private String publisher;

    @Min(0)
    private Integer price;
}
