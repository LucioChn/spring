package com.nobody.read;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @Description 接收每一行数据的实体类
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@Data
public class UserData {
    // 忽略此字段
    @ExcelIgnore
    private String address;
    private String name;
    private int age;
    private Date birthday;
}
