package com.fanyank.service;

import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/4/25.
 */

@Named
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID查找User
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 根据username查找User
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * User是否为空
     * @param user
     * @return
     */
    public boolean isNull(User user) {
        if(user == null)
            return true;
        return false;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    /**
     * 查找所有User
     * @return
     */
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    /**
     * 查找所有用户数量
     * @return
     */
    public Integer findAllUserCount() {
        return userMapper.findAllUserCount();
    }

    /**
     * 根据ID删除用户
     * @param id
     */
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 模糊搜索User
     * @param username
     * @return
     */
    public List<User> searchByUsername(String username) {
        return userMapper.serarchByUsername(username);
    }

}
