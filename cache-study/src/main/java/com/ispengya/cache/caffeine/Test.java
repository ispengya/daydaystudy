package com.ispengya.cache.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * @author: hanzhipeng
 * @create: 2024-12-20 10:10
 **/
public class Test {
    private static int NUM = 0;

    public static void main(String[] args) throws InterruptedException {
//        refreshAfterWrite();
        expireAfterWrite();
    }

    private static void expireAfterWrite() throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean();
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                //模拟获取数据，每次获取就自增1
                .build(integer -> {
                    if (flag.get()) {
                        Thread.sleep(5000);
                    }
                    flag.compareAndSet(false, true);
                    return ++NUM;
                });

        //获取ID=1的值，由于缓存里还没有，所以会自动放入缓存
        System.out.println(cache.get(1));// 1

        Thread.sleep(1000);

        new Thread(() ->{
            long start = System.currentTimeMillis();
            System.out.println(cache.get(1)); // 2
            System.out.println(System.currentTimeMillis() - start); //阻塞5s
        }).start();

        long s = System.currentTimeMillis();
        System.out.println(cache.get(1)); // 2
        System.out.println(System.currentTimeMillis() - s); //阻塞5s
    }

    private static void refreshAfterWrite() throws InterruptedException {
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                //模拟获取数据，每次获取就自增1
                .build(integer -> ++NUM);

        //获取ID=1的值，由于缓存里还没有，所以会自动放入缓存
        System.out.println(cache.get(1));// 1

        // 延迟2秒后，理论上自动刷新缓存后取到的值是2
        // 但其实不是，值还是1，因为refreshAfterWrite并不是设置了n秒后重新获取就会自动刷新
        Thread.sleep(2000);

        new Thread(() ->{
            System.out.println(cache.get(1)); //1
        }).start();

        //此时才会刷新缓存，而第一次拿到的还是旧值
        System.out.println(cache.get(1)); //1

        Thread.sleep(1000);
        System.out.println(cache.get(1)); //2
    }
}
