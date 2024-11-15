package com.ispengya.framework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "在在哥");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}