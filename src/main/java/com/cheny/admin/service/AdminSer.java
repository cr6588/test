package com.cheny.admin.service;

import java.util.List;

import com.cheny.admin.bean.AdminUser;
import com.cheny.admin.bean.AdminUserRole;

public interface AdminSer {
    public AdminUser getAdminUser(String username) throws Exception;

    public List<AdminUserRole> getAdminUserRoleList(Long userNo) throws Exception;
}
