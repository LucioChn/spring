package com.nobody.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/5
 * @Version 1.0.0
 */
public class WriteTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteTest.class);

    // 简单写数据
    @Test
    public void simpleWrite() {
        String fileName = "D:\\simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, UserData.class).sheet("模板").doWrite(getData());
    }

    // 简单写数据
    @Test
    public void simpleWrite01() {
        String fileName = "D:\\simpleWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, UserData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(getData(), writeSheet);
        } finally {
            // 切记关闭
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    // 包括或排除指定的列
    @Test
    public void excludeOrIncludeWrite() {
        String fileName = "D:\\excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";

        // 需要排除的列字段名
        Set<String> excludeColumnFiledNames = new HashSet<>();
        excludeColumnFiledNames.add("address");
        EasyExcel.write(fileName, UserData.class).excludeColumnFiledNames(excludeColumnFiledNames)
                .sheet("模板").doWrite(getData());

        fileName = "D:\\excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";

        // 指定包含的列
        Set<String> includeColumnFiledNames = new HashSet<>();
        includeColumnFiledNames.add("name");
        includeColumnFiledNames.add("age");
        EasyExcel.write(fileName, UserData.class).includeColumnFiledNames(includeColumnFiledNames)
                .sheet("模板").doWrite(getData());
    }

    // 指定下标写数据
    @Test
    public void indexWrite() {
        String fileName = "D:\\indexWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, IndexUserData.class).sheet("模板").doWrite(getData());
    }

    // 复杂头写数据
    @Test
    public void complexHeadWrite() {
        String fileName = "D:\\complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ComplexHeadUserData.class).sheet("模板").doWrite(getData());
    }

    // 复杂头写数据
    @Test
    public void complexHeadWrite01() {
        String fileName = "D:\\complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ComplexHeadUserData01.class).sheet("模板").doWrite(getData());
    }



    public List<UserData> getData() {
        List<UserData> dataList = new ArrayList<>(16);
        for (int i = 1; i <= 10; i++) {
            UserData data = new UserData();
            data.setAddress("深圳市" + i);
            data.setAge(i);
            data.setBirthday(new Date());
            data.setName("用户" + i);
            dataList.add(data);
        }
        return dataList;
    }
}
