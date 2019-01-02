package com.adonai.oauth2.mapper;

import com.adonai.oauth2.entity.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 定义用到UserMapper
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    public UserPojo findByName(String name);

    @Select("SELECT * FROM user WHERE mobile = #{mobile}")
    public UserPojo findByMobile(String mobile);

    @Select("SELECT * FROM user WHERE mail = #{mail}")
    public UserPojo findByMail(String mail);
}