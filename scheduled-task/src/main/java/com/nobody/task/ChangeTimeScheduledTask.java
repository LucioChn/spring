package com.nobody.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/2
 * @Version 1.0.0
 */
@Component
public class ChangeTimeScheduledTask implements SchedulingConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeTimeScheduledTask.class);

    // 时间:秒，分钟，小时，日期，月份，星期，年
    private String expression = "0/5 * * * * *";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        // 定时任务要执行的方法
//        Runnable task = () -> LOGGER.info(">>> configureTasks ...");
//        // 调度实现的时间控制
//        Trigger trigger = triggerContext -> {
//            CronTrigger cronTrigger = new CronTrigger(expression);
//            return cronTrigger.nextExecutionTime(triggerContext);
//        };
//        taskRegistrar.addTriggerTask(task, trigger);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
