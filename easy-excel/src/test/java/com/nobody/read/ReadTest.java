package com.nobody.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
public class ReadTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTest.class);

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

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     */
    @Test
    public void repeatedRead() {
        String fileName = "D:\\demo.xlsx";
        // doReadAll,读取全部sheet
        EasyExcel.read(fileName, UserData.class, new UserDataListener()).doReadAll();
    }

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     */
    @Test
    public void repeatedRead01() {
        String fileName = "D:\\demo.xlsx";
        // 读取部分sheet
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName).build();

            // 可以针对不同sheet设置不同的表头和不同的回调监听器，演示就简单设置一样的
            ReadSheet readSheet1 = EasyExcel.readSheet(0).head(UserData.class)
                    .registerReadListener(new UserDataListener()).build();
            ReadSheet readSheet2 = EasyExcel.readSheet(1).head(UserData.class)
                    .registerReadListener(new UserDataListener()).build();
            // 这里注意一定要把sheet1,sheet2一起传进去，不然有个问题就是03版的excel会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2);
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }
    }

    /**
     * headRowNumber指定多行头，默认为1，也可以通过UserData里面的属性注解来指定
     */
    @Test
    public void complexHeaderRead() {
        String fileName = "D:\\demo.xlsx";
        EasyExcel.read(fileName, UserData.class, new UserDataListener()).sheet(2)
                // 设置表头的行数，默认是1行一行。也可以通过UserData里面的属性注解的ExcelProperty#value()的表头数量来指定
                .headRowNumber(1).doRead();
    }

    /**
     * 同步返回数据，不推荐使用，如果数据量大会把内存撑爆
     */
    @Test
    public void synchronousRead() {
        String fileName = "D:\\demo.xlsx";
        List<UserData> list = EasyExcel.read(fileName).head(UserData.class).sheet().doReadSync();
        list.forEach(data -> LOGGER.info(">>> 读取到一行数据：{}", data));

        // 通过map返回
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();
        for (Map<Integer, String> data : listMap) {
            // 每条数据的列下标和列值
            LOGGER.info(">>> 读取到一行数据：{}", data);
        }
    }

    /**
     * 最简单的读（读取表头数据）
     */
    @Test
    public void simpleReadWithHead() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, UserData.class, new UserDataWithHeadListener()).sheet().doRead();
    }

    /**
     * 读取公式和单元格类型
     */
    @Test
    public void simpleReadWithCell() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, CellDataReadUserData.class, new CellDataUserDataListener()).sheet()
                .doRead();
    }

    /**
     * 不通过具体类对象存储读取
     */
    @Test
    public void simpleReadWithMap() {
        String fileName = "D:\\demo.xlsx";
        // 读取第一个sheet，最后文件流会自动关闭
        EasyExcel.read(fileName, new OnMapDataListener()).sheet().doRead();
    }
}
