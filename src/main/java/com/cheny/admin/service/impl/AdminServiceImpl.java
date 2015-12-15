package com.cheny.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheny.admin.bean.AdminUser;
import com.cheny.admin.bean.AdminUserRole;
import com.cheny.admin.dao.AdminManageDao;
import com.cheny.admin.service.AdminSer;

@Service
public class AdminServiceImpl implements AdminSer {

    @Autowired
    AdminManageDao adminDao;
    @Override
    public AdminUser getAdminUser(String username) throws Exception {
        return adminDao.getAdminUser(username);
    }

    @Override
    public List<AdminUserRole> getAdminUserRoleList(Long userNo) throws Exception {
        return adminDao.getAdminUserRoleList(userNo);
    }

}
