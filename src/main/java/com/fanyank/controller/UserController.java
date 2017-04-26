package com.fanyank.controller;

import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by yanfeng-mac on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String userMsg(@PathVariable Integer id,Model model) {
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "users/show";
    }
}