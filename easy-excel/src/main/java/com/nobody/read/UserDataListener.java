package com.nobody.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 回调监听器
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
public class UserDataListener extends AnalysisEventListener<UserData> {

    // 日志记录器
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataListener.class);

    private UserService userService;

    public UserDataListener() {

    }

    // 因为UserDataListener不能被spring管理，每次读取excel都要new,如果用到Spring管理的bean可以通过构造方法传进来
    public UserDataListener(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Excel每一条数据解析都会来调用此方法
     * 
     * @param userData
     * @param analysisContext
     */
    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
        LOGGER.info(">>> 读取到一行数据：{}", userData);
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

    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        LOGGER.error(">>> 解析一行数据失败：", exception);
        // 如果是某一个单元格的转换异常 能获取到具体行号
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException =
                    (ExcelDataConvertException) exception;
            LOGGER.error(">>> 第{}行，第{}列解析异常", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex());
        }
        // 可以抛出异常，或者忽略此行继续读取下一行
    }
}
