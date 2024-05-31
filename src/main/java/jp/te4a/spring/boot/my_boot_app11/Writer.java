package jp.te4a.spring.boot.my_boot_app11;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = WriterValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Writer {
    String ok();
    String message() default "input {ok}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
