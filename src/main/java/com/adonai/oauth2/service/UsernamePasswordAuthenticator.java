package com.adonai.oauth2.service;

import com.adonai.oauth2.dao.AbstractPreparableIntegrationAuthenticator;
import com.adonai.oauth2.entity.IntegrationAuthenticationEntity;
import com.adonai.oauth2.entity.UserPojo;
import com.adonai.oauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 定义密码登录认证器
 */
@Component
@Primary
public class UsernamePasswordAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("name");
        String pwd = entity.getAuthParameter("pwd");
        if(name == null || pwd == null){
            throw new OAuth2Exception("用户名或密码不能为空");
        }
        UserPojo pojo = mapper.findByName(name);
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder != null && encoder.matches(pwd,pojo.getPwd())){
            return pojo;
        }
        return null;
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return StringUtils.isEmpty(entity.getAuthType());
    }
}