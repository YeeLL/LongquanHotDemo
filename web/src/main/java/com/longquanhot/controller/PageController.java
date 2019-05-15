package com.longquanhot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面访问器
 *
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
