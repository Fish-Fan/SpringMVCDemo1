package com.fanyank.controller;

import com.fanyank.pojo.User;
import com.fanyank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(@RequestParam String username, String password, RedirectAttributes redirectAttributes,Model model) {
        User user = userService.findByUsername(username);
        if(userService.isNull(user)) {
            redirectAttributes.addFlashAttribute("message","该账号不存在，请重新输入");
            return "redirect:/users/login";
        } else {
            if(password == null || "".equals(password) || !password.equals(user.getPassword())) {
                redirectAttributes.addFlashAttribute("message","密码错误，请重新输入");
                return "redirect:/users/login";
            } else {
                model.addAttribute("user",user);
                return "users/show";
            }
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }

//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String registerUser(@RequestParam String username,String password,String gender,RedirectAttributes redirectAttributes,Model model) {
//        User user = userService.findByUsername(username);
//        if(userService.isNull(user)) {
//            user = new User();
//            user.setUsername(username);
//            user.setPassword(password);
//            Integer genderIn = new Integer(gender);
//            user.setGender(genderIn);
//
//            userService.saveUser(user);
//
//            redirectAttributes.addFlashAttribute("message","注册成功，现在可以登陆啦!");
//            return "redirect:/users/login";
//        } else {
//            redirectAttributes.addFlashAttribute("message","用户名已被注册，请重新输入!");
//            return "redirect:/users/register";
//        }
//    }

    @RequestMapping(value = "/registeruser",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String registerUser(String username,String password,String gender) {
        User user = userService.findByUsername(username);
        if(userService.isNull(user)) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Integer genderIn = new Integer(gender);
            user.setGender(genderIn);

            userService.saveUser(user);

            return "success";

        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("userList",userService.findAllUser());
        model.addAttribute("allUserCount",userService.findAllUserCount());
        return "users/list";
    }

    @RequestMapping(value = "/del")
    public String deleteUser(@RequestParam String id,RedirectAttributes redirectAttributes) {
        if("".equals(id) || id == null) {
            redirectAttributes.addFlashAttribute("message","参数错误，请重新执行操作");
            return "redirect:/users/list";
        } else {
            Integer userID = new Integer(id);
            userService.deleteUser(userID);

            redirectAttributes.addFlashAttribute("message","删除成功");
            return "redirect:/users/list";
        }
    }

    @RequestMapping(value = "/update")
    public String updateUser(@RequestParam String id,RedirectAttributes redirectAttributes,Model model) {
        if("".equals(id) || id == null) {
            redirectAttributes.addFlashAttribute("message","参数错误，请重新执行操作");
            return "redirect:/users/list";
        } else {
            User user = userService.findById(new Integer(id));
            model.addAttribute("user",user);
            return "users/update";
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUserPost(@RequestParam String username,String password,String gender,RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(username);
        user.setPassword(password);
        user.setGender(new Integer(gender));

        userService.updateUser(user);

        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/users/list";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam(required = false) String value,RedirectAttributes redirectAttributes,Model model) {
        if("".equals(value) || value == null) {
            return "users/search";
        } else {
            List<User> userList = userService.searchByUsername(value);

            model.addAttribute("userList",userList);
            redirectAttributes.addFlashAttribute("count",userList.size());

            return "users/search";
        }
    }

    @RequestMapping(value = "validate/username",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String validateUsername(@RequestParam String username) {
        User user = userService.findByUsername(username);
        if(userService.isNull(user)){
            return "true";
        } else {
            return "false";
        }
    }

}