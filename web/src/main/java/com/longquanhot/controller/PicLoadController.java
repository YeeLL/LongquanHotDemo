package com.longquanhot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图片上传
 */
@RestController
public class PicLoadController {


    @RequestMapping("/pic/upload")
    public String upLoadPic() {
        return "";
    }

}
