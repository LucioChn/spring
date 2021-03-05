package com.nobody.read;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @Description 回调监听器
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
public class OnMapDataListener extends AnalysisEventListener<Map<Integer, String>> {

    // 日志记录器
    private static final Logger LOGGER = LoggerFactory.getLogger(OnMapDataListener.class);

    private UserService userService;

    public OnMapDataListener() {

    }

    // 因为UserDataListener不能被spring管理，每次读取excel都要new,如果用到Spring管理的bean可以通过构造方法传进来
    public OnMapDataListener(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Excel每一条数据解析都会来调用此方法
     * 
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        LOGGER.info(">>> 读取到一行数据：{}", data);
        // userService.doSomething();
    }

    /**
     * 所有数据解析完成了会调用此方法
     * 
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        LOGGER.info(">>> 读取完一页Sheet数据...");
        // userService.doSomething();
    }
}
