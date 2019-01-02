package com.adonai.oauth2.service;

import com.adonai.oauth2.context.IntegrationAuthenticationContext;
import com.adonai.oauth2.dao.IntegrationAuthenticator;
import com.adonai.oauth2.entity.IntegrationAuthenticationEntity;
import com.adonai.oauth2.entity.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 集成认证-用户细节服务
 */
@Service
public class IntegrationUserDetailsService implements UserDetailsService {

    private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }

    @Override
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
        //从ThreadLocal获取线程私有数据
        IntegrationAuthenticationEntity entity = IntegrationAuthenticationContext.get();
        if (entity == null){
            entity = new IntegrationAuthenticationEntity();
        }

        UserPojo pojo = this.authenticate(entity);
        if (pojo == null){
            throw new UsernameNotFoundException("登录失败");
        }
        User user = new User(pojo.getName(),pojo.getPwd(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROOT_USER"));
        return user;
    }

    private UserPojo authenticate(IntegrationAuthenticationEntity entity) {
        if (this.authenticators != null) {
            for (IntegrationAuthenticator authenticator : authenticators) {
                if (authenticator.support(entity)) {
                    return authenticator.authenticate(entity);
                }
            }
        }
        return null;
    }
}