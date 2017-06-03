package com.fanyank.controller;

import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by yanfeng-mac on 2017/6/1.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/auth/login",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userLogin(@RequestBody Map requestBody, HttpServletResponse response) {
        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        System.out.println("username->" + username);
        System.out.println("password->" + password);
        User user = userService.findByUsername(username);

        if (userService.isNull(user)) {
            return "false";
        } else {
            return "true";
        }


    }

    @RequestMapping(value = "/user/{id:\\d+}/profile",method = RequestMethod.GET)
    @ResponseBody
    public User getUserProfile(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;

    }


    @RequestMapping(value = "/user/{id:\\d+}/profile1",method = RequestMethod.GET)
    @ResponseBody
    public User getUserProfile1(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;

    }

}
