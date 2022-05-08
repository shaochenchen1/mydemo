package com.example.springboot_web_rest.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/23 0023 12:01
 * @VERSION 1.0
 **/
public class User {
    private Integer id;
    private String username;
    private String address;

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

    public User(String username, String address) {
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
}
