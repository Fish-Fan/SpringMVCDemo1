package com.fanyank.service;

import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yanfeng-mac on 2017/4/25.
 */

@Named
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

}
