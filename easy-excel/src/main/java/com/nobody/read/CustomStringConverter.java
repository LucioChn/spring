package com.nobody.read;

        import com.alibaba.excel.converters.Converter;
        import com.alibaba.excel.enums.CellDataTypeEnum;
        import com.alibaba.excel.metadata.CellData;
        import com.alibaba.excel.metadata.GlobalConfiguration;
        import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Description 自定义转换类
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
public class CustomStringConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    // 读时用到
    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) throws Exception {
        return "Hello " + cellData.getStringValue();
    }

    // 写时用到
    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData<>(value);
    }
}
