package com.cheny.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheny.test.dao.TestDao;
import com.cheny.web.bean.I18n;

@Service
public class I18nSer {

    @Autowired
    private TestDao testDao;

    public List<I18n> getI18n(Map<String, Object> params) throws Exception {
        return testDao.getI18n(params);
    }
}
