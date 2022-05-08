package com.example.scc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/23 0023 12:01
 * @VERSION 1.0
 **/
@ApiModel(value = "user对象",description = "用户对象user")
public class User {
    @ApiModelProperty(value = "用户id")
    @JsonIgnore
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户地址")
    private String address;
    @JsonFormat( pattern = "yyyy-MM-dd hh:mm:ss" ,locale = "zh")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(Integer id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(Integer id, String username, String address, Date birthday) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.birthday = birthday;
    }
}
