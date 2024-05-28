package jp.te4a.spring.boot.my_boot_app9;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
    @Id
    UUID id;

    @Column(nullable=false)
    String title;
    String writer;
    String publisher;
    Integer price;
}
