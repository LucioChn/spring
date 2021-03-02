package com.nobody.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.TimeZone;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/2
 * @Version 1.0.0
 */
@Component
public class ScheduledTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(cron = "0 0,43 15 * * ? ", zone = "Asia/Shanghai")
    public void test() {
        TimeZone defaultTimeZone = TimeZone.getDefault();
        LOGGER.info(">>> ScheduledTask test... " + defaultTimeZone.getID());
        String[] availableIDs = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(availableIDs));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "0 0 1 * * ? ")
//    public void test() {
//        String lockKey = RedisKeyUtil.genKey(RedisKeyUtil.SCHEDULED_TASK_LOCK);
//        boolean lockSuccess = redisUtils.getLock(lockKey, "1", 30000);
//        if (!lockSuccess) {
//            LOGGER.warn(">>> Scheduled is running on another server...");
//        }
//        try {
//            // doSomething();
//        } finally {
//            redisUtils.releaseLock(lockKey, "1");
//        }
//    }

}
