package com.java_with_jpa.java_with_jpa.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandle {
    public static ResponseEntity<Object> generate(
            String message,
            HttpStatus statusCode
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);

        return new ResponseEntity<Object>(map, statusCode);
    }
}
