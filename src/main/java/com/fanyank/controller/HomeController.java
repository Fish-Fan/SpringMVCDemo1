package com.fanyank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yanfeng-mac on 2017/4/24.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}