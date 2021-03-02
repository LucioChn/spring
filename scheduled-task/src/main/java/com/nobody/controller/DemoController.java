package com.nobody.controller;

import com.nobody.task.ChangeTimeScheduledTask;
import com.nobody.task.DynamicScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/2
 * @Version 1.0.0
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    private ChangeTimeScheduledTask changeTimeScheduledTask;
    private DynamicScheduledTask dynamicScheduledTask;

    public DemoController(final ChangeTimeScheduledTask changeTimeScheduledTask,
            final DynamicScheduledTask dynamicScheduledTask) {
        this.changeTimeScheduledTask = changeTimeScheduledTask;
        this.dynamicScheduledTask = dynamicScheduledTask;
    }

    @GetMapping
    public String testChangeTimeScheduledTask() {
        changeTimeScheduledTask.setExpression("0/10 * * * * *");
        return "ok";
    }

    @GetMapping("startDynamicScheduledTask")
    public String startDynamicScheduledTask() {
        dynamicScheduledTask.startTask();
        return "ok";
    }

    @GetMapping("endDynamicScheduledTask")
    public String endDynamicScheduledTask() {
        dynamicScheduledTask.endTask();
        return "ok";
    }

    @GetMapping("changeDynamicScheduledTask")
    public String changeDynamicScheduledTask() {
        dynamicScheduledTask.changeTask();
        return "ok";
    }

}
