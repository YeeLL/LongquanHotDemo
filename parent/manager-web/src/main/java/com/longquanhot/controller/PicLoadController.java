package com.longquanhot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;


/**
 * 图片上传
 */
@RestController
public class PicLoadController {


    @RequestMapping("/pic/upload")
    public HashMap<String, Object> upLoadPic(@RequestParam(value = "uploadFile",required = false) MultipartFile uploadFile) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String fileName = uploadFile.getOriginalFilename();
            System.out.println(fileName);
            //获取输入流
            InputStream inputStream = uploadFile.getInputStream();
            byte[] bytes = new byte[1024];

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            while (inputStream.read(bytes) != -1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
            inputStream.close();
            //todo 后面换其他方式
            map.put("error", 0);
            map.put("url", "http://s3.sinaimg.cn/original/006gAAj7ty6YWHgxiF452&690");
            return map;
        } catch (IOException e) {
            map.put("error", 1);
            map.put("message", "图片上传失败");
            return map;
        }
    }

}
