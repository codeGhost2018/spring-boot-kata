package com.tim.kata.compose;

import com.alicp.jetcache.CacheBuilder;
import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.embedded.CaffeineCacheBuilder;
import com.alicp.jetcache.embedded.EmbeddedCacheBuilder;
import com.alicp.jetcache.support.FastjsonKeyConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JetcacheConfig {


    @Bean
    public SpringConfigProvider springConfigProvider() {
        return new SpringConfigProvider();
    }

    @Bean
    public GlobalCacheConfig config(SpringConfigProvider configProvider) {
        Map<String, CacheBuilder> localBuilders = new HashMap<>();
        EmbeddedCacheBuilder localBuilder = CaffeineCacheBuilder.createCaffeineCacheBuilder()
                .keyConvertor(FastjsonKeyConvertor.INSTANCE)
                .addMonitor(new WriteBackMonitor());

        localBuilders.put(CacheConsts.DEFAULT_AREA, localBuilder);


        GlobalCacheConfig globalCacheConfig = new GlobalCacheConfig();
        globalCacheConfig.setLocalCacheBuilders(localBuilders);
        globalCacheConfig.setStatIntervalMinutes(1);
        globalCacheConfig.setAreaInCacheName(false);

        return globalCacheConfig;
    }



}

