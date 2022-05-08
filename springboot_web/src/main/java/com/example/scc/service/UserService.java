package com.example.scc.service;

import com.example.scc.entity.User;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/23 0023 12:22
 * @VERSION 1.0
 **/
@Component
public class UserService {
    private  static Map<Integer, User> users=new HashMap<>();
    static {
        users.put(1,new User(1,"zhangsan","北京",new Date()));
        users.put(2,new User(2,"lisi","上海"));
        users.put(3,new User(3,"wangwu","深圳"));
        users.put(4,new User(4,"scc","杭州"));
        users.put(5,new User(5,"zss", "宁波"));
    }

    /**
     *@Author ShaoChenChen
     *@Description //根据id查询用户
     *@Date 12:34 2022/4/23 0023
     *@Param [id]
     *@return com.example.scc.entity.User
     **/
    public User getUserByid(Integer id){
        return users.get(id);
    }
    /** 
     *@Author ShaoChenChen
     *@Description //查询所有用户
     *@Date 12:35 2022/4/23 0023
     *@Param 
     *@return  
     **/
    public List<User> getAllUser(){
        return  new ArrayList(users.values());
    }
    /**
     *@Author ShaoChenChen
     *@Description //更新用户
     *@Date 12:36 2022/4/23 0023
     *@Param
     *@return
     **/
    public  void update(User user){
        users.replace(user.getId(),user);
    }
    /** 
     *@Author ShaoChenChen
     *@Description //新增用户
     *@Date 12:37 2022/4/23 0023
     *@Param 
     *@return  
     **/  
    public  void add(User user){
        Integer newId=users.size()+1;
        user.setId(newId);
        users.put(newId,user);
    }
    /**
     *@Author ShaoChenChen
     *@Description //删除
     *@Date 12:38 2022/4/23 0023
     *@Param
     *@return
     **/
    public void delete(Integer id) {
        users.keySet().removeIf(key -> key == id);
    }
}
