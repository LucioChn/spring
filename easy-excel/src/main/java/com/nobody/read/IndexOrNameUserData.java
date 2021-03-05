package com.nobody.read;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description 推荐要么全部使用index，要么全部使用value
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@Data
public class IndexOrNameUserData {
    // 用名字匹配，如果名字重复，会导致只有一个字段读取到数据，即第一个读到的列（靠左列）
    @ExcelProperty(value = "年龄")
    private int age;
    // 避免2个字段同时用，只要有一个字段不匹配就读取失败
    @ExcelProperty(index = 2, value = "生日")
    private Date birthday;
    // 下标指定
    @ExcelProperty(index = 0)
    private String name;
}
