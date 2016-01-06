package com.cheny.struts;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("basePackage") //是与struts.xml中的basePackage相对应吗？
@Action(value="struts2Test")  //使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action，Action的名字为struts2Test
@Namespace("/")
public class StrutsAction {

    //访问路径为/struts2Test!test.action
    public void test() {
        System.out.println("进入TestAction!");
    }
}
