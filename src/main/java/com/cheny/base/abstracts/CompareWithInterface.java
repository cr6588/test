package com.cheny.base.abstracts;

public abstract class CompareWithInterface {

    private String test;
    protected String username;

    protected abstract String getTest() throws Exception;

    public String getTest1() throws Exception {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTest(String test) {
        this.test = test;
    }

}
