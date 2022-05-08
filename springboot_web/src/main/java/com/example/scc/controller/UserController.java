package com.example.scc.controller;

import com.example.scc.entity.Result;
import com.example.scc.entity.User;
import com.example.scc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/23 0023 12:22
 * @VERSION 1.0
 **/
@RestController
@Api(value = "用户controller",tags = {"用户操作接口"})
@RequestMapping("/user")
public class UserController  {
    @Autowired
    UserService userService;
    @Autowired
    MessageSource messageSource;

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id",value = "用户id",defaultValue = "99",required = true)
    public Result getUser(@PathVariable Integer id){
        String message = messageSource.getMessage("user.query.success", null, LocaleContextHolder.getLocale());
        User user=userService.getUserByid(id);
        return new Result<>(200,message,user);

    }
    //新增
    @PostMapping("/add")
    public Result addUser(@RequestBody  User user){
        userService.add(user);
        return new Result(200,"新增成功",userService.getAllUser());

    }
    //修改
    @PutMapping("/{id}")
    public Result editUser(@RequestBody User user){
        userService.update(user);
        return  new Result(200,"修改成功",userService.getAllUser());

    }
    //删除
    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:8081")
    public  Result deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return  new Result(200,"删除成功",userService.getAllUser());
    }

}
