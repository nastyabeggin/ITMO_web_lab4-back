package com.nastyabeggin.lab4back.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nastyabeggin.lab4back.beans.UserBean;
import com.nastyabeggin.lab4back.repositories.UserDataRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserBean saveUser(UserBean user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        log.info("Saving User, username: {} password: {} encrypted password: {}", user.getUsername(), user.getPassword(), encryptedPassword);
        user.setPassword(encryptedPassword);
        return userDataRepository.save(user);
    }

    @Override
    public UserBean getUser(String username) {
        log.info("Try to find user, username: {}", username);
        return userDataRepository.findByUsername(username);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userDataRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Try to find user details, username: {}", username);
        UserBean user = userDataRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User \"" + username + "\" not found in database");
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
