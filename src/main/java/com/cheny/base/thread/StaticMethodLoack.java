package com.cheny.base.thread;

import com.cheny.web.util.StringUtil;

public class StaticMethodLoack implements Runnable {

    @Override
    public void run() {
        StringUtil.isBlank("11");
    }

}
