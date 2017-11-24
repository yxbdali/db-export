package com.autonavi.test.poi.dbexport.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiangbin.yang
 * @since 2017/11/24
 */
@Configuration
public class TheadConfig {
    @Bean
    public ExecutorService singleThreadPool() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new BasicThreadFactory.Builder().namingPattern("single-thread").build());
    }
}
