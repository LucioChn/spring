package com.nobody.write;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @Description 接收每一行数据的实体类
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@Data
public class ComplexHeadUserData {
    @ExcelProperty(value = {"用户信息", "姓名"}, index = 0)
    private String name;
    @ExcelProperty(value = "年龄", index = 1)
    private int age;
    @ExcelProperty(value = "生日", index = 2)
    private Date birthday;
    // 忽略此字段
    @ExcelIgnore
    private String address;
}
