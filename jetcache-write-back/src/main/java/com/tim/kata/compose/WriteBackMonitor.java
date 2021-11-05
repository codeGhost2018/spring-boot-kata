package com.tim.kata.compose;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheMonitor;
import com.alicp.jetcache.anno.support.ConfigProvider;
import com.alicp.jetcache.event.CacheEvent;
import com.alicp.jetcache.event.CachePutEvent;
import com.alicp.jetcache.support.JetCacheExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class WriteBackMonitor implements CacheMonitor {

    @Autowired
    private ConfigProvider configProvider;



    private static volatile Queue<String> activeKeys = new ArrayBlockingQueue<>(8);


    @PostConstruct
    public synchronized void start() {
        Writeback writeback = new Writeback(this.activeKeys);
        JetCacheExecutor.defaultExecutor().scheduleAtFixedRate(writeback, 10L, 10L, TimeUnit.SECONDS);
    }


    class Writeback implements Runnable {

        private volatile Queue<String> activeKeyss;

        public Writeback(Queue<String> activeKeys) {
            this.activeKeyss = activeKeys;
        }

        @Override
        public void run() {
            try {
                Cache<String, String> cache = configProvider.getCacheManager().getCache("TEST_WRITE_BACK_CACHE");
                while (true) {
                    String key = activeKeyss.poll();
                    if (key == null) break;
                    System.out.println(String.format("Write Cache key: %s, value: %s", key, cache.get(key)));

                }
            }catch (Exception exception) {

            }
        }
    }



    @Override
    public synchronized void afterOperation(CacheEvent event) {
        if (event instanceof CachePutEvent) {
            CachePutEvent e = (CachePutEvent) event;
            afterPut((String)e.getKey());
        }
    }


    private void afterPut(String key) {
        if(!activeKeys.contains(key)) {
            activeKeys.add(key);
        }
    }

}
