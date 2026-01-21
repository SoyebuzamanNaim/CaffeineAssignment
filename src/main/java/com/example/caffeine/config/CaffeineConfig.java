package com.example.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfig {
    @Bean
    public Caffeine<Object, Object> caffeineCon(){
        return Caffeine.newBuilder().maximumSize(5)
                .expireAfterWrite(5, TimeUnit.MINUTES);
    }
    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine){
        CaffeineCacheManager cacheManager=new CaffeineCacheManager("students");
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }
}
