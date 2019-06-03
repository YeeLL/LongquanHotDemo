package com.longquanhot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page){
        return page;
    }
}
