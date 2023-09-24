package com.example.moviewebsite.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SIGNATURE = "secret";

    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime())
            .sign(Algorithm.HMAC256(SIGNATURE));
    }

    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SIGNATURE)).build();
        jwt = verifier.verify(token);
        return jwt.getClaims();
    }
}
