package com.example.demo;

import org.json.JSONObject;

public class JSONResult {
    public static String getREesult(Integer status, String message, Object result) {
        JSONObject jsonObject = new JSONObject() {{
            put("status", status);
            put("msg", message);
            put("result", result);
        }};

        return jsonObject.toString();
    }
}