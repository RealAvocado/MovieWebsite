package com.example.moviewebsite.user_data.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.moviewebsite.user_data.dto.LoginFormData;
import com.example.moviewebsite.user_data.entity.User;
import com.example.moviewebsite.user_data.repository.UserRepository;
import com.example.moviewebsite.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String Login(LoginFormData loginFormData) {
        String pwd = DigestUtils.md5DigestAsHex(loginFormData.getPassword().getBytes());
        User user = userRepository.findUserByEmailAndPassword(loginFormData.getEmail(), pwd);

        JSONObject resMap = new JSONObject();

        if (user == null) {
            resMap.put("msg", "The email address or password is incorrect");
            resMap.put("code", 400);
            return JSON.toJSONString(resMap);
        }

        HashMap<String, String> claimMap = new HashMap<>();

        claimMap.put("userID", user.getUserID());
        claimMap.put("userName", user.getUserName());
        claimMap.put("email", user.getEmail());

        String token = JWTUtils.getToken(claimMap);

        //prevent password from exposure
        user.setPassword("");

        resMap.put("code", 200);
        resMap.put("token", token);
        resMap.put("data", user);
        return resMap.toJSONString();
    }
}
