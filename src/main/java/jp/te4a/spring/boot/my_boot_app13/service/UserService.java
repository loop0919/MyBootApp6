package jp.te4a.spring.boot.my_boot_app13.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.my_boot_app13.bean.UserBean;
import jp.te4a.spring.boot.my_boot_app13.form.UserForm;
import jp.te4a.spring.boot.my_boot_app13.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        var passwordEncoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        var encodedPassword = passwordEncoder.encode(userForm.getPassword());
        userForm.setPassword(encodedPassword);

        var userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}
