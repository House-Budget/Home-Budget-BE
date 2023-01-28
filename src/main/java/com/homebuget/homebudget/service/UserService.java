package com.homebuget.homebudget.service;


import com.homebuget.homebudget.entity.User;
import com.homebuget.homebudget.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        user.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));

        userRepository.save(user);

        return user;
    }
}
