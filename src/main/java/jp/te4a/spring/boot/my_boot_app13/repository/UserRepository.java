package jp.te4a.spring.boot.my_boot_app13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.spring.boot.my_boot_app13.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean, String> {}
