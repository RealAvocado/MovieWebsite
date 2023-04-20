package com.example.moviewebsite.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        JSONObject resMap = new JSONObject();
        resMap.put("code",400);
        resMap.put("msg",e.getMessage());
        return resMap.toJSONString();
    }
}