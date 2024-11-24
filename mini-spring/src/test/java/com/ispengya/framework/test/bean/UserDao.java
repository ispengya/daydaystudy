package com.ispengya.framework.test.bean;

import com.ispengya.framework.beans.context.annotation.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "zaizaige，北京");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
