package com.nastyabeggin.lab4back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nastyabeggin.lab4back.beans.UserBean;

public interface UserDataRepository extends JpaRepository<UserBean, String> {

    UserBean findByUsername(String username);

}
