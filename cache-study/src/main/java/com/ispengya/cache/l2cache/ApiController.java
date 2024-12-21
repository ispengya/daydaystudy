package com.ispengya.cache.l2cache;

import com.ispengya.C.L2Cache;
import com.ispengya.C.StringRedisCache;
import com.ispengya.C.function.CacheLoader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-19 09:41
 **/
@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    public static  Map<String, Object> map = new HashMap<>();

    static{
        map.put("load1", new User("load1"));
        map.put("load2", new User("load2"));
        map.put("load3", new User("load3"));
        map.put("load4", new User("load4"));
        map.put("load5", new User("load5"));
        map.put("load6", new User("load6"));
    }

    @Autowired
    StringRedisCache stringRedisCache;

    @Autowired
    L2Cache l2Cache;

    @GetMapping("/get")
    public String get(){
        stringRedisCache.put("get",new User("ispengya"));
        stringRedisCache.put("string","hello");
        return stringRedisCache.get("string",String.class);
    }

    @GetMapping("/safeGet")
    public User safeGet(){
        stringRedisCache.safeGet("safeGet", User.class, new CacheLoader<User>() {
            @Override
            public User load() {
                return new User("load");
            }
        },100000);
        return stringRedisCache.get("safeGet", User.class);
    }

    @GetMapping("/batch")
    public Map<String, User> batchGet(){
        stringRedisCache.batchPut(map, 100000);
        Set<String> keySet = new HashSet<>(map.keySet());
        keySet.add("load7");
        keySet.add("load8");
        return stringRedisCache.batchGet(keySet,User.class);
    }

    @GetMapping("/l2")
    public User l2(){
        log.info("hhhh");
        l2Cache.get("hanzhipeng", User.class, new CacheLoader<User>() {
            @Override
            public User load() {
                log.info("load db");
                return new User("hanzhipeng");
            }
        });
        return l2Cache.get("hanzhipeng", User.class, null);
    }

    @GetMapping("/l3")
    public User l3(){
        return l2Cache.get("hanzhipeng", User.class, null);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        private String name;
    }
}
