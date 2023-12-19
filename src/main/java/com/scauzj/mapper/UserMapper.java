package com.scauzj.mapper;

import com.github.pagehelper.Page;
import com.scauzj.dto.UserPageQueryDTO;
import com.scauzj.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    @Select("select * from user where phone = #{phone}")
    User getByPhone(String phone);

    @Insert("insert into user(username, password, name, phone) values(#{username}, #{password}, #{name}, #{phone})")
    void insert(User user);

    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    void updateByAdmin(User user);

    @Update("update user set password = #{password} where id = #{id}")
    void resetPassword(Integer id, String password);

    @Select("select * from user where id = #{id}")
    User getById(Integer id);

    void updateByUser(User user);
}

