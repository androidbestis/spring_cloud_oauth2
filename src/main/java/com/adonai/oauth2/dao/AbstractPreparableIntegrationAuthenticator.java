package com.adonai.oauth2.dao;

import com.adonai.oauth2.entity.IntegrationAuthenticationEntity;

/**
 * 定义集成认证-认证器抽象类
 */
public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }
}