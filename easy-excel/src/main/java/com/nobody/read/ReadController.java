package com.nobody.read;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/3/4
 * @Version 1.0
 */
@RestController
@RequestMapping("read")
public class ReadController {

    /**
     * 上传文件
     * 
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UserData.class, new UserDataListener()).sheet()
                .doRead();
        return "ok";
    }
}
