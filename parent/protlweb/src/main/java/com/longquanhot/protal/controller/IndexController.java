package com.longquanhot.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {
private Logger logger =Logger.getLogger(this.getClass().getSimpleName());
    @RequestMapping("/index")
    public String index() {
        logger.log(Level.INFO,"index");
        return "index";
    }


}
