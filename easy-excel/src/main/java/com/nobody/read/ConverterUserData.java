package com.nobody.read;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@Data
public class ConverterUserData {

    // 使用自定义格式
    @ExcelProperty(index = 0, converter = CustomStringConverter.class)
    private String name;
    // 格式化数字为百分比，转为String类型
    @ExcelProperty(index = 1)
    @NumberFormat("#.##%")
    private String age;
    // 格式化日期，转为String类型
    @ExcelProperty(index = 2)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private String birthday;
}
