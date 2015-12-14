package com.cheny.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {


        // if (!request.getMethod().equals("POST")) {
        // throw new AuthenticationServiceException(
        // "Authentication method not supported: "
        // + request.getMethod());
        // }

        String username = obtainUsername(request).toUpperCase().trim();
        String password = obtainPassword(request);
        //获取用户输入的下一句答案
        String answer = obtainAnswer(request);
        //获取问题Id(即: hashTable的key)
        Integer questionId = obtainQuestionId(request);

        //这里将原来的UsernamePasswordAuthenticationToken换成我们自定义的CustomAuthenticationToken
        CustomAuthenticationToken authRequest = new CustomAuthenticationToken(
                username, password, questionId, answer);

        //这里就将token传到后续验证环节了
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest); //会调用CustomAuthenticationProvider里的retrieveUser方法
    }

    protected String obtainAnswer(HttpServletRequest request) {
        return request.getParameter(answerParameter);
    }

    protected Integer obtainQuestionId(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter(questionIdParameter));
    }

    private String questionIdParameter = "questionId";
    private String answerParameter = "answer";

    public String getQuestionIdParameter() {
        return questionIdParameter;
    }

    public void setQuestionIdParameter(String questionIdParameter) {
        this.questionIdParameter = questionIdParameter;
    }

    public String getAnswerParameter() {
        return answerParameter;
    }

    public void setAnswerParameter(String answerParameter) {
        this.answerParameter = answerParameter;
    }
}
