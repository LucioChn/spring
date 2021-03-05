package com.nobody.read;

import java.util.Date;

import com.alibaba.excel.metadata.CellData;

import lombok.Data;

/**
 * @Description 接收每一行数据的实体类
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@Data
public class CellDataReadUserData {
    private CellData<String> string;
    private CellData<Double> doubleData;
    // 这里注意 虽然是日期 但是 类型 存储的是number 因为excel 存储的就是number
    private CellData<Date> date;
}
