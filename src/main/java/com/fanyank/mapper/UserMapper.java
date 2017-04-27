package com.fanyank.mapper;

import com.fanyank.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/4/25.
 */
@Component
public interface UserMapper {
//    @Select(value = "select * from t_user where id = #{id}")
    public User findById(Integer id);

//    @Insert(value = "insert into t_user(username,password,gender) values(#{username},#{password},#{gender})")
    public void insertUser(User user);

    @Select(value = "select * from t_user where username = #{username}")
    public User findByUsername(String username);


    public Integer saveUser(User user);

    public List<User> findAllUser();

    public Integer findAllUserCount();

    @Delete(value = "delete from t_user where id = #{id}")
    public void deleteUser(Integer id);

    public void updateUser(User user);

    public List<User> serarchByUsername(String username);
}
