package com.cheny.base.abstracts;

/**
 * 
 * @author Chen Yi
 * 抽象类与接口类的比较
 */
public class AbstractChild extends CompareWithInterface {

    /**
     * return super class string
     */
    @Override
    public String getTest() throws Exception {
        return super.getTest1();
    }

    /*getU方法*/
    public void getU() {
    }

    public void getOverload() {

    }

    public void getOverload(String s1) {

    }

    public void getOverload(Integer i1) {
    }
}
