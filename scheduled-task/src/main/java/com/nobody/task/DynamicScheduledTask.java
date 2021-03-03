package com.nobody.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/2
 * @Version 1.0.0
 */
@Component
public class DynamicScheduledTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicScheduledTask.class);

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public DynamicScheduledTask(final ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
    }

    private ScheduledFuture future;

    /**
     * 启动定时器
     */
    public void startTask() {
        // 第一个参数为定时任务要执行的方法，第二个参数为定时任务执行的时间
        future = threadPoolTaskScheduler.schedule(this::test, new CronTrigger("0/5 * * * * *"));
    }

    /**
     * 停止定时器
     */
    public void endTask() {
        if (future != null) {
            future.cancel(true);
        }
    }

    /**
     * 改变调度的时间，先停止定时器再启动新的定时器
     */
    public void changeTask() {
        // 停止定时器
        endTask();
        // 定义新的执行时间,并启动
        future = threadPoolTaskScheduler.schedule(this::test, new CronTrigger("0/10 * * * * *"));
    }

    /**
     * 定时任务执行的方法
     */
    public void test() {
        LOGGER.info(">>> DynamicScheduledTask ...");
    }
}
