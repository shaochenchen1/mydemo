package com.example.springboot_web_rest.controller;

import com.example.springboot_web_rest.entity.Result;
import com.example.springboot_web_rest.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestController
 * @Description 适用于微服务架构直接的远程调用
 * @Author Administrator
 * @DATE 2022/4/23 0023 13:09
 * @VERSION 1.0
 **/
@RestController
public class OrderController {
    //声明了RestTemplate
    private  final RestTemplate restTemplate;
    //当bean 没有无参构造函数的时候，spring将自动拿到有参构造函数，参数进行自动注入
    public OrderController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @RequestMapping("/order")
    public String order(){
        //基于restTemplate 查询
      /*  Result forObject = restTemplate.getForObject("http://localhost:8080/user/{id}", Result.class, 1);
        return  forObject.toString();*/

      /*  //基于restTemplate 添加
        User user=new User("shaochenchen","宁波");
        //url:  请求远程rest url
        //object:post请求参数
        //Class<T>:返回的类型
        //...object:是@PathVairable 占位符的参数
        ResponseEntity<Result> resultResponseEntity = restTemplate.postForEntity("http://localhost:8080/user/add", user, Result.class);
        System.out.println(resultResponseEntity.toString());
       return resultResponseEntity.getBody().toString();
*/
      /*  //基于restTemplate 修改
        User user=new User(1,"scc","宁波111");
        HttpEntity<User> userHttpEntity = new HttpEntity<>(user);
        //restTemplate.put("http://localhost:8080/user/add", user, Result.class);
        ResponseEntity<Result> resultResponseEntity = restTemplate.exchange("http://localhost:8080/user/{id}", HttpMethod.PUT, userHttpEntity, Result.class, 1);
        System.out.println(resultResponseEntity.toString());
        return resultResponseEntity.getBody().toString();*/
      // 基于restTemplate 删除
        ResponseEntity<Result> resultResponseEntity = restTemplate.exchange("http://localhost:8080/user/{id}", HttpMethod.DELETE, null, Result.class, 1);
        System.out.println(resultResponseEntity.toString());
        return  resultResponseEntity.getBody().toString();
    }
}
