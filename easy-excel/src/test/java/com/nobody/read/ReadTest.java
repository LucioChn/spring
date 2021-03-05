package com.nobody.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
public class ReadTest {

    /**
     * 最简单的读
     */
    @Test
    public void simpleRead() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, UserData.class, new UserDataListener()).sheet().doRead();
    }

    /**
     * 最简单的读
     */
    @Test
    public void simpleRead01() {
        String fileName = "D:\\demo.xlsx";
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName, UserData.class, new UserDataListener()).build();
            ReadSheet readSheet = EasyExcel.readSheet(1).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 切记关闭，读的时候会创建临时文件，不关闭磁盘会崩的
                excelReader.finish();
            }
        }
    }

    /**
     * 最简单的读，指定列的下标或者列名
     */
    @Test
    public void simpleRead02() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, IndexOrNameUserData.class, new IndexOrNameUserDataListener())
                .sheet().doRead();
    }

    /**
     * 最简单的读，日期、数字或者自定义格式转换
     */
    @Test
    public void simpleRead03() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, ConverterUserData.class, new ConverterUserDataListener()).sheet()
                .doRead();
    }

    /**
     * 最简单的读，日期、数字或者自定义格式转换（全局指定）
     */
    @Test
    public void simpleRead04() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, ConverterUserData.class, new ConverterUserDataListener())
                // 全局指定自定义转换器， 即所有java为string,excel为string的都会用这个转换器
                .registerConverter(new CustomStringConverter()).sheet().doRead();
    }
}
