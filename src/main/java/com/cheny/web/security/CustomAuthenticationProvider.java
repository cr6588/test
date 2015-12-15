package com.cheny.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 转换为自定义的token
        CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
        String poem = LoginQuestion.getQuestions().get(token.getQuestionId());
        // 校验下一句的答案是否正确
        if (!poem.split("/")[1].equals(token.getAnswer())) {
            throw new BadAnswerException("the answer is wrong!");
        }
//        throw new BadAnswerException("the answer is wrong!"); 抛出认证异常则认证失败
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails userDetails = new MyUserDetailService().loadUserByUsername(username);
        return userDetails;
    }

}
