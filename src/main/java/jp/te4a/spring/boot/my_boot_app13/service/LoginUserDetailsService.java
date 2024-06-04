package jp.te4a.spring.boot.my_boot_app13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.my_boot_app13.bean.UserBean;
import jp.te4a.spring.boot.my_boot_app13.repository.UserRepository;
import jp.te4a.spring.boot.my_boot_app13.security.LoginUserDetails;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean user = userRepository.findById(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException("The requested user is not found.")
                );
        return new LoginUserDetails(user);
    }
}
