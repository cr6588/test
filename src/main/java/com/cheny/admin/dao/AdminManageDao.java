package com.cheny.admin.dao;

import java.util.List;

import com.cheny.admin.bean.AdminUser;
import com.cheny.admin.bean.AdminUserRole;

public interface AdminManageDao {

    public AdminUser getAdminUser(String username) throws Exception;

    public List<AdminUserRole> getAdminUserRoleList(Long userNo) throws Exception;
}
