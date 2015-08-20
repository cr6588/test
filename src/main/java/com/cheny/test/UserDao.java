package com.cheny.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

public class UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<User> getAllUser(){
        //User指的是实体对象不是表名！但表名需与实体名相对应，实体名users,2张表user,users查找结果会是从users中查找，如果一张表是user,另一张是usersssssssss打印的sql是select user0_.id as id1_0_, user0_.password as password2_0_, user0_.username as username3_0_ from users user0_
        String hsql="from users";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        return query.list();
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
    }
}
