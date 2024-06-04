package jp.te4a.spring.boot.my_boot_app13.varidate;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WriterValidator implements ConstraintValidator<Writer, String> {
    String ok;

    @Override
    public void initialize(Writer writer) {
        ok = writer.ok();
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        if (Objects.isNull(input)) {
            return false;
        }
        System.out.println(input.equals(ok));
        return input.equals(ok);
    }
}
