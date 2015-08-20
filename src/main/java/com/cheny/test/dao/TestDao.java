package com.cheny.test.dao;

import java.util.List;
import java.util.Map;

import com.cheny.web.bean.I18n;

public interface TestDao {

    public List<I18n> getI18n(Map<String, Object> param) throws Exception;
}
