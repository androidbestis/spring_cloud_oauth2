package com.adonai.oauth2.context;

import com.adonai.oauth2.entity.IntegrationAuthenticationEntity;

/**
 * 定义集成认证上下文
 */
public class IntegrationAuthenticationContext {

    private static ThreadLocal<IntegrationAuthenticationEntity> holder = new ThreadLocal<IntegrationAuthenticationEntity>();

    public static void set(IntegrationAuthenticationEntity entity){
        holder.set(entity);
    }

    public static IntegrationAuthenticationEntity get(){
        return holder.get();
    }

    public static void clear(){
        holder.remove();
    }
}