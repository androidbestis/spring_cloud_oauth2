package com.adonai.oauth2;

import org.springframework.security.crypto.bcrypt.BCrypt;

//生成BCryptPasswordEncoder加密验证
public class GenerateEncodePwd {

   public static void main(String args[]){

      //加密
      String password = "lxd";
      String pwt = BCrypt.hashpw(password, BCrypt.gensalt());
      System.out.println("加密: " + pwt);

      //解密
  /*    String encodedPwd = "$2a$10$hcMi5tIUGGGim/Xe0Z7q4e5Zz3QlK.EAek3an3nZf0B.ZdN0GJgSe";
      boolean pswFlag = BCrypt.checkpw(password,encodedPwd);
      System.out.println("解密: "+ pswFlag);*/


   }
}
