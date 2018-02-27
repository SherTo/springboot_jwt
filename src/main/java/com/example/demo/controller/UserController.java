package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    /**
     * 注册用户 默认开启白名单
     *
     * @param user
     */
    @PostMapping("/signup")
    public User signup(@RequestBody User user) throws UsernameIsExitedException {
        User bizUser = userRepository.findByUsername(user.getUsername());
        if (null != bizUser) {
            throw new UsernameIsExitedException("用户已经存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        return userRepository.save(user);
    }

    @PostMapping("/list")
    public List<User> toList(){
        List<User> all = userRepository.findAll();
        return all;
    }
}