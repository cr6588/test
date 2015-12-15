package com.cheny.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cheny.admin.bean.AdminUser;
import com.cheny.admin.bean.AdminUserRole;
import com.cheny.admin.service.AdminSer;

public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    public static Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    AdminSer adminSer;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 转换为自定义的token
        CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
        String poem = LoginQuestion.getQuestions().get(token.getQuestionId());
        // 校验下一句的答案是否正确
        if (!poem.split("/")[1].equals(token.getAnswer())) {
            throw new BadAnswerException("the answer is wrong!");
        }
        // throw new BadAnswerException("the answer is wrong!"); 抛出认证异常则认证失败
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        User user = null;
        AdminUser adminUser = null;
        try {
            adminUser = adminSer.getAdminUser(username);
            String password = authentication.getCredentials().toString();
            if (adminUser == null) {
                throw new BadAnswerException("the user does not exist!");
            }
            if (!adminUser.getPassword().equals(password)) {
                throw new BadAnswerException("the password is wrong!"); // 抛出认证异常则认证失败
            }

            List<AdminUserRole> roles = adminSer.getAdminUserRoleList(adminUser.getNo());
            if (roles == null) {
                throw new BadAnswerException("the user has not any auth!");
            }
            Collection<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
            for (AdminUserRole role : roles) {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.getAdminRole().getName());
                auths.add(auth);
            }
            user = new User(username, authentication.getCredentials().toString(), auths);
        } catch (BadAnswerException e) {
            logger.info(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("get user info from db error !");
            throw new BadAnswerException("get user info from db error !");
        }
        return user;
    }
}
