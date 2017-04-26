package com.fanyank.mapper;

import com.fanyank.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by yanfeng-mac on 2017/4/25.
 */

public interface UserMapper {
//    @Select(value = "select * from t_user where id = #{id}")
    public User findById(Integer id);

//    @Insert(value = "insert into t_user(username,password,gender) values(#{username},#{password},#{gender})")
    public void insertUser(User user);
}
