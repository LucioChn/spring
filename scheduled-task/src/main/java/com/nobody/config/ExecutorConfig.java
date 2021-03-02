package com.nobody.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ExecutorConfig {

    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 15;
    public static final int QUEUE_CAPACITY = 100;

    @Bean("myExecutor")
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数大小
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 最大线程数大小
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        // 阻塞队列容量
        executor.setQueueCapacity(QUEUE_CAPACITY);
        // 线程名前缀
        executor.setThreadNamePrefix("myTask-");
        // rejectionPolicy：当queue达到maxSize并且此时maxPoolSize也达到最大值的时候，对于新任务的处理策略
        // CallerRunsPolicy：不在新线程中执行任务，而是交由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
