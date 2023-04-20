package com.example.moviewebsite.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.example.moviewebsite.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        JSONObject resMap = new JSONObject();
        if (null == token) {
            resMap.put("msg","Unauthorized user");
            resMap.put("code", 400);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(resMap.toJSONString());
            return false;
        }
        Map<String, Claim> claimMap = JWTUtils.verifyToken(token);
        String userID = claimMap.get("userID").asString();

        request.setAttribute("userID",userID);
        return true;
    }
}
