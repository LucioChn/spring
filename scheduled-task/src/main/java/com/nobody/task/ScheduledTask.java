package com.nobody.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
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

    @Scheduled(cron = "${cron.exp}")
    public void test() {
        LOGGER.info(">>> ScheduledTask test... ");
    }

    // @Scheduled(fixedDelay = 1000)
    // public void test() {
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // LOGGER.info(">>> ScheduledTask test... ");
    // }

    // @Scheduled(fixedDelayString = "$1000")
    // public void test() {
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // LOGGER.info(">>> ScheduledTask test... ");
    // }

    // @Scheduled(fixedDelayString = "${fixed.delay}")
    // public void test() {
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // LOGGER.info(">>> ScheduledTask test... ");
    // }

    // @Scheduled(fixedRate = 1000)
    // public void test() {
    // try {
    // Thread.sleep(5000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // LOGGER.info(">>> ScheduledTask test... ");
    // }

    // // 延迟3秒才开始执行第一次任务
    // @Scheduled(fixedDelayString = "1000", initialDelay = 3000)
    // public void test() {
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // LOGGER.info(">>> ScheduledTask test... ");
    // }

    // @Scheduled(cron = "0/5 * * * * ?", zone = "Asia/Shanghai")
    // public void test() {
    // TimeZone defaultTimeZone = TimeZone.getDefault();
    // LOGGER.info(">>> ScheduledTask test... " + defaultTimeZone.getID());
    // // 打印出可取得的所有时区ID
    // String[] availableIDs = TimeZone.getAvailableIDs();
    // System.out.println(Arrays.toString(availableIDs));
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    // @Scheduled(cron = "${cron.exp}")
    // public void test() {
    // String lockKey = RedisKeyUtil.genKey(RedisKeyUtil.SCHEDULED_TASK_LOCK);
    // boolean lockSuccess = redisUtils.getLock(lockKey, "1", 30000);
    // if (!lockSuccess) {
    // LOGGER.warn(">>> Scheduled is running on another server...");
    // }
    // try {
    // // doSomething();
    // } finally {
    // redisUtils.releaseLock(lockKey, "1");
    // }
    // }

}
