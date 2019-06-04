package com.longquanhot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 * 图片上传
 */
@RestController
public class PicLoadController {


    @RequestMapping("/pic/upload")
    public String upLoadPic(@RequestParam(value = "uploadFile", required = false) MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        //获取输入流
        InputStream inputStream = multipartFile.getInputStream();
        byte[] bytes = new byte[1024];

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        while (inputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }
        fileOutputStream.close();
        inputStream.close();
        return "success";
    }

}
