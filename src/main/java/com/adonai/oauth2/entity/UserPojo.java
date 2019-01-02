package com.adonai.oauth2.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 定义用户表实体
 */
@Data
public class UserPojo implements Serializable {

    private Integer id;
    private String name;
    private String mobile;
    private String mail;
    private String pwd;

    public UserPojo() {
    }
}