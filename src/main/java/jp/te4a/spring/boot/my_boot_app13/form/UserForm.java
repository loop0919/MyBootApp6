package jp.te4a.spring.boot.my_boot_app13.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserForm {
    @NotNull
    @Size(min=6, max=12)
    private String username;

    @Size(min=8, max=256)
    private String password;
}
