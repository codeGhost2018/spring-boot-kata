package com.tim.kata.controller;


import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jetcache")
public class TestJetCacheController {

    @CreateCache(cacheType = CacheType.LOCAL, name = "TEST_WRITE_BACK_CACHE")
    private Cache<String, String> cache;



    @GetMapping("/put/{key}/{value}")
    public String put(@PathVariable String key, @PathVariable String value) {
        cache.put(key, value);
        return "OK";
    }


}
