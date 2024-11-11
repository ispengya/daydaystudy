package com.ispengya.mapper;

import com.ispengya.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(@Param("user") User user);

    List<User> selectUserByUserName(@Param("username") String username);
}
