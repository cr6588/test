package com.cheny.web.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="users")
public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1873691592301189514L;

    /**
     * `user`.id
     * @ibatorgenerated 2015-05-19 16:21:43
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    /**
     * `user`.username
     * @ibatorgenerated 2015-05-19 16:21:43
     */
    @Column(name="username",length=20)
    private String username;

    /**
     * `user`.password
     * @ibatorgenerated 2015-05-19 16:21:43
     */
    @Column(name="password",length=10)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}