package test.com.cheny.admin.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cheny.admin.bean.AdminUser;
import com.cheny.admin.bean.AdminUserRole;
import com.cheny.admin.dao.AdminManageDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "TransactionManager", defaultRollback = true)
public class AdminDaoTest {

    @Autowired
    AdminManageDao adminManageDao;

    @Test
    public void test() throws Exception {
        AdminUser user = adminManageDao.getAdminUser("18200390321");
        Assert.assertNotNull(user);
        List<AdminUserRole> roles = adminManageDao.getAdminUserRoleList(user.getNo());
        Assert.assertNotNull(roles);
    }

}
