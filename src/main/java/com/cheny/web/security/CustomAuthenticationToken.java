package com.cheny.web.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = -4363888749504841244L;

    private String answer;
    private Integer questionId;

    public CustomAuthenticationToken(Object principal, Object credentials, Integer questionId, String answer) {
        super(principal, credentials);
        this.answer = answer;
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

}
